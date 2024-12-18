package cibertec.edu.pe.RetoT3.Cucumber;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;


import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.core.AllOf.allOf;


public class ObtenerUsuarioSteps {

    private Response response;

    @When("obtengo los usuarios de la página {int}")
    public void obtenerUsuarios(int pagina) {
        response = RestAssured
                .given()
                .queryParam("page", pagina)
                .get("/users");
    }

    @Then("la respuesta debe contener una lista de usuarios")
    public void validarListaUsuarios() {
        response.then().body("data", not(empty()));
    }

    @Then("cada usuario debe tener los campos {string}, {string}, {string} y {string}")
    public void validarCamposUsuario(String campo1, String campo2, String campo3, String campo4) {
        response.then().body("data[0]", allOf(
                hasKey(campo1),
                hasKey(campo2),
                hasKey(campo3),
                hasKey(campo4)
        ));
    }
    @Then("la respuesta debe coincidir con el esquema de usuarios")
    public void validarEsquemaUsuarios() {
        response.then().body(matchesJsonSchemaInClasspath("schemas/usuarios_schema.json"));
    }
}