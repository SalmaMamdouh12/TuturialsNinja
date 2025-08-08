package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class P06_AccountPage {

    Actions actions;
    Random random = new Random();

    String oldCurrency; //for currency assertion
    String newCurrency;

    int indexForCategory;
    int indexForSubCategory;
    //for assertion
    String subCategoryToBeChosen;
    // Arrays for dynamic use
    WebElement[] topCategories;
    WebElement[] subCategories;
    WebElement[] desktopsSubCategories;
    WebElement[] laptopsSubCategories;
    WebElement[] componentsSubCategories;
    WebElement[] mp3SubCategories;
    WebElement selectedCategory;
    WebElement selectedSubCategory;
    WebElement selectedSub;


    //constructor
    public P06_AccountPage(WebDriver driver) {
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    //         ================================= WEB ELEMENTS FOR ACCOUNT PAGE =======================================


    //                                      ========= LOGOUT LOCATORS ==========
    @FindBy(xpath = "(//div/ul/li/ul/li/a)[5]")
    WebElement logoutButton;

    //                                      ========= SEARCH LOCATORS ==========
    @FindBy(xpath = "//div/div/input")
    WebElement searchInput;

    @FindBy(xpath = "//div/div/span/button")
    WebElement searchButton;

    //elements for assertion related to search
    @FindBy(xpath = "//div/div/h4/a")
    WebElement searchResult;

    //                                      ========= CURRENCY LOCATORS ==========

    @FindBy(xpath = "//div/form/div/button")
    WebElement currencyButton;

    @FindBy(xpath = "(//ul/li/button)[1]")
    WebElement euroCurrency;

    @FindBy(xpath = "(//ul/li/button)[2]")
    WebElement poundSterlingCurrency;

    @FindBy(xpath = "(//ul/li/button)[3]")
    WebElement usDollarCurrency;

    //assertion
    @FindBy (xpath = "(//div/div/button/span)[1]")
    WebElement cartButton;

    //                                      ========= CATEGORY LOCATORS ==========
    @FindBy(xpath = "(//nav/div/ul/li/a)[1]")
    WebElement desktopsCategory;

    @FindBy(xpath = "(//nav/div/ul/li/a)[2]")
    WebElement laptopsAndNotebooksCategory;

    @FindBy(xpath = "(//nav/div/ul/li/a)[3]")
    WebElement componentsCategory;

    @FindBy(xpath = "(//nav/div/ul/li/a)[4]")
    WebElement tabletsCategory;

    @FindBy(xpath = "(//nav/div/ul/li/a)[5]")
    WebElement softwareCategory;

    @FindBy(xpath = "(//nav/div/ul/li/a)[6]")
    WebElement phoneAndPDAsCategory;

    @FindBy(xpath = "(//nav/div/ul/li/a)[7]")
    WebElement camerasCategory;

    @FindBy(xpath = "(//nav/div/ul/li/a)[8]")
    WebElement mp3PlayersCategory;

    @FindBy(xpath = "(//nav/div/ul/li//div/div/ul/li/a)[1]")
    WebElement pcDesktopSubCategory;

    @FindBy(xpath = "(//nav/div/ul/li//div/div/ul/li/a)[2]")
    WebElement macDesktopSubCategory;

    @FindBy(xpath = "(//nav/div/ul/li//div/div/ul/li/a)[3]")
    WebElement macsLaptopsSubCategory;

    @FindBy(xpath = "(//nav/div/ul/li//div/div/ul/li/a)[4]")
    WebElement windowsLaptopsSubCategory;

    @FindBy(xpath = "(//nav/div/ul/li//div/div/ul/li/a)[5]")
    WebElement miceComponentsSubCategory;

    @FindBy(xpath = "(//nav/div/ul/li//div/div/ul/li/a)[6]")
    WebElement monitorComponentsSubCategory;

    @FindBy(xpath = "(//nav/div/ul/li//div/div/ul/li/a)[7]")
    WebElement printerComponentsSubCategory;

    @FindBy(xpath = "(//nav/div/ul/li//div/div/ul/li/a)[8]")
    WebElement scannerComponentsSubCategory;

    @FindBy(xpath = "(//nav/div/ul/li//div/div/ul/li/a)[9]")
    WebElement webCameraComponentsSubCategory;

    @FindBy(xpath = "(//nav/div/ul/li//div/div/ul/li/a)[10]")
    WebElement test11MP3SubCategory;

    @FindBy(xpath = "(//nav/div/ul/li//div/div/ul/li/a)[11]")
    WebElement test12MP3SubCategory;

    @FindBy(xpath = "(//nav/div/ul/li//div/div/ul/li/a)[12]")
    WebElement test15MP3SubCategory;

    @FindBy(xpath = "(//nav/div/ul/li//div/div/ul/li/a)[13]")
    WebElement test16MP3SubCategory;

    @FindBy(xpath = "(//nav/div/ul/li//div/div/ul/li/a)[14]")
    WebElement test17MP3SubCategory;

    @FindBy(xpath = "(//nav/div/ul/li//div/div/ul/li/a)[15]")
    WebElement test18MP3SubCategory;

    @FindBy(xpath = "(//nav/div/ul/li//div/div/ul/li/a)[16]")
    WebElement test19MP3SubCategory;

    @FindBy(xpath = "(//nav/div/ul/li//div/div/ul/li/a)[17]")
    WebElement test20MP3SubCategory;

    @FindBy(xpath = "(//nav/div/ul/li//div/div/ul/li/a)[18]")
    WebElement test21MP3SubCategory;

    @FindBy(xpath = "(//nav/div/ul/li//div/div/ul/li/a)[19]")
    WebElement test22MP3SubCategory;

    @FindBy(xpath = "(//nav/div/ul/li//div/div/ul/li/a)[20]")
    WebElement test23MP3SubCategory;

    @FindBy(xpath = "(//nav/div/ul/li//div/div/ul/li/a)[21]")
    WebElement test24MP3SubCategory;

    @FindBy(xpath = "(//nav/div/ul/li//div/div/ul/li/a)[22]")
    WebElement test4MP3SubCategory;

    @FindBy(xpath = "(//nav/div/ul/li//div/div/ul/li/a)[23]")
    WebElement test5MP3SubCategory;

    @FindBy(xpath = "(//nav/div/ul/li//div/div/ul/li/a)[24]")
    WebElement test6MP3SubCategory;

    @FindBy(xpath = "(//nav/div/ul/li//div/div/ul/li/a)[25]")
    WebElement test7MP3SubCategory;

    @FindBy(xpath = "(//nav/div/ul/li//div/div/ul/li/a)[26]")
    WebElement test8MP3SubCategory;

    @FindBy(xpath = "(//nav/div/ul/li//div/div/ul/li/a)[27]")
    WebElement test9MP3SubCategory;

    @FindBy(xpath = "//div/div/h2")
    WebElement categoryStatement;

    //            ================================= PUBLIC ACTION METHODS =======================================


    //                                    ======= LOGOUT ACTION METHODS ========

    public void clickLogoutButton(){
        this.logoutButton.click();
    }

    public boolean isLogoutButtonVisible(){
        return logoutButton.isDisplayed();
    }

    //                                    ======= SEARCH ACTION METHODS ========
    public void searchForAProduct(String value) {

        this.searchInput.click();
        this.searchInput.clear();
        this.searchInput.sendKeys(value);
        this.searchButton.click();

    }

    //for assertion
    public Boolean IsSearchResultMatchWithSearchInput(String searchActualWord) {

        return this.searchResult.getText().toLowerCase().equals(searchActualWord);

    }

    //                            ======== SWITCHING BETWEEN CURRENCY ACTION METHOD ==========
    public void switchCurrency(String currencyName) {
        currencyButton.click(); // open dropdown

        switch (currencyName.toLowerCase()) {
            case "euro":
                euroCurrency.click();
                break;

            case "pound sterling":
                poundSterlingCurrency.click();
                break;

            case "us dollar":
                usDollarCurrency.click();
                break;

            default:
                System.out.println("Invalid currency name: " + currencyName);
        }
        captureNewPrice();
    }

    //for assertion
    public void captureOldPrice() {
        oldCurrency = cartButton.getText();
        System.out.println("Old Currency: " + oldCurrency);
    }

    public void captureNewPrice() {
        newCurrency = cartButton.getText();
        System.out.println("New Currency: " + newCurrency);
    }

    public Boolean isPriceDifferent (){
        return !oldCurrency.equals(newCurrency);
    }

    //                           ============ CATEGORY ACTION METHODS ==========
    public void initCategoryArrays() {
        topCategories = new WebElement[]{
                tabletsCategory, softwareCategory, phoneAndPDAsCategory, camerasCategory};

        subCategories = new WebElement[]{
                desktopsCategory, laptopsAndNotebooksCategory, componentsCategory, mp3PlayersCategory};

        desktopsSubCategories = new WebElement[]{pcDesktopSubCategory, macDesktopSubCategory};

        laptopsSubCategories = new WebElement[]{macsLaptopsSubCategory, windowsLaptopsSubCategory};

        componentsSubCategories = new WebElement[]{
                miceComponentsSubCategory, monitorComponentsSubCategory,
                printerComponentsSubCategory, scannerComponentsSubCategory,
                webCameraComponentsSubCategory};

        mp3SubCategories = new WebElement[]{test11MP3SubCategory, test12MP3SubCategory, test15MP3SubCategory};
    }

    public void selectRandomCategory() {
        initCategoryArrays();
        indexForCategory = random.nextInt(topCategories.length);
        selectedCategory = topCategories[indexForCategory];

        //to hover on the selected category
        System.out.println("Selected Category is: " + selectedCategory.getText());
        selectedCategory.click();
        //add for assertion
    }

    public void selectRandomSubCategory() {

            initCategoryArrays(); // initialize all WebElement arrays

            indexForSubCategory = random.nextInt(subCategories.length);
            selectedSubCategory = subCategories[indexForSubCategory];

            // Hover on selected top-level category
            actions.moveToElement(selectedSubCategory).perform();
            System.out.println("Hovered on: " + selectedSubCategory.getText());

            selectedSub = null;

            switch (indexForSubCategory) {
                case 0: // Desktops
                    selectedSub = desktopsSubCategories[random.nextInt(desktopsSubCategories.length)];
                    break;
                case 1: // Laptops
                    selectedSub = laptopsSubCategories[random.nextInt(laptopsSubCategories.length)];
                    break;
                case 2: // Components
                    selectedSub = componentsSubCategories[random.nextInt(componentsSubCategories.length)];
                    break;
                case 7: // MP3 Players
                    selectedSub = mp3SubCategories[random.nextInt(mp3SubCategories.length)];
                    break;
                default:
                    System.out.println("No subcategory selection for this category.");
                    return;
            }

            if (selectedSub != null) {
                subCategoryToBeChosen = selectedSub.getText(); // Save subcategory name
                selectedSub.click(); // Click it
                System.out.println("Clicked subcategory: " + subCategoryToBeChosen);
            }

    }
    //for assertion
    public String getActualRandomSelectedCategory(){
        return selectedCategory.getText();
    }
    //in internal screen that expected to be shown after selection
    public String getExpectedCategoryORSubCategoryName(){
        return categoryStatement.getText();
    }

    public String getActualRandomSelectedSubCategory(){
        return subCategoryToBeChosen;
    }


}