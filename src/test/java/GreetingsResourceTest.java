import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

import org.junit.Test;

public class GreetingsResourceTest {
    
    private static final String BASE_URL = "/rest-test/resources";
    private static final String SALUTATION = "hello world!";
    
    private String greetingsPathExpr = "%s/greetings";
    
    Map<String, String> testData = new HashMap<String, String>() {{
        put("firstName", "Ricardo");
        put("lastName", "Buitrago-Carvajal");
    }};
 
    @Test
    public void testHelloWorldUnmatchedUserGoesDefaultPath() {
        get(String.format(greetingsPathExpr, BASE_URL))
            .then()
            .body("salutation", equalTo(SALUTATION));
    }
    
    @Test
    public void testHelloUserSuccess() {
        get(String.format("%s/greetings/%s", BASE_URL, testData.get("firstName")))
            .then()
            .body("salutation", equalTo(String.format("hello, %s", testData.get("firstName"))));
    }
    
    @Test
    public void testPostSalutationReturnsValidXml() {
        
        given()
            .formParams(testData)
            .when()
            .post(String.format(greetingsPathExpr, BASE_URL))
            .then()
            .body("greeting.firstName", equalTo(testData.get("firstName")))
            .and()
            .body("greeting.lastName", equalTo(testData.get("lastName")));
    }

}
