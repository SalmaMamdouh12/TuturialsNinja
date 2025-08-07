package testcases;

import org.testng.annotations.Test;
import pages.P01_HomePage;

import static drivers.DriverHolder.getDriver;

public class TB01_Home extends TestBase {

    P01_HomePage homePage;

    @Test
    public void CheckMyAccountworkingandopenregisterbutton_P(){

        homePage = new P01_HomePage(getDriver());
        homePage.clickmyaccount();
        System.out.println(homePage.isRegisterVisible());
    }

}
