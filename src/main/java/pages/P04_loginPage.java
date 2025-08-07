package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P04_loginPage {

    //Constructor
    public P04_loginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    //locators

    @FindBy(xpath = "(//div/div/form/div/input)[1]")
    WebElement username;

    @FindBy(xpath = "(//div/div/form/div/input)[2]")
    WebElement password;

    @FindBy(xpath = "(//div/div/form/input)[3]")
    WebElement loginButton;

   @FindBy(xpath = "(//a[text()='Forgotten Password'])[1]")
   //@FindBy(linkText = "Forgotten Password")
    WebElement forgottenPassword;

    //action methods
    public void login(String username, String password) throws InterruptedException {

        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.loginButton.click();
        Thread.sleep(5000);
    }

    public void clickForgottenPassword(){
        this.forgottenPassword.click();
    }

    //assertion method


}
