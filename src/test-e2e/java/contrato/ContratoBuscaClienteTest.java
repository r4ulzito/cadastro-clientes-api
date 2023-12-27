package contrato;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import utils.BaseTest;
import utils.Constantes;

import java.io.File;

import static io.restassured.RestAssured.when;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class ContratoBuscaClienteTest extends BaseTest {

    @Test
    public void buscaClienteContratoTest() {

        String clienteId = "1";

        when()
                .get(Constantes.CLIENTE_PATH + "/" + clienteId)
                .then()
                .statusCode(HttpStatus.OK.value())
                .body(matchesJsonSchema(new File("src/test-e2e/resources/contrato/schema/busca_cliente_contrato_schema.json")));

    }

}
