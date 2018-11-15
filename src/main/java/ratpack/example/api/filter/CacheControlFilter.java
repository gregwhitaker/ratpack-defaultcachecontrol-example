package ratpack.example.api.filter;

import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.http.HttpMethod;

public class CacheControlFilter implements Handler {
    private static final String CACHE_CONTROL_HEADER = "Cache-Control";
    private static final String CACHE_CONTROL_HEADER_VALUE = "max-age=1";

    @Override
    public void handle(Context ctx) throws Exception {
        ctx.getResponse().beforeSend(response -> {
            if (ctx.getRequest().getMethod() == HttpMethod.GET) {
                if (!ctx.getResponse().getHeaders().contains(CACHE_CONTROL_HEADER)) {
                    ctx.getResponse().getHeaders().add(CACHE_CONTROL_HEADER, CACHE_CONTROL_HEADER_VALUE);
                }
            }
        });

        ctx.next();
    }
}
