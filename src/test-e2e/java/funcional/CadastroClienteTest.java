package funcional;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CadastroClienteTest {

    /*
     <- Exemplo de BDD ->
    Dado nome, idade e email válidos
    Quando uma requisição POST for efetuada para o endpoint "/clientes"
    Então deverá retorar o status code 201
     */

    private static final String BASE_ENDPOINT = "http://localhost:8080/clientes";

}
