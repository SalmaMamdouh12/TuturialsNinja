package testcases;

import org.testng.annotations.Test;
import pages.P01_HomePage;

import static drivers.DriverHolder.getDriver;

public class TC01_Home extends TestBase {

    //object from the page, just type
    P01_HomePage homePage;

    @Test(priority = 1 , description = "Check My Account working and open register button" )
    public void CheckMyAccountworkingandopenregisterbutton_P(){

        //set value inside this object
        homePage = new P01_HomePage(getDriver());

        homePage.clickmyaccount();
        System.out.println(homePage.isRegisterVisible());
    }

}
