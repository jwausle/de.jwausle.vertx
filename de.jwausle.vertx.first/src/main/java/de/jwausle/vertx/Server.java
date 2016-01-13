package de.jwausle.vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.http.HttpHeaders;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.StaticHandler;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Created by winter on 11.01.16.
 */
public class Server extends AbstractVerticle {
    public static class Coordinate {
        public final double x;
        public final double y;

        public Coordinate(double x) {
            this(x, x);
        }

        public Coordinate(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }
    public static  class Data{
        public final String link;
        public final Coordinate xy;

        public Data(String link, double x, double y){
            this(link,new Coordinate(x,y));
        }
        public Data(String link, Coordinate coordinate) {
            this.link = link;
            this.xy = coordinate;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "<a href=\"" + link + '"' + link +
                    "</a>, xy=" + xy +
                    '}';
        }
    }

    private final Map<String, Data> coordintates = new LinkedHashMap<>();

    public Server() {
        coordintates.put("Leipzig", new Data("wikipedia.org/wiki/Leipzig",new Coordinate(51.340333,12.37475)));
        coordintates.put("Stuttgart", new Data("wikipedia.org/wiki/Stuttgart",new Coordinate(48.775556,9.182778)));
        coordintates.put("Tres Coracoes",new Data("wikipedia.org/wiki/Tr%C3%AAs_Cora%C3%A7%C3%B5es",new Coordinate(-45.258333,-21.7)));
    }

    @Override
    public void start() throws Exception {
        Router router = Router.router(vertx);

        Object htmlText = html.hello.render("/get-town", "town", coordintates, null);

        router.route().handler(BodyHandler.create());
        router.route("/").handler(context -> {
            context
                    .response()
                    .putHeader("content-type", "text/html")
                    .end(htmlText.toString());
        });

        router.post("/get-town").handler(context -> {
            String townKey = context.request().getParam("town");
            Data townData = coordintates.get(townKey);
            String towns = "/get-town: " + context.request().getParam("town") + " : " + townData;
            System.out.println(towns);

            Object htmlText2 = html.hello.render("/get-town", "town", coordintates, townData);
            context
                    .response()
                    .putHeader(HttpHeaders.CONTENT_TYPE, "text/html")
                    .end(htmlText2.toString());
        });

        vertx.createHttpServer().requestHandler(router::accept).listen(8080);
        System.out.println("started ... http://localhost:8080");
    }

}
