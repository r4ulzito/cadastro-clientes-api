package utils.client;

import br.com.cadastro.cliente.api.domain.dto.CriaClienteRequest;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import utils.Constantes;

import static io.restassured.RestAssured.given;

public class ClienteClient {

    public static ValidatableResponse cadastraCliente(CriaClienteRequest clienteData) {

        return given()
                .body(clienteData)
                .contentType(ContentType.JSON)
                .when()
                .post(Constantes.CLIENTE_PATH)
                .then();

    }

}
