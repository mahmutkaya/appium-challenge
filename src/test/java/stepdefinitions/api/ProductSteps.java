package stepdefinitions.api;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;

import pojos.Product;
import utilities.ApiUtils;
import utilities.ConfigReader;

import java.util.List;

public class ProductSteps {

    static {
        RestAssured.baseURI = ConfigReader.getProperty("products_base_uri");
    }

    private Response response;
    private String endpoint = "/product";

    public static List<Product> products;

    @Given("(I want to create/update )a product with the following attributes:")
    public void a_product_with_the_following_attributes(List<Product> productDt) {
        this.products = productDt;
    }

    //----------- create -----------\\
    @When("I save the new product {string}")
    public void i_save_the_new_product(String testCase) {
        response = ApiUtils.post(endpoint, products.get(0));
    }
    //----------- get -----------\\
    @When("I want to get product by id {string}")
    public void i_want_to_get_product_by_id(String id) {
        response = ApiUtils.get(endpoint +"/"+ id);
    }
    //----------- update -----------\\
    @When("I save the product {string}")
    public void i_save_the_product(String string) {
        Product p = products.get(0);
        response = ApiUtils.put(endpoint +"/"+ p.getId(), p);
    }
    //----------- delete -----------\\
    @When("I want to delete product by id {string}")
    public void i_want_to_delete_product_by_id(String id) {
        response = ApiUtils.delete(endpoint +"/"+ id);
    }

    @When("the product is already exist")
    public void the_product_is_already_exist() {
        int statusCode = ApiUtils.get(endpoint+"/"+products.get(0).getId()).statusCode();
        if (statusCode != 200) ApiUtils.post(endpoint, products.get(0));
    }

    @Then("the save/get/delete {string}")
    public void the_save_get_delete(String expectedResult) {
        if (expectedResult.equals("FAILS")) {
            response.then().assertThat().statusCode(allOf(greaterThan(399), lessThan(505)));
        }
        if (expectedResult.equals("IS SUCCESSFUL")) {
            response.then().assertThat().statusCode(anyOf(is(200), is(201)));
        }
    }

    @Then("following product is returned:")
    public void following_product_is_returned(List<Product> productDt) {
        Product p = productDt.get(0);

        response.then().assertThat().body(
                "name", equalTo(p.getName()),
                "id", equalTo(p.getId()),
                "description", equalTo(p.getDescription()),
                "imgUrl", equalTo(p.getImgUrl()),
                "currency", equalTo(p.getCurrency()),
                "price", equalTo(p.getPrice())
        );

        /**
         * we could convert response to java object then make assertion
         * but hamcrest assertion will give us more clear debugging
         *
         * Product product = response.as(Product.class);
         * Assert.assertEquals(p, product);
         */
    }
}
