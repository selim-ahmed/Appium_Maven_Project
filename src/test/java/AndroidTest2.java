import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidTest2 {

    AppiumDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {

        DesiredCapabilities dc = new DesiredCapabilities();
        //dc.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
        dc.setCapability("platformName", "android");
        dc.setCapability("automationName", "UiAutomator2" );
        dc.setCapability("platformVersion", "11");
        dc.setCapability("deviceName", "Android Emulator");
        dc.setCapability("appPackage","com.nopstation.nopcommerce.nopstationcart");
        dc.setCapability("appActivity","com.bs.ecommerce.main.SplashScreenActivity");

        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"),dc);

    }

    @Test
    public void testApp(){

    }

    @AfterTest
    public void testDown(){
        if(null!=driver){
            driver.quit();
        }
    }

}
