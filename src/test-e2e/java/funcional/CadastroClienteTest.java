package funcional;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class CadastroClienteTest {

    private static final String BASE_ENDPOINT = "http://localhost:8080/clientes";

    /*
    Dado nome, idade e email válidos
    Quando uma requisição POST for efetuada para "/clientes"
    Então deverá retorar o status code 201
     */

    @Test
    public void deveRetornarStatus201AoCadastrarCliente() {

        given()
                .body("""
                        {
                          "nome": "Nome Teste",
                          "idade": 20,
                          "email": "email@email.com"
                        }""")
                .contentType(ContentType.JSON)
                .when()
                .post(BASE_ENDPOINT)
                .then()
                .statusCode(201)
                .body("nome", equalTo("Nome Teste"));

    }

    @Test
    public void deveRetornar400AoNaoEnviarNomeDoCliente() {
        given()
                .body("""
                        {
                          "nome": "",
                          "idade": 20,
                          "email": "email@email.com"
                        }""")
                .contentType(ContentType.JSON)
                .when()
                .post(BASE_ENDPOINT)
                .then()
                .statusCode(400);
    }

}
