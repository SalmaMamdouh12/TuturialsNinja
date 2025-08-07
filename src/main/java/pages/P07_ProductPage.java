package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class P07_ProductPage {

    //constructor
    public P07_ProductPage(WebDriver driver){
        PageFactory.initElements(driver, this);

    }

    //locators
    @FindBy(xpath = "//button[contains(@onclick, 'cart.add')]")
    List<WebElement> addToCartButton;//define it as list to handle if multiple add to cart button for different products existing in one page

    @FindBy(xpath = "//div[contains(@class, 'alert-success')]")
    WebElement SuccessfulMessage;

    @FindBy(xpath = "//button[@data-original-title='Add to Wish List']")
    List<WebElement> wishListButton;

    @FindBy(xpath = "//button[@data-original-title='Compare this Product']")
    List<WebElement> comparisonButton;

    //action methods

    //methods to handle categories haven't any products
    public Boolean isProductAvailable(){
        return addToCartButton.size() > 0;
    }

    public void clickFirstAddToCartIfExists() throws InterruptedException {
        if(isProductAvailable()){
            addToCartButton.get(0).click();
            Thread.sleep(5000);
            System.out.println(this.SuccessfulMessage.getText());
        }
        else{
            System.out.println("This Random Category has no products");
        }
    }
    public void addToWishListButtonclick() throws InterruptedException {
       if(isProductAvailable()) {
           wishListButton.get(0).click();
           Thread.sleep(3000);
           System.out.println(this.SuccessfulMessage.getText());
       }
       else{
           System.out.println("This Random Category has no products");
       }
    }
    public void addToCompareButtonclick() throws InterruptedException {
        if(isProductAvailable())
        {
            comparisonButton.get(0).click();
            Thread.sleep(3000);
            System.out.println(this.SuccessfulMessage.getText());
        }

        else{
            System.out.println("This Random Category has no products");

        }
    }

    //assertion for add to cart
    public String getActualMessage(){
        return SuccessfulMessage.getText();
    }


}
