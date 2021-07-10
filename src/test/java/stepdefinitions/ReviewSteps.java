package stepdefinitions;

import io.appium.java_client.MobileElement;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.ProductPage;
import utilities.AppiumUtils;

public class ReviewSteps {

    ProductPage productPage = new ProductPage();

    String reviewSpecs;

    @Then("I can add following review with clicking Add Review button:")
    public void i_can_add_following_review_with_clicking_add_review_button(DataTable reviewDt) {
        String reviewTxt = productPage.generateReview(reviewDt.cell(0,0));
        //use reviewSpecs to locate review after save
        reviewSpecs = reviewTxt +" "+ reviewDt.cell(0,1);

        productPage.addReview(reviewTxt, reviewDt.cell(0,1));
    }

    @Then("add review {string};")
    public void add_review(String expectedResult) {
        MobileElement reviewEl = AppiumUtils.scrollTo(reviewSpecs);
        Assert.assertNotNull("review is not in the list", reviewEl);
    }
}
