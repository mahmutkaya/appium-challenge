package stepdefinitions;

import io.appium.java_client.MobileElement;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.ProductPage;
import utilities.AppiumUtils;

import java.util.List;

public class ReviewSteps {

    ProductPage productPage = new ProductPage();

    String reviewSpecs;

    @Then("I can add following review with clicking Add Review button:")
    public void i_can_add_following_review_with_clicking_add_review_button(DataTable reviewDt) {
        reviewSpecs = reviewDt.cell(0,0) + " " + reviewDt.cell(0,1);
        productPage.addReview(reviewDt.cell(0,0), reviewDt.cell(0,1));
    }

    @Then("add review {string};")
    public void add_review(String expectedResult) {
        MobileElement reviewEl = AppiumUtils.scrollTo(reviewSpecs);
        System.out.println("reviewEl.getText() = " + reviewEl.getText());
        boolean isVisible = AppiumUtils.isElementVisible(reviewEl);

        Assert.assertTrue("review is not in the list", isVisible);

    }
}
