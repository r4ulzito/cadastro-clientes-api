package funcional;

import br.com.cadastro.cliente.api.domain.dto.CriaClienteRequest;

import org.springframework.http.HttpStatus;
import org.testng.annotations.Test;
import util.BaseTest;
import util.client.ClienteClient;

import static org.hamcrest.Matchers.*;

public class CadastroClienteTest extends BaseTest {

    /*
     <- Exemplo de BDD ->
    Dado nome, idade e email válidos
    Quando uma requisição POST for efetuada para "/clientes"
    Então deverá retorar o status code 201 com dados do cliente
     */
    @Test
    public void deveRetornarStatus201AoCadastrarCliente() {

        CriaClienteRequest clienteData = CriaClienteRequest.builder()
                .nome("Nome Teste")
                .idade(20)
                .email("email@email.com")
                .build();

        ClienteClient.cadastraCliente(clienteData)
                .statusCode(HttpStatus.CREATED.value())
                .body("nome", equalTo("Nome Teste"))
                .body("idade", equalTo(20))
                .body("email", equalTo("email@email.com"));
    }

    @Test
    public void deveRetornar400AoNaoEnviarNomeDoCliente() {

        CriaClienteRequest clienteData = CriaClienteRequest.builder()
                .idade(20)
                .email("email@email.com")
                .build();

        ClienteClient.cadastraCliente(clienteData)
                .statusCode(400)
                .body("message", equalTo("O campo nome é obrigatório!"));
    }

    @Test
    public void deveRetornar400AoEnviarIdadeDoClienteZerada() {

        CriaClienteRequest clienteData = CriaClienteRequest.builder()
                .nome("Nome Teste")
                .idade(0)
                .email("email@email.com")
                .build();

        ClienteClient.cadastraCliente(clienteData)
                .log().all()
                .statusCode(400)
                .body("message", equalTo("Idade inválida!"));
    }

}
