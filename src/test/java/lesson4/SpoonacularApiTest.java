package lesson4;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runners.MethodSorters;
import static io.restassured.RestAssured.given;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class SpoonacularApiTest {

   @Test
   public void aAddToShoppingListTest() {
        Response response = given()
                .queryParam("apiKey", "ce1efd1d2ba14ed1b63b0c66736224bc")
                .queryParam("username", "your-users-name365")
                .queryParam("hash", "56907371a22821c542b96429b1207ff9a41286ff")
                .body("{\n" +
                        "\t\"item\": \"1 banana\",\n" +
                        "\t\"aisle\": \"fruits\",\n" +
                        "\t\"parse\": true\n" +
                        "}")
                .log()
                .uri()
                .expect()
                .log()
                .body()
                .when()
                .post("https://api.spoonacular.com/mealplanner/your-users-name365/shopping-list/items")
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.statusCode());
        }

    @Test
    public void bGetShoppingListTest() {
        Response response = given()
                .queryParam("apiKey", "ce1efd1d2ba14ed1b63b0c66736224bc")
                .queryParam("username", "your-users-name365")
                .queryParam("hash", "56907371a22821c542b96429b1207ff9a41286ff")
                .contentType(ContentType.JSON)
                .when()
                .get("https://api.spoonacular.com/mealplanner/your-users-name365/shopping-list")
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.statusCode());
        }

    @Test
    public void cDeleteFromShoppingList() {
        Response response = given()
                .queryParam("apiKey", "ce1efd1d2ba14ed1b63b0c66736224bc")
                .queryParam("username", "your-users-name365")
                .queryParam("hash", "56907371a22821c542b96429b1207ff9a41286ff")
                .header("Content-type", "application/json")
                .when()
                .delete("https://api.spoonacular.com/mealplanner/your-users-name365/shopping-list/items/1299537?hash=56907371a22821c542b96429b1207ff9a41286ff")
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.statusCode());
    }

}
