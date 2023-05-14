package filter;
import com.dxc.api.OrderService;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;

@Provider
public class PoweredByResponseFilter implements ContainerResponseFilter {
    private static Log log = LogFactory.getLog(PoweredByResponseFilter.class);
    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
            throws IOException {
        log.info("PoweredByResponseFilter running ... ");
        responseContext.getHeaders().add("X-Api-Version", "2.x");
        responseContext.getHeaders().add("X-Powered-By", "api.gpcoder.com");
    }
}
