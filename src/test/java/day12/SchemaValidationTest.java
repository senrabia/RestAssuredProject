package day12;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utility.ConfigurationReader;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class SchemaValidationTest {

    // LETS JUMP RIGHT IN !!!
    @BeforeAll
    public static void init() {
        // spartan1.base_url=http://54.174.216.245:8000
        RestAssured.baseURI = ConfigurationReader.getProperty("spartan1.base_url");
        RestAssured.basePath = "/api";
    }

    @DisplayName("Testing GET /Spartans response against Schema")
    @Test
    public void testAllSpartansSchema(){

        when()
            .get("/spartans").
        then()
            .body(matchesJsonSchemaInClasspath("AllSpartansSchema.json") ) ;

    }


}
