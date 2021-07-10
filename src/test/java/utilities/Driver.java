package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver() {
    }

    private static AppiumDriver<MobileElement> driver;

    public static AppiumDriver<MobileElement> getDriver() {
        //If the driver is already pointing somewhere( being used )
        //We want to have only one driver
        if (driver == null) {
            try {
                File classpathRoot = new File(System.getProperty("user.dir"));
                File app = new File(classpathRoot, ConfigReader.getProperty("app"));

                DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

                desiredCapabilities.setCapability("platformName", ConfigReader.getProperty("platformName"));
                desiredCapabilities.setCapability("platformVersion", ConfigReader.getProperty("platformVersion"));
                desiredCapabilities.setCapability("deviceName", ConfigReader.getProperty("deviceName"));
                desiredCapabilities.setCapability("app", app.getAbsolutePath());
                desiredCapabilities.setCapability("appPackage", ConfigReader.getProperty("appPackage"));
                desiredCapabilities.setCapability("appActivity", ConfigReader.getProperty("appActivity"));

                URL url = new URL(ConfigReader.getProperty("url"));
                driver = new AndroidDriver<>(url, desiredCapabilities);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }

    public static void closeDriver() {
        //Close driver if it is not null
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
