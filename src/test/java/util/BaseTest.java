package util;

import org.testng.annotations.BeforeMethod;

import static io.restassured.RestAssured.*;

public class BaseTest {

    @BeforeMethod
    public void beforeEach() {

        baseURI = "http://localhost:8080";

    }

}
