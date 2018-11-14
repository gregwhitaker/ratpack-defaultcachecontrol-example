package ratpack.example.api;

import ratpack.example.api.cacheable.GetCacheHandler;
import ratpack.example.api.cacheable.GetNoCacheHandler;
import ratpack.example.api.noncacheable.PostHandler;
import ratpack.func.Action;
import ratpack.handling.Chain;

public class ApiHandlers implements Action<Chain> {

    @Override
    public void execute(Chain chain) throws Exception {
        chain.get("api/v1/get", GetCacheHandler.class);
        chain.get("api/v1/getwithoutcache", GetNoCacheHandler.class);
        chain.post("api/v1/post", PostHandler.class);
    }
}
