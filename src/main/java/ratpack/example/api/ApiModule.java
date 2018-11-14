package ratpack.example.api;

import com.google.inject.AbstractModule;
import ratpack.example.api.cacheable.GetCacheHandler;
import ratpack.example.api.cacheable.GetNoCacheHandler;
import ratpack.example.api.noncacheable.PostHandler;

public class ApiModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(ApiHandlers.class);

        // Handlers
        bind(GetCacheHandler.class);
        bind(GetNoCacheHandler.class);
        bind(PostHandler.class);
    }
}
