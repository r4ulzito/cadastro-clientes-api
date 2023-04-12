package funcional;

import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CadastroClienteTest {

    /*
     <- Exemplo de BDD Cadastro de Cliente ->
    Dado nome, idade e email válidos
    Quando uma requisição POST for efetuada para o endpoint "/clientes"
    Então deverá retorar o status code 201
     */

    private static final String BASE_ENDPOINT = "http://localhost:8080/clientes";

}
