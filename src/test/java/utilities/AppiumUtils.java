package utilities;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
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
        WebDriverWait wait = new WebDriverWait(Driver.driver, timeout);
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
        return Driver.driver
                .findElementByAndroidUIAutomator(
                        "new UiScrollable(" +
                                "new UiSelector().scrollable(true).instance(0))" +
                                ".scrollIntoView(new UiSelector()" +
                                ".textContains(\"" + visibleText + "\").instance(0))"
                );
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
