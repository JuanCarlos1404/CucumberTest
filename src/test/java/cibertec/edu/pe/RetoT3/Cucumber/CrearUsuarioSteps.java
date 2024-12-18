package cibertec.edu.pe.RetoT3.Cucumber;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

public class CrearUsuarioSteps {
    private Response response;

    @Given("que la API está disponible")
    public void apiDisponible() {
        RestAssured.baseURI = "https://reqres.in/api";
    }

    @When("creo un usuario con los datos {string} como {string} y {string} como {string}")
    public void crearUsuario(String key1, String value1, String key2, String value2) {
        Map<String, String> userData = new HashMap<>();
        userData.put(key1, value1);
        userData.put(key2, value2);

        response = RestAssured
                .given()
                .contentType("application/json")
                .body(userData)
                .post("/users");
    }

    @Then("la respuesta debe tener un código de estado {int}")
    public void validarCodigoEstado(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("la respuesta debe contener los campos {string} y {string}")
    public void validarCampos(String field1, String field2) {
        response.then().body("$", hasKey(field1))
                .and().body("$", hasKey(field2));
    }

    @Then("la estructura de la respuesta debe coincidir con el esquema JSON esperado")
    public void validarEsquemaJson() {
        response.then().body(matchesJsonSchemaInClasspath("schemas/crearUsuario.JSON"));
    }
}