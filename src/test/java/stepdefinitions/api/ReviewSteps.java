package stepdefinitions.api;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojos.Review;
import utilities.ApiUtils;
import utilities.ConfigReader;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;

public class ReviewSteps {

    static {
        RestAssured.baseURI = ConfigReader.getProperty("reviews_base_uri");
    }

    private Response response;
    private String endpoint = "/reviews";

    public static List<Review> reviews;

    @Given("I want to add a review with the following attributes:")
    public void i_want_to_add_a_review_with_the_following_attributes(List<Review> reviewDt) {
        reviews = reviewDt;
    }

    @When("I save the new review {string}")
    public void i_save_the_new_review(String testCase) {
        endpoint = endpoint + "/" + ProductSteps.products.get(0).getId();
        response = ApiUtils.post(endpoint, reviews);
    }

    @Then("the add review {string}")
    public void the_add_review(String expectedResult) {
        if (expectedResult.equals("FAILS")) {
            response.then().assertThat().statusCode(allOf(greaterThan(399), lessThan(505)));
        }
        if (expectedResult.equals("IS SUCCESSFUL")) {
            response.then().assertThat().statusCode(anyOf(is(200), is(201)));
        }
    }

}
