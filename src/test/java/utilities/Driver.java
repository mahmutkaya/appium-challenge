package utilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {

    public static AndroidDriver<MobileElement> driver;
    private static DesiredCapabilities desiredCapabilities;

    public static void main(String[] args) {
        setUp();
    }

    public static void setUp() {
        try {
            File classpathRoot = new File(System.getProperty("user.dir"));
            File app = new File(classpathRoot, ConfigReader.getProperty("app"));

            desiredCapabilities = new DesiredCapabilities();

            desiredCapabilities.setCapability("platformName", ConfigReader.getProperty("platformName"));
            desiredCapabilities.setCapability("platformVersion", ConfigReader.getProperty("platformVersion"));
            desiredCapabilities.setCapability("deviceName", ConfigReader.getProperty("deviceName"));
            desiredCapabilities.setCapability("app", app.getAbsolutePath());
            desiredCapabilities.setCapability("appPackage", ConfigReader.getProperty("appPackage"));
            desiredCapabilities.setCapability("appActivity", ConfigReader.getProperty("appActivity"));

            driver = new AndroidDriver<>(new URL(ConfigReader.getProperty("url")), desiredCapabilities);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static void closeDriver() {
        //Close driver if it is not null
        if (driver!=null) {
            driver.quit();
            driver=null;
        }
    }

}
