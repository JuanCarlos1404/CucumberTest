package cibertec.edu.pe.RetoT3.Cucumber;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class EliminarUsuarioSteps {

    private Response response;

    @When("elimino el usuario con id {int}")
    public void eliminarUsuario(int idUsuario) {
        response = RestAssured
                .delete("/users/" + idUsuario);
    }

    @Then("la respuesta no debe contener un cuerpo")
    public void validarRespuestaSinCuerpo() {
        assertTrue(response.getBody().asString().isEmpty());
    }
    @Then("la respuesta debe coincidir con el esquema de eliminar usuario")
    public void validarEsquemaEliminarUsuario() {
        response.then().body(matchesJsonSchemaInClasspath("schemas/eliminar_usuario_schema.json"));
    }
}