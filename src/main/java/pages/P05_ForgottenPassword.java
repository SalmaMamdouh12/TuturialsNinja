package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P05_ForgottenPassword {

    //constructor
    public P05_ForgottenPassword(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    //Locators
    @FindBy(xpath = "(//input)[4]")
    WebElement emailAddress;

    @FindBy(xpath = "(//input)[5]")
    WebElement continueButton;

    @FindBy(xpath = "(//div/div)[14]")
    WebElement emailSentConirmationMsg;

    //Action method
    public void fillEmailAddress (String emailaddress){
        this.emailAddress.sendKeys(emailaddress);
    }

    public void clickContinueButton(){
        this.continueButton.click();
    }
    public Boolean isemailsentsuccessfullyMsg(String actualMsg){
     //   System.out.println(this.emailSentConirmationMsg.getText());

        return this.emailSentConirmationMsg.getText().equals(actualMsg);
    }
}
