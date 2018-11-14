package ratpack.example.api.cacheable;

import ratpack.handling.Context;
import ratpack.handling.Handler;

public class GetCacheHandler implements Handler {

    @Override
    public void handle(Context ctx) throws Exception {
        ctx.render("This is the GetCacheHandler and it's cache-control is explicitly set to: max-age=3600");
    }
}
