package ratpack.example.api;

import com.google.inject.AbstractModule;
import ratpack.example.api.cacheable.GetWithCacheControl;
import ratpack.example.api.cacheable.GetWithoutCacheControl;
import ratpack.example.api.noncacheable.PostHandler;

public class ApiModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(ApiHandlers.class);

        // Handlers
        bind(GetWithCacheControl.class);
        bind(GetWithoutCacheControl.class);
        bind(PostHandler.class);
    }
}
