package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;

import java.util.Random;

import static drivers.DriverHolder.getDriver;
import static testcases.TC02_Register.registeredEmail;
import static testcases.TC02_Register.registeredPassword;

public class TC06_EndToEndScenarios extends TestBase{
    //declare object from page
    P01_HomePage homePage;
    P04_loginPage loginPage;
    P06_AccountPage accountPage;
    P07_ProductPage productPage;
    P08_CheckOutPage checkoutPage;

    String email= "user12.13@gmail.com";
    String password="Test@123.M$";

    String SearchResult="iPhone";
    String[] currencies = {"euro", "pound sterling", "us dollar"};
    Random random; //object from Random class for currency method
    int randomIndex;
    String[] keywords = {"macbook", "iphone", "camera"};
    int randomSearchIndex;
    String randomSearchKeyword;
    String InStockProduct = "HP LP3065";

   String firstname = "user12";
   String lastname = "13";
   String company = "test company";
   String address1 = "test address";
   String city = "test city";
   String postCode = "test Code";
   String selectedCountry = "Egypt";
   String selectedRegion = "Al Gharbiyah";


    //                           =============   SEARCH TEST CASE  =============
    @Test(priority = 1,description = "Logged User could search for any product")
    public void searchForSpecificProduct_P() throws InterruptedException {

        homePage=new P01_HomePage(getDriver());
        loginPage=new P04_loginPage(getDriver());
        accountPage=new P06_AccountPage(getDriver());

        //to handle random search
        random = new Random();
        randomSearchIndex = random.nextInt(keywords.length);
        String randomSearchKeyword = keywords[randomSearchIndex];

        homePage.clickmyaccount();
        homePage.selectLogin();
        loginPage.login(email,password);
        accountPage.searchForAProduct(randomSearchKeyword);
        Thread.sleep(5000);

        //Assertion
        softAssert=new SoftAssert();
        softAssert.assertTrue(accountPage.IsSearchResultMatchWithSearchInput(randomSearchKeyword),"Assertion Error: Search isn't working");
        softAssert.assertAll();

    }

    //                  ================== CURRENCY TEST CASE ============
    @Test(priority = 2, description = "Logged User could switch between currencies")
    public void selectRandomCurrency_P() throws InterruptedException {

        homePage=new P01_HomePage(getDriver());
        loginPage=new P04_loginPage(getDriver());
        accountPage=new P06_AccountPage(getDriver());

        random = new Random();

        homePage.clickmyaccount();
        homePage.selectLogin();
        loginPage.login(email,password);

        accountPage.captureOldPrice();

        //generate random index from our array length 0,1,2 through this method "nextInt" and save in into variable
        randomIndex = random.nextInt(currencies.length);
        //save the random index into the array and save its value in string = specific currency
        String randomCurrency = currencies[randomIndex];

        //call the method with this specific currency to go through it and click it
        accountPage.switchCurrency(randomCurrency);
        Thread.sleep(3000); // to see the chosen currency

        //assertion
        softAssert=new SoftAssert();
        softAssert.assertTrue(accountPage.isPriceDifferent(),"Assertion Msg: Prices are still same");
        softAssert.assertAll();
    }

    //                                ================ CATEGORY TEST CASE ================
    @Test(priority = 3,description = "Logged user could select different Categories")
    public void selectRandomCategory_P() throws InterruptedException {

        homePage=new P01_HomePage(getDriver());
        loginPage=new P04_loginPage(getDriver());
        accountPage= new P06_AccountPage(getDriver());

        homePage.clickmyaccount();
        homePage.selectLogin();
        loginPage.login(email,password);
        accountPage.selectRandomCategory();

        //assertion
        softAssert=new SoftAssert();
        softAssert.assertEquals(accountPage.getActualRandomSelectedCategory(), accountPage.getExpectedCategoryORSubCategoryName(),"Assertion msg: Category isn't selected correctly");
        softAssert.assertAll();

    }

    //                                ================ SUB CATEGORY TEST CASE ================
    @Test(priority = 4,description = "Logged user could select different Sub Categories")
    public void selectRandomSubCategory_P() throws InterruptedException {

        homePage=new P01_HomePage(getDriver());
        loginPage=new P04_loginPage(getDriver());
        accountPage= new P06_AccountPage(getDriver());

        homePage.clickmyaccount();
        homePage.selectLogin();
        loginPage.login(email,password);
        accountPage.selectRandomSubCategory();

        //assertion, using contains here as name of selected Sub include extra numbers
        softAssert=new SoftAssert();
        softAssert.assertTrue(
                accountPage.getActualRandomSelectedSubCategory().contains(accountPage.getExpectedCategoryORSubCategoryName()),
                "Assertion msg: Category isn't selected correctly");
        softAssert.assertAll();
   }

    //                             ================ ADD TO CART TEST CASE ================
    @Test(priority = 5,description = "Logged user could add different products to Shopping cart")
    public void addRandomProductToCart_P() throws InterruptedException {

        homePage=new P01_HomePage(getDriver());
        loginPage=new P04_loginPage(getDriver());
        accountPage= new P06_AccountPage(getDriver());
        productPage= new P07_ProductPage(getDriver());

        homePage.clickmyaccount();
        homePage.selectLogin();
        loginPage.login(email,password);

        accountPage.selectRandomCategory();
        productPage.clickFirstAddToCartIfExists();

        //assertion - shall it be hardassert ?
        softAssert=new SoftAssert();
        softAssert.assertTrue(productPage.getActualMessage().contains("Success: You have added"),"Assertion Msg: Expected Msg isn't shown");
        softAssert.assertAll();
    }

    //                             ================ ADD TO WISHLIST TEST CASE ================

    @Test(priority = 6,description = "Logged user could add different products to Wishlist")
    public void addRandomProductToWishlist_P() throws InterruptedException {

        homePage=new P01_HomePage(getDriver());
        loginPage=new P04_loginPage(getDriver());
        accountPage= new P06_AccountPage(getDriver());
        productPage= new P07_ProductPage(getDriver());

        homePage.clickmyaccount();
        homePage.selectLogin();
        loginPage.login(email,password);

        accountPage.selectRandomCategory();
        productPage.addToWishListButtonclick();

        //assertion
        softAssert=new SoftAssert();
        softAssert.assertTrue(productPage.getActualMessage().contains("Success: You have added"),"Assertion Msg: Expected Msg isn't shown");
        softAssert.assertAll();
    }

    //                          ================ ADD TO COMPARE LIST TEST CASE ================

    @Test(priority = 7,description = "Logged user could add different products to compare list")
    public void addRandomProductToCompare_P() throws InterruptedException {

        homePage=new P01_HomePage(getDriver());
        loginPage=new P04_loginPage(getDriver());
        accountPage= new P06_AccountPage(getDriver());
        productPage= new P07_ProductPage(getDriver());

        homePage.clickmyaccount();
        homePage.selectLogin();
        loginPage.login(email,password);

        accountPage.selectRandomCategory();
        productPage.addToCompareButtonclick();

        //assertion
        softAssert=new SoftAssert();
        softAssert.assertTrue(productPage.getActualMessage().contains("Success: You have added"),"Assertion Msg: Expected Msg isn't shown");
        softAssert.assertAll();
    }

    @Test(priority = 8 ,description = "Create successful Order")
    public void CreateSuccessfulOrder_P () throws InterruptedException {

        homePage=new P01_HomePage(getDriver());
        loginPage=new P04_loginPage(getDriver());
        accountPage= new P06_AccountPage(getDriver());
        productPage= new P07_ProductPage(getDriver());
        checkoutPage= new P08_CheckOutPage(getDriver());

        homePage.clickmyaccount();
        homePage.selectLogin();
        loginPage.login(registeredEmail,registeredPassword);

        accountPage.searchForAProduct(InStockProduct);
        Thread.sleep(3000);
      //  checkoutPage.clearCartButton();
        Thread.sleep(3000);
        checkoutPage.clickProductAddToCart();
        checkoutPage.clickAddToCartButton();
        Thread.sleep(2000);

        checkoutPage.clickCartButton();
        Thread.sleep(2000);

        checkoutPage.clickCheckOutButton();
        Thread.sleep(2000);

        checkoutPage.fillCheckOutFields(firstname,lastname,company,address1,city,postCode);
        Thread.sleep(2000);
        checkoutPage.selectCountry(selectedCountry);
        Thread.sleep(3000);
        checkoutPage.selectRegion(selectedRegion);
        Thread.sleep(2000);
        checkoutPage.confirmOrder();


        //assertion
        Assert.assertTrue(checkoutPage.isOrderConfirmed("Your order has been placed!"),"Assertion Msg: Order Not Confirmed!!");

    }

}
