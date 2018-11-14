package ratpack.example;

import ratpack.example.api.ApiHandlers;
import ratpack.example.api.ApiModule;
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
                .baseDir(BaseDir.find())
                .build();

        RatpackServer.start(s -> s
                .serverConfig(serverConfig)
                .registry(Guice.registry(b -> b
                        .module(ApiModule.class))
                )
                .handlers(chain -> chain
                        .insert(ApiHandlers.class)
                )
        );
    }
}
