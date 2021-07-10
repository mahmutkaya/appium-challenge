package utilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class AppiumUtils {

    public static boolean isElementVisible(MobileElement el) {
        try {
            el.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    //===============Explicit Wait==============//
    public static MobileElement waitForVisibility(MobileElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        return (MobileElement) wait.until(ExpectedConditions.visibilityOf(element));
    }

    //==========Return a list of string given a list of Mobile Element====////
    public static List<String> getElementsText(List<MobileElement> list) {
        List<String> elemTexts = new ArrayList<>();
        for (MobileElement el : list) {
            if (!el.getText().isEmpty()) {
                elemTexts.add(el.getText());
            }
        }

        return elemTexts;
    }

    public static MobileElement scrollTo(String visibleText) {
        MobileElement el = null;
        try{
            el = ((AndroidDriver<MobileElement>) Driver.getDriver())
                    .findElementByAndroidUIAutomator(
                            "new UiScrollable(" +
                                    "new UiSelector().scrollable(true).instance(0))" +
                                    ".scrollIntoView(new UiSelector()" +
                                    ".textContains(\"" + visibleText + "\").instance(0))"
                    );
        }catch(org.openqa.selenium.NoSuchElementException e){
            System.out.println("an element with "+visibleText+" could not be located");
        }
        return el;
    }

    public static void clickListElementByText(
            List<MobileElement> list,
            String elText
    ) {
        List<String> txtList = getElementsText(list);
        //make sure that the list has element
        Assert.assertTrue(elText + " does not exist", txtList.contains(elText));
        for (MobileElement e : list) {
            if (!e.getText().isEmpty() && e.getText().equals(elText)) {
                e.click();
                //exit loop after clicking the desired element
                return;
            }
        }
    }
}
