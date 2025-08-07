package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P02_registerPage;
import pages.P04_loginPage;
import pages.P06_AccountPage;

import static drivers.DriverHolder.getDriver;
import static testcases.TC02_Register.registeredEmail;
import static testcases.TC02_Register.registeredPassword;

public class TC04_Login extends TestBase{

    //define object
    P01_HomePage homePage;
    P02_registerPage registerPage;
    P04_loginPage loginPage;
    P06_AccountPage logoutPage;
    String email = "user12.13@gmail.com";
    String password = "Test@123.M$";

    @Test(priority = 1 , description = "User could log in with valid email and password")
    public void loginWithValidData_P() throws InterruptedException {

        //to set initial value of my objects with driver
        homePage = new P01_HomePage(getDriver());
        loginPage = new P04_loginPage(getDriver());
        logoutPage = new P06_AccountPage(getDriver());

        //test steps
        homePage.clickmyaccount();
        homePage.selectLogin();
        loginPage.login(registeredEmail,registeredPassword);
        homePage.clickmyaccount();

        //assertion
        Assert.assertTrue(logoutPage.isLogoutButtonVisible(),"Assertion Msg: Login failed");

    }

}
