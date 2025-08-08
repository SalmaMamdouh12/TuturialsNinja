package testcases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P02_registerPage;
import pages.P06_AccountPage;
import util.Utility;
import static drivers.DriverHolder.getDriver;
import static util.Utility.*;

public class TC02_Register extends TestBase{

    //object from the page, just type
    P01_HomePage homePage;
    P02_registerPage registerPage;
    P06_AccountPage logoutPage;
    String firstName = generateRandomName();
    String lastName = generateRandomName();
    String registeredPhone="012" + generaterandomDigits(8);;
    String registrationSuccessfulMsg = "Your Account Has Been Created!";
    static String registeredEmail=generateRandomGmail();
    static String registeredPassword = generatecomplexPassword(15);

    //define methods
    @Test(priority = 1 , description =  "Check Registration With Valid Data")
    public void checkRegistrationWithValidData_P() throws InterruptedException {

        //set value to the objects based on Testbase driver
        homePage = new P01_HomePage(getDriver());
        registerPage = new P02_registerPage(getDriver());
        logoutPage = new P06_AccountPage(getDriver());
        //set Test Steps
        homePage.clickmyaccount();
        homePage.clickregisterbutton();
        // generate credentials before using them!
        Utility.generateRandomName();

        registerPage.register( firstName, lastName, registeredEmail,registeredPhone,registeredPassword);
        Thread.sleep(5000);

        //Hard Assertion
        Assert.assertTrue(registerPage.isRegisteredSuccessfully(registrationSuccessfulMsg), "Assertion Msg: Registration Failed");
    }












/*
    @Test(priority = 2 , description =  "Check Registration With Invalid Data")
    public void checkRegistrationWithInvalidData_N() throws InterruptedException {

        //set value to the objects based on Testbase driver
        homePage=new P01_HomePage(driver);
        registerPage=new P02_registerPage(driver);

        //set Test Steps
        homePage.clickmyaccount();
        homePage.clickregisterbutton();

        //define variables will be used in below methods
        String firstname = "%^$^";
        String lastname = "*&*%$";
        String email = "s.m.com";
        String phone = "iagks";
        String password = "oiuqo";


        registerPage.register(firstname,lastname,email,phone,password);
        Thread.sleep(5000);
    }

    @Test(priority = 1 , description =  "Check Registration With Duplicate Email")
    public void checkRegistrationWithDuplicateEmail_N() throws InterruptedException {

        //set value to the objects based on Testbase driver
        homePage=new P01_HomePage(driver);
        registerPage=new P02_registerPage(driver);

        //set Test Steps
        homePage.clickmyaccount();
        homePage.clickregisterbutton();

        //define variables will be used in below methods
        String firstname = "Salma";
        String lastname = "Mamdouh";
        String email = "s.m@gmail.com";
        String phone = "1212721";
        String password = "test@123";

        registerPage.register(firstname,lastname,email,phone,password);
        Thread.sleep(5000);
    }

 */
}
