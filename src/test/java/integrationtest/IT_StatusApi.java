package integrationtest;

import io.github.jorgeviana.openchatlondon.OpenChat;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

public class IT_StatusApi {

    private static final String BASE_URL = "http://localhost:4321";
    private static final OpenChat openChat = new OpenChat();

    @BeforeClass
    public static void setUp() {
        startServer();
    }

    @AfterClass
    public static void tearDown() {
        stopServer();
    }

    private static void startServer() {
        openChat.start();
        openChat.awaitInitialization();
    }

    private static void stopServer() {
        openChat.stop();
    }

    @Test public void
    check_status() {
        given()
                .when().get(BASE_URL + "/status")
                .then().statusCode(200)
                .body(is("OpenChat: OK!"));
    }
}
