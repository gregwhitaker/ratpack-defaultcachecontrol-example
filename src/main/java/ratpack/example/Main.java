package ratpack.example;

import ratpack.example.api.ApiHandlers;
import ratpack.example.api.ApiModule;
import ratpack.example.api.filter.CacheControlFilter;
import ratpack.example.api.filter.FilterModule;
import ratpack.guice.Guice;
import ratpack.server.BaseDir;
import ratpack.server.RatpackServer;
import ratpack.server.ServerConfig;

/**
 * Starts the ratpack-defaultcachecontrol-example application.
 */
public class Main {

    public static void main(String... args) throws Exception {
        ServerConfig serverConfig = ServerConfig.builder()
                .yaml("config.yml")
                .baseDir(BaseDir.find())
                .build();

        RatpackServer.start(s -> s
                .serverConfig(serverConfig)
                .registry(Guice.registry(b -> b
                        .module(ApiModule.class)
                        .module(FilterModule.class))
                )
                .handlers(chain -> chain
                        .all(new CacheControlFilter())
                        .insert(ApiHandlers.class)
                )
        );
    }
}
