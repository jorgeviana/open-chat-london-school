package integrationtest;

import com.eclipsesource.json.JsonObject;
import org.junit.Test;

import static integrationtest.Server.BASE_URL;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.matchesPattern;
import static org.hamcrest.core.Is.is;

public class IT_RegistrationApi {

    private static final String UUID_PATTERN = "[0-9a-fA-F]{8}(?:-[0-9a-fA-F]{4}){3}-[0-9a-fA-F]{12}";

    @Test public void
    register_a_new_user() {
        given()
                .body(withJsonContaining("Lucy", "dafdsf", "About Lucy"))

                .when()
                .post(BASE_URL + "/users")

                .then()
                .statusCode(201)
                .contentType(JSON)
                .body("id", matchesPattern(UUID_PATTERN))
                .body("username", is("Lucy"))
                .body("about", is("About Lucy"));
    }



    private String withJsonContaining(String username, String password, String about) {
        return new JsonObject()
                .add("username", username)
                .add("password", password)
                .add("about", about)
                .toString();
    }
}
