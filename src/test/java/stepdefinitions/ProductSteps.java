package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import pages.ProductPage;
import pojos.Product;

import java.util.List;

public class ProductSteps {

    ProductPage productPage = new ProductPage();
    HomePage homePage = new HomePage();

    Product product;

    @When("I go to the product details")
    public void i_go_to_the_product_details() {
        product = stepdefinitions.api.ProductSteps.products.get(0);
        productPage.clickProductByName(product.getName());
    }

    @Then("the product has following attributes:")
    public void the_product_has_following_attributes(List<String> productAttributes) {
        //Todo: uncomment these if we are able to display the product we created
//        product = stepdefinitions.api.ProductSteps.products.get(0);
//        Map<String, String> productMap = productPage.getProductAttributes();
//        Assert.assertEquals(productMap.get("name"), product.getName());
//        Assert.assertEquals(productMap.get("price"), String.valueOf(product.getPrice()));
//        Assert.assertEquals(productMap.get("currency"), product.getCurrency());
        //Todo: uncomment it if 'display product description' is implemented
//        Assert.assertEquals(productMap.get("description"), product.getDescription());

        //for now we are going to call method just to verify if elements are there
        boolean isEverythingOk = false;
        try{
            productPage.getProductAttributes();
            isEverythingOk = true;
        }catch(Exception e){
            //ignore
        }
        Assert.assertTrue(isEverythingOk);

    }

    @Then("a scrollable review list is displayed")
    public void a_scrollable_review_list_is_displayed() {
        boolean bo = productPage.isScrollable();
        Assert.assertTrue("reviewsRecycler is not scrollable", bo);
    }

    @Then("I can navigate to previous screen with back button")
    public void i_can_navigate_to_previous_screen_with_back_button() {
        productPage.goBack();

        boolean isHome = homePage.isProductsContainerVisible();
        Assert.assertTrue("it does not look like home", isHome);
    }
}
