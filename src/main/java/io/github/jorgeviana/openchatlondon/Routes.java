package io.github.jorgeviana.openchatlondon;

import static spark.Spark.get;

public class Routes {

    public void create() {
        openChatRoutes();
    }

    private void openChatRoutes() {
        get("status", (req, res) -> "OpenChat: OK!");
    }
}
