package filter;


import com.dxc.api.OrderService;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;

@Provider
public class AuthorizationRequestFilter implements ContainerRequestFilter {
    private static Log log = LogFactory.getLog(AuthorizationRequestFilter.class);
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        log.info("AuthorizationRequestFilter running ... ");

        // Must be logged-in to perform the delete action
        if ("DELETE".equals(requestContext.getMethod())
                && !hasToken(requestContext)) {
            Response response = Response.status(Response.Status.UNAUTHORIZED) //
                    .entity("User cannot access the resource.") //
                    .build();
            requestContext.abortWith(response);
        }
    }

    private boolean hasToken(ContainerRequestContext requestContext) {
        // Extract Authorization header details
        String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer")) {
            return false;
        }
        // Extract the token
        String token = authorizationHeader.substring("Bearer".length()).trim();
        System.out.println("token: " + token);
        return token != null && token.trim().length() > 0;
    }
}

