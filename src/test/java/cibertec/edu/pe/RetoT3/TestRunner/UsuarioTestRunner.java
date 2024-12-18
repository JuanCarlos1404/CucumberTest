package cibertec.edu.pe.RetoT3.TestRunner;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"cibertec.edu.pe.RetoT3.Cucumber"},
        plugin = {"pretty"}
)
public class UsuarioTestRunner {
}