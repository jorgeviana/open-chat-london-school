package integrationtest;

import org.junit.Test;

import static integrationtest.Server.BASE_URL;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

public class IT_StatusApi {

    @Test public void
    check_status() {
        given()
                .when().get(BASE_URL + "/status")
                .then().statusCode(200)
                .body(is("OpenChat: OK!"));
    }
}
