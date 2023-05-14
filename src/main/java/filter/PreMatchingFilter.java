package filter;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.PreMatching;
import jakarta.ws.rs.ext.Provider;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;

@Provider
@PreMatching
public class PreMatchingFilter implements ContainerRequestFilter {
    private static Log log = LogFactory.getLog(PreMatchingFilter.class);
        @Override
        public void filter(ContainerRequestContext requestContext) throws IOException {
            log.info("PreMatchingFilter running ... ");
            if (requestContext.getMethod().equals("PUT")) {
                log.info("Change PUT methods to POST");
                requestContext.setMethod("POST");
            }
        }
    }

