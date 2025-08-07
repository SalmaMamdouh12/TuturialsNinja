package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import static drivers.DriverFactory.getNewInstance;
import static drivers.DriverHolder.getDriver;
import static drivers.DriverHolder.setDriver;

public class TestBase {

    SoftAssert softAssert; //initial soft assertions

    @Parameters("browser")
    @BeforeTest
    public void setupDriver(String browser){

        setDriver(getNewInstance(browser)); //empty to choose default driver (headful chrome)
        getDriver().get("https://tutorialsninja.com/demo/");
    }

    @AfterTest
    public void teardown(){

        getDriver().quit();
    }

}
