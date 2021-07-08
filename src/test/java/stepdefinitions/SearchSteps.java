package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import pojos.Product;
import stepdefinitions.api.ProductSteps;

import java.util.List;
import java.util.Map;

public class SearchSteps {

    HomePage homePage = new HomePage();

    Product product;

    Map<String,String> expectedProduct;
    List<Map<String,String>> actualProducts;

    @When("I want to search a product {string}")
    public void i_want_to_search_a_product(String searchTxt) {
        product = ProductSteps.products.get(0);
        expectedProduct.put("name", product.getName());
        expectedProduct.put("description", product.getDescription());
        expectedProduct.put("price", String.valueOf(product.getPrice()));

        actualProducts = homePage.getSearchResult(searchTxt);

    }

    @Then("the search {string}")
    public void the_search(String expectedResult) {
        if (expectedResult.equals("IS SUCCESSFUL")) {
            Assert.assertTrue(actualProducts.contains(expectedProduct));
        }
    }
}
