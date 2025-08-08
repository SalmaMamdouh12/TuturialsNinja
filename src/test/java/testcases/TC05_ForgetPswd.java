package testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.P01_HomePage;
import pages.P04_loginPage;
import pages.P05_ForgetPswdPage;
import static drivers.DriverHolder.getDriver;

public class TC05_ForgetPswd extends TestBase{

    P05_ForgetPswdPage forgottenPasswordpage;
    P04_loginPage loginPage;
    P01_HomePage homePage;
    String emailAddress = "s.m@gmail.com"; //Email_for_forgottenpassword
    String actualMsg_ForgotPswdAssertion = "An email with a confirmation link has been sent your email address.";


    @Test(priority = 1, description = "User could reset his/her password successfully")
    public void EmailSentWhenPasswordForgotten_P() throws InterruptedException {
        forgottenPasswordpage=new P05_ForgetPswdPage(getDriver());
        loginPage=new P04_loginPage(getDriver());
        homePage=new P01_HomePage(getDriver());

        //steps
        homePage.clickmyaccount();
        homePage.selectLogin();
        Thread.sleep(3000);
        loginPage.clickForgottenPassword();
        forgottenPasswordpage.fillEmailAddress(emailAddress);
        forgottenPasswordpage.clickContinueButton();
        Thread.sleep(7000);


        //Assertion
        softAssert=new SoftAssert();
        softAssert.assertTrue(forgottenPasswordpage.isemailsentsuccessfullyMsg(actualMsg_ForgotPswdAssertion),"Soft Assertion Error: Email Sent Msg Not Shown");
        softAssert.assertAll();
    }

}
