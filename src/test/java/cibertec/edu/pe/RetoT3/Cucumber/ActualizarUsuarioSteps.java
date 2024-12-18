package cibertec.edu.pe.RetoT3.Cucumber;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.hasEntry;



public class ActualizarUsuarioSteps {

    private Response response;

    @When("actualizo el usuario con id {int} con los datos {string} como {string} y {string} como {string}")
    public void actualizarUsuario(int idUsuario, String clave1, String valor1, String clave2, String valor2) {
        Map<String, String> datosActualizados = new HashMap<>();
        datosActualizados.put(clave1, valor1);
        datosActualizados.put(clave2, valor2);

        response = RestAssured
                .given()
                .contentType("application/json")
                .body(datosActualizados)
                .put("/users/" + idUsuario);
    }

    @Then("los campos actualizados deben coincidir con los datos enviados")
    public void validarCamposActualizados(Map<String, String> datosEsperados) {
        response.then().body("$", hasEntry("name", datosEsperados.get("name")))
                .and().body("$", hasEntry("job", datosEsperados.get("job")));
    }

    @Then("la respuesta debe coincidir con el esquema de actualizar usuario")
    public void validarEsquemaActualizarUsuario() {
        response.then().body(matchesJsonSchemaInClasspath("schemas/actualizar_usuario_schema.json"));
    }
}