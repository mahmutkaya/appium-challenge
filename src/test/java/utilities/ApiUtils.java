package utilities;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class ApiUtils {

    private static Response response;

    private static RequestSpecification getRequest(Object reqBody) {
        reqBody = reqBody != null ? reqBody : "";

        RequestSpecification request = given()
                .headers("Content-Type", "application/json")
                .body(reqBody)
                .when();
        return request;
    }

    public static Response post(String pathParams, Object reqBody) {
        try {
            response = getRequest(reqBody).post(pathParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    public static Response get(String pathParams) {
        try {
            response = getRequest(null).get(pathParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    public static Response put(String pathParams, Object reqBody) {
        try {
            response = getRequest(reqBody).put(pathParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    public static Response delete(String pathParams) {
        try {
            response = getRequest(null).delete(pathParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
}
