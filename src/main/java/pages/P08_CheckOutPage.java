package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class P08_CheckOutPage {

    //constructor
    public P08_CheckOutPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    Select select;

    //locators
    @FindBy(xpath = "(//div/div/button)[5]")
    WebElement addToCartButton;

    @FindBy(xpath = "//button[contains(@onclick, 'cart.add')]")
    List<WebElement> productAddToCartButton;

    @FindBy (xpath = "(//div/div/button/span)[1]")
    WebElement cartButton;

    @FindBy(xpath = "//p[@class='text-center']")
    WebElement cartIsEmptyContext;

    @FindBy(xpath = "//button[@title='Remove']")
    WebElement clearCart;

    @FindBy(xpath = "(//ul/li/div/p/a)[2]")
    WebElement checkOutButton;

    @FindBy(xpath = "(//input)[@type='button']")
    WebElement continueButton;

    @FindBy(xpath = "((//input)[@type='button'])[2]")
    WebElement continue2;

    @FindBy(xpath = "((//input)[@type='button'])[3]")
    WebElement continue3;

    @FindBy(xpath = "((//input)[@type='button'])[4]")
    WebElement continue4;

    @FindBy(xpath = "(//form/div/label/input)[2]")
    WebElement newDataRadioButton;

    @FindBy(xpath = "(//form/div/div/div/input)[1]")
    WebElement firstName;

    @FindBy(xpath = "(//form/div/div/div/input)[2]")
    WebElement lastName;

    @FindBy(xpath = "(//form/div/div/div/input)[3]")
    WebElement company;

    @FindBy(xpath = "(//form/div/div/div/input)[4]")
    WebElement address1;

    @FindBy(xpath = "(//form/div/div/div/input)[6]")
    WebElement city;

    @FindBy(xpath = "(//form/div/div/div/input)[7]")
    WebElement postCode;

    @FindBy(xpath = "(//form/div/div/div/select)[1]")
    WebElement countryDropList;

    @FindBy(xpath = "(//form/div/div/div/select)[2]")
    WebElement regionDropList;

    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement conditionsCheckbox;

    @FindBy(xpath = "(//input[@type='button'])[5]")
    WebElement confirmOrderButton;

    @FindBy(xpath = "//body/div/div/div/h1")
    WebElement orderConfirmationMsg;

    //public methods
    public void clickProductAddToCart() throws InterruptedException {
        productAddToCartButton.get(0).click();
        Thread.sleep(5000);
    }
    //internal button
    public void clickAddToCartButton(){
        this.addToCartButton.click();
    }

    public void clickCheckOutButton(){
        this.checkOutButton.click();
        System.out.println("CHECKOUT");

    }

    public void fillCheckOutFields( String firstname,String lastname, String company, String address1, String city, String postcode) throws InterruptedException {
        this.firstName.sendKeys(firstname);
        this.lastName.sendKeys(lastname);
        this.company.sendKeys(company);
        this.address1.sendKeys(address1);
        this.city.sendKeys(city);
        this.postCode.sendKeys(postcode);
    }

    public void clickCartButton(){
        this.cartButton.click();
        System.out.println("Cart button CLiicked again");
    }
    public void clearCartButton() throws InterruptedException {
       do {
            cartButton.click();
            clearCart.click();
            Thread.sleep(5000);
        } while(!cartIsEmptyContext.getText().contains("Your shopping cart is empty!"));

        System.out.println("Cart Cleared");

    }
    public void confirmOrder() throws InterruptedException {
        this.continueButton.click();
        Thread.sleep(5000);
        this.continue2.click();
        Thread.sleep(5000);
        this.continue3.click();
        Thread.sleep(5000);
        this.conditionsCheckbox.click();
        Thread.sleep(3000);
        this.continue4.click();
        Thread.sleep(5000);
        this.confirmOrderButton.click();
        Thread.sleep(3000);

    }

    public void selectCountry(String countryName) {
        select = new Select(countryDropList);
        select.selectByVisibleText(countryName);
    }

    public void selectRegion(String regionName) {
        select = new Select(regionDropList);
        select.selectByVisibleText(regionName);
    }


    //Assert
    public Boolean isOrderConfirmed(String confirmationMsg){
        return orderConfirmationMsg.getText().equals(confirmationMsg);
    }


}
