package ratpack.example.api.filter;

import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.http.HttpMethod;

/**
 * Handler that adds a default cache-control header to the response if one is not present.
 */
public class CacheControlFilter implements Handler {
    private static final String CACHE_CONTROL_HEADER = "Cache-Control";
    private static final String CACHE_CONTROL_HEADER_VALUE = "max-age=1";

    @Override
    public void handle(Context ctx) throws Exception {
        ctx.getResponse().beforeSend(response -> {
            // Only cache GET requests
            if (ctx.getRequest().getMethod() == HttpMethod.GET) {

                // Only set header if one is not already supplied
                if (!ctx.getResponse().getHeaders().contains(CACHE_CONTROL_HEADER)) {
                    ctx.getResponse().getHeaders().add(CACHE_CONTROL_HEADER, CACHE_CONTROL_HEADER_VALUE);
                }
            }
        });

        ctx.next();
    }
}
