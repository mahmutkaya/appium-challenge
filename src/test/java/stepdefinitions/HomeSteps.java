package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.HomePage;
import utilities.Driver;

import java.util.List;

public class HomeSteps {

    HomePage homePage = new HomePage();

    @Given("I am on the home screen")
    public void i_am_on_the_home_screen() {
        //Todo: assert that 'go home!' button is not displayed
        boolean isHome = homePage.isProductsContainerVisible();
        Assert.assertTrue("it does not look like home", isHome);
    }

    @Then("header is displayed")
    public void header_is_displayed() {
        boolean isHeaderVisible = homePage.isHeaderVisible();
        Assert.assertTrue("Header Toolbar is not visible", isHeaderVisible);
    }

    @Given("the search input field is displayed")
    public void the_search_input_field_is_displayed() {
        boolean isSearchInputVisible = homePage.isSearchInputVisible();
        Assert.assertTrue("Search Input is not visible", isSearchInputVisible);
    }

    @Then("the more options dropdown is displayed")
    public void the_more_options_dropdown_is_displayed() {
        boolean isMoreOptionsDropdownVisible = homePage.isMoreOptionsDropdownVisible();
        Assert.assertTrue("More Options Dropdown is not visible", isMoreOptionsDropdownVisible);
    }

    @Then("the more options dropdown has following options:")
    public void the_more_options_dropdown_has_option(List<String> options) {
        List<String> optionsTxt = homePage.optionsText();
        //close dropdown after getting options text - for not interrupting next steps
        Driver.driver.navigate().back();
        Assert.assertEquals(optionsTxt, options);
    }

    @Then("the products have following attributes:")
    public void the_products_have_following_attributes(List<String> productAttributes) {
        boolean hasAttributes = homePage.hasProductAttributes();
        Assert.assertTrue(hasAttributes);
    }
}
