package utils;

import org.junit.jupiter.api.BeforeEach;

import static io.restassured.RestAssured.*;

public class BaseTest {

    @BeforeEach
    public void beforeEach() {

        baseURI = "http://localhost:8080";

    }

}
