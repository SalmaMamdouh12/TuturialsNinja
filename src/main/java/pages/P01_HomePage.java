package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P01_HomePage {

    //Constructor
    public P01_HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    //Locators
    @FindBy(xpath = "//li/a[@title='My Account']")
    WebElement myAccount;

    @FindBy(xpath = "//ul/li/a[text()='Register']")
    WebElement registerButton;

    @FindBy(xpath = "//ul/li/a[text()='Login']")
    WebElement loginButton;

    //action methods
    public void clickmyaccount(){
        myAccount.click();
    }

    public void clickregisterbutton(){
        registerButton.click();
    }

    public boolean isRegisterVisible(){
        return registerButton.isDisplayed();
    }

    public void selectLogin(){
        loginButton.click();
    }
}
