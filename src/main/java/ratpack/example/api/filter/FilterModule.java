package ratpack.example.api.filter;

import com.google.inject.AbstractModule;

public class FilterModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(CacheControlFilter.class);
    }
}
