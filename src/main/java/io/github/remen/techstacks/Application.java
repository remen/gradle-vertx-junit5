package io.github.remen.techstacks;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;

import java.util.concurrent.CompletableFuture;

public class Application {
    private final Vertx vertx = Vertx.vertx();
    private HttpServer server = vertx.createHttpServer();

    public static void main(String[] args) {
        System.out.println("Hello World");
    }

    public void start() {
        CompletableFuture<Void> isListening = new CompletableFuture<>();
        server
            .requestHandler(request ->
                request.response().setStatusCode(200).end()
            )
            .listen(8080, onListen -> {
                if (onListen.succeeded()) {
                    isListening.complete(null);
                } else {
                    isListening.completeExceptionally(onListen.cause());
                }
            });
        isListening.join();
    }

    public void stop() {
        server.close();
    }

    public int getPort() {
        return 8080;
    }
}
