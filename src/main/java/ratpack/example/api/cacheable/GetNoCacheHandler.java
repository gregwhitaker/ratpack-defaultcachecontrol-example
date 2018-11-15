package ratpack.example.api.cacheable;

import ratpack.handling.Context;
import ratpack.handling.Handler;

public class GetNoCacheHandler implements Handler {

    @Override
    public void handle(Context ctx) throws Exception {
        ctx.render("Cache-Control header set in the Default Cache-Control Filter.");
    }
}
