package util.client;

import br.com.cadastro.cliente.api.domain.dto.CriaClienteRequest;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class ClienteClient {

    private static final String CLIENTE_PATH = "/clientes";

    public static ValidatableResponse cadastraCliente(CriaClienteRequest clienteData) {

        return given()
                .body(clienteData)
                .contentType(ContentType.JSON)
                .when()
                .post(CLIENTE_PATH)
                .then();

    }

    public static ValidatableResponse buscaClientePorID(String clienteId) {

        return when()
                .get(CLIENTE_PATH + "/" + clienteId)
                .then();

    }

}
