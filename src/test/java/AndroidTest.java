
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AndroidTest {

    AppiumDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {

        DesiredCapabilities dc = new DesiredCapabilities();
        //dc.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
        dc.setCapability("platformName", "android");
        dc.setCapability("automationName", "UiAutomator2" );
        dc.setCapability("platformVersion", "11");
        dc.setCapability("deviceName", "Android Emulator");
        dc.setCapability("app", System.getProperty("user.dir")+"/apps/nopstationCart_4.40.apk");

        //dc.setCapability("appPackage", "");
        //dc.setCapability("appActivity", "");

        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"),dc);

    }

    @Test
    public void click_app_Button(){
        //code start
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //driver.findElement(AppiumBy.accessibilityId("NopStation Cart")).click();
        //driver.findElementsByAccessibilityId("NopStationCart").click();

        MobileElement accept = (MobileElement) driver.findElementById("com.nopstation.nopcommerce.nopstationcart:id/btnAccept");
        accept.click();

//        MobileElement menu = (MobileElement) driver.findElementsByAccessibilityId("NopStationCart");
//        menu.click();


        //code end


    }
    @AfterTest
    public void testDown(){
        if(null!=driver){
            driver.quit();
        }
    }


}
