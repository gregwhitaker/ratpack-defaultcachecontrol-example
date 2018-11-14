package ratpack.example.api.noncacheable;

import ratpack.handling.Context;
import ratpack.handling.Handler;

public class PostHandler implements Handler {

    @Override
    public void handle(Context ctx) throws Exception {
        ctx.render("This is the PostHandler and it is not cached.");
    }
}
