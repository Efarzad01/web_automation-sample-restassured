package openWeather;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;

public class GetRequestTest {

    public static String url = "https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22";

    @Test
    public void testResponseCode() {
        int status = get(url).getStatusCode();
        Assert.assertEquals(status, 200);
    }
    @Test
    public void testResponseTime() {
        long time = get(url).getTime();
        Assert.assertTrue(time > 0.0);
    }
    @Test
    public void testResponseCity() {
        JsonPath jsonPathEvaluator = get(url).jsonPath();
        String city = jsonPathEvaluator.get("name");
        Assert.assertEquals(city, "London");
    }
    @Test
    public void testResponseID() {
        JsonPath jsonPathEvaluator = get(url).jsonPath();
        int id = jsonPathEvaluator.get("id");
        Assert.assertEquals(id, 2643743);
    }
}
