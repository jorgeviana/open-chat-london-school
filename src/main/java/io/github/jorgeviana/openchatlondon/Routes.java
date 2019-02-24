package io.github.jorgeviana.openchatlondon;

import io.github.jorgeviana.openchatlondon.api.UsersAPI;

import static spark.Spark.get;
import static spark.Spark.post;

public class Routes {

    private UsersAPI usersAPI;

    public void create() {
        createAPIs();
        openChatRoutes();
    }

    private void createAPIs() {
        usersAPI = new UsersAPI();
    }

    private void openChatRoutes() {
        get("status", (req, res) -> "OpenChat: OK!");
        post("users", (req, res) -> usersAPI.createUser(req, res));
    }
}
