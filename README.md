### O que é Rest Assured

Rest-Assured é uma ferramenta desenvolvida para facilitar a criação de testes automatizados para APIs REST.
Esta oferece suporte para validar protocolo HTTP e requisições em JSON. Sua sintaxe é baseada em Behavior Driven
Development(BDD), uma métodologia de testes, baseadas no comportamento do usuário.

- [Documentação do Rest Assured](https://rest-assured.io/)

### 1. Inserindo o REST Assured no projeto

- O Rest Assured necessita de um executor de testes unitários como [JUnit](https://junit.org/junit5/)
  ou [TestNG](https://testng.org/doc/index.html)
- Dependencia no Maven

    ```xml
    <dependency>
          <groupId>io.rest-assured</groupId>
          <artifactId>rest-assured</artifactId>
          <version>5.3.0</version>
          <scope>test</scope>
    </dependency>
    ```

- Imports necessários para testes

    ```java
    import static io.restassured.RestAssured.*;
    import static io.restassured.matcher.RestAssuredMatchers.*;
    import static org.hamcrest.Matchers.*;
    ```

### 2. Exemplo  Teste de cadastro de um Cliente

```java

/*
  <- Exemplo de BDD ->
 Dado nome, idade e email válidos
 Quando uma requisição POST for efetuada para "/clientes"
 Então deverá retorar o status code 201
*/

@Test
public void deveRetornarStatus201AoCadastrarCliente(){

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
        .body("nome",equalTo("Nome Teste"));
        }
```
