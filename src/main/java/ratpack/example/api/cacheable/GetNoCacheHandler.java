package ratpack.example.api.cacheable;

import ratpack.handling.Context;
import ratpack.handling.Handler;

public class GetNoCacheHandler implements Handler {

    @Override
    public void handle(Context ctx) throws Exception {
        ctx.render("This is the GetNoCacheHandler and it's cache-control is set by the default cache-control filter.");
    }
}
