package ratpack.example.api.noncacheable;

import ratpack.handling.Context;
import ratpack.handling.Handler;

/**
 * Handler that is a POST request and is thus not eligible to receive the default cache-control header.
 */
public class PostHandler implements Handler {

    @Override
    public void handle(Context ctx) throws Exception {
        ctx.render("No Cache-Control header set for POST reqeusts.");
    }
}
