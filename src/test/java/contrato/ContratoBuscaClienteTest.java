package contrato;

import org.springframework.http.HttpStatus;
import org.testng.annotations.Test;
import util.BaseTest;
import util.client.ClienteClient;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ContratoBuscaClienteTest extends BaseTest {

    @Test
    public void buscaClienteContratoTest() {

        String clienteId = "1";

        ClienteClient.buscaClientePorID(clienteId)
                .statusCode(HttpStatus.OK.value())
                .body(matchesJsonSchemaInClasspath("json_schema/buscaCliente.json"));

    }

}
