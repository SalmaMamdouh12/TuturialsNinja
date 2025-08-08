package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P02_registerPage {

    //constructor
    public P02_registerPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    //locators
    @FindBy(xpath = "(//div/input)[2]")
    WebElement firstname;

    @FindBy(xpath = "(//div/input)[3]")
    WebElement lastname;

    @FindBy(xpath = "(//div/input)[4]")
    WebElement email;

    @FindBy(xpath = "(//div/input)[5]")
    WebElement phone;

    @FindBy(xpath = "(//div/input)[6]")
    WebElement password;

    @FindBy(xpath = "(//div/input)[7]")
    WebElement confirmpassword;

    @FindBy(xpath = "(//div/input)[8]")
    WebElement policy;

    @FindBy(xpath = "(//div/input)[9]")
    WebElement continueButton;

    //locator of msg that will use in assertion
    @FindBy(xpath = "(//h1)[2]")
    WebElement successfullyRegisteredMessage;

    //action methods
    //generic method to fill all fields at a time
    public void register(String firstname,String lastname, String email, String phone, String password ){
        this.firstname.sendKeys(firstname);
        this.lastname.sendKeys(lastname);
        this.email.sendKeys(email);
        this.phone.sendKeys(phone);
        this.password.sendKeys(password);
        this.confirmpassword.sendKeys(password);
        this.policy.click();
        this.continueButton.click();
    }

    //check if registered successfully
    public boolean isRegisteredSuccessfully(String successfulMessage){
        return this.successfullyRegisteredMessage.getText().equals(successfulMessage);

    }










//    public void fillFirstName(String firstname){
//        this.firstname.sendKeys(firstname);
//    }
//
//
//    public void fillLastName(String lastname){
//        this.lastname.sendKeys(lastname);
//    }
//
//    public void fillPhone(String phone){
//        this.phone.sendKeys(phone);
//    }
//
//    public void fillEmail(String email){
//        this.email.sendKeys(email);
//    }
//
//    public void fillPassword(String password){
//        this.password.sendKeys(password);
//    }
//
//    public void fillConfirmPassword(String confirmpassword){
//        this.confirmpassword.sendKeys(confirmpassword);
//    }
//
//    public void clickPolicyCheckbox(){
//        this.policy.click();
//    }
//
//    public void clickContinueButton(){
//        this.continueButton.click();
//    }

}
