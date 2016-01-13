package de.jwausle.vertx;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;

import java.io.File;
import java.io.IOException;
import java.util.function.Consumer;

/**
 * Created by winter on 13.01.16.
 */
public class ServerRunner {
    public static void main(String[] args) {
        Class<Server> clazz = Server.class;
        final String rootdir = "build/" + clazz.getPackage().getName().replace(".", "/");
        final String verticleID = clazz.getName();

        runExample(rootdir, verticleID, new VertxOptions().setClustered(false));
    }

    public static void runExample(String exampleDir, String verticleID, VertxOptions options) {
        assert verticleID != null : "VerticleID must be NOT null.";
        assert options != null : "VertexOptions must be NOT null.";
        // Smart cwd detection

        // Based on the current directory (.) and the desired directory (exampleDir), we try to compute the vertx.cwd
        // directory:
        try {
            // We need to use the canonical file. Without the file name is .
            File current = new File(".").getCanonicalFile();
            if (exampleDir.startsWith(current.getName()) && !exampleDir.equals(current.getName())) {
                exampleDir = exampleDir.substring(current.getName().length() + 1);
            }
        } catch (IOException e) {
            // Ignore it.
        }

        System.setProperty("vertx.cwd", exampleDir);
        Consumer<Vertx> runner = vertx -> {
            try {
                vertx.deployVerticle(verticleID);
            } catch (Throwable t) {
                t.printStackTrace();
            }
        };
        Vertx vertx = Vertx.vertx(options);
        runner.accept(vertx);
    }
}
