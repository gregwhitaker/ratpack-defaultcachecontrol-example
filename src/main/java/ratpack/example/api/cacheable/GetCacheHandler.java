package ratpack.example.api.cacheable;

import ratpack.handling.Context;
import ratpack.handling.Handler;

/**
 * Handler that has a cache-control header set and will not receive the default header.
 */
public class GetCacheHandler implements Handler {

    @Override
    public void handle(Context ctx) throws Exception {
        ctx.getResponse().getHeaders().add("Cache-Control", "max-age=3600");
        ctx.render("Cache-Control header set in handler");
    }
}
