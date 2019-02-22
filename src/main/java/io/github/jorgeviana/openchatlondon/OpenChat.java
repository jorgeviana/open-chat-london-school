package io.github.jorgeviana.openchatlondon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Spark;

import static spark.Spark.before;
import static spark.Spark.internalServerError;
import static spark.Spark.notFound;
import static spark.Spark.port;

public class OpenChat {

    private static Logger logger = LoggerFactory.getLogger(OpenChat.class);

    private static final String API_NOT_IMPLEMENTED = "API not implemented.";
    private static final String INTERNAL_SERVER_ERROR = "Internal server error.";

    private Routes routes = new Routes();
    private final int port;

    public OpenChat(int port) {
        this.port = port;
    }

    public void start() {
        port(this.port);
        enableCORS();
        setLog();
        routes.create();
        configureInternalServerError();
        configureNotImplemented();
    }

    public void stop() {
        Spark.stop();
    }

    public void awaitInitialization() {
        Spark.awaitInitialization();
    }

    private void enableCORS() {
        before((req, res) -> {
            res.header("Access-Control-Allow-Origin", "*");
            res.header("Access-Control-Allow-Headers", "*");
            res.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, PATCH, OPTIONS");
        });
    }

    private void setLog() {
        before((req, res) -> {
            logger.info("URL request: " + req.requestMethod() + " " + req.uri() + " - headers: " + req.headers());
        });
    }

    private void configureInternalServerError() {
        internalServerError((req, res) -> {
            res.status(501);
            logger.error(INTERNAL_SERVER_ERROR + ": " + req.pathInfo());
            return INTERNAL_SERVER_ERROR;
        });
    }

    private void configureNotImplemented() {
        notFound((req, res) -> {
            res.status(501);
            logger.error(API_NOT_IMPLEMENTED + ": " + req.pathInfo());
            return API_NOT_IMPLEMENTED;
        });
    }
}
