package ABCLtd;
import com.google.common.annotations.VisibleForTesting;
import org.junit.After;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AutoRegistrationFormFill {

    @After
        public void closeBrowser()    {
        //driver.quit();
    }
    @Before
        public void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "src\\test\\java\\BrowserDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    //creating a method to reuse simple time format anywhere in the project
        public String timeStamp(){
        DateFormat dateFormat = new SimpleDateFormat("DDmmYYHHmmSS");
        Date date=new Date();
        return dateFormat.format(date);
    }
    //creating reusable onClick method
    public void clickOnElement(By by){
        driver.findElement(by).click();
    }
    //a reusable getText method to use across the project
    public String getTextElement(By by){
        return driver.findElement(by).getText();
    }

    //creating a select by value method
    public void selectByValue(By by, String value){
        Select dropdown3 = new Select(driver.findElement(by));
        dropdown3.selectByValue(value);
    }
    //reusable write text method
    public void writeText(By by, String strValue){
        driver.findElement(by).sendKeys(strValue);
    }

    static protected WebDriver driver;
    @Test
    public void userAutoRegistrationTest(){

        driver.get("https://www.next.co.uk/");
        //locator using relative xpath
        clickOnElement(By.xpath("//ul/li [@data-section=\"myAccount\"]"));
        //locator using attributes of link tag
        clickOnElement(By.xpath("//a [@href='https://www.next.co.uk/secure/account/Register']"));
        //locator by id
        driver.findElement(By.id("Title"));
        //selecting dropdown element through locator id
        Select dropdown = new Select(driver.findElement(By.id("Title")));
        dropdown.selectByValue("Mrs");  //selecting one of the value from dropdown list
        writeText(By.id("FirstName"),"Temp");
        writeText(By.id("LastName"),"Tial");
        writeText(By.id("Email"),"temp.tril+" + timeStamp() + "@yahoo.com");
        writeText(By.id("Password"),"Temp123");
        writeText(By.id("DobDate"),"240384");
        writeText(By.id("PhoneNumber"),"01234567890");
        writeText(By.id("HouseNumberOrName"),"13");
        writeText(By.id("Postcode"),"HA2 0RS");
        clickOnElement(By.id("SearchPostcode"));
        clickOnElement(By.xpath("//label [@for='RequestDirNo']"));
        clickOnElement(By.id("SignupButton"));
        //An assert statement that gives out error message when expected header does not match actual header.
        Assert.assertEquals("Text message mismatch","Welcome to Next", driver.findElement(By.className("thank-register")).getText());
    }
    @Test

    public void GroceryAutoRegistrationTest() {
        driver.get("https://www.tesco.com/");
        clickOnElement(By.linkText("Register"));
        writeText(By.id("username"),"temp.tral+" + timeStamp() +"@yahoo.com");
        writeText(By.id("password"),"Abc!2345");
        clickOnElement(By.xpath("//label [@for='registration.index.form.fields.clubcard-radio-buttons.dont-have-clubcard']"));
        Select dropdown = new Select(driver.findElement(By.id("title")));
        dropdown.selectByValue("Mrs");
        writeText(By.id("first-name"),"Temp");
        writeText(By.id("last-name"),"Trial");
        writeText(By.id("phone-number"),"01234567890");
        writeText(By.id("postcode"),"HA2 0RS");
        clickOnElement(By.linkText("Enter address manually"));
        WebDriverWait wait = new WebDriverWait(driver, 30);
        //the address-line1 field is hidden on the form so wait until link is clicked and field made visible to perform action.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("address-line1")));
        writeText(By.id("address-line1"),"103 York Road");
        //to make the locator unique, used and attribute
        clickOnElement(By.xpath("//button [@class='ui-component__button' and @type='submit']"));
        String result = getTextElement(By.xpath("//h1[@class='ui-component__notice__heading']"));
        Assert.assertEquals("Different Welcome message", "Welcome to Asda", result);
    }
    @Test
        public void ShoppingAutoRegistrationTest() {

            driver.get("https://completelyretail.co.uk/scheme/Waterfields-Retail-Park-Watford");
            clickOnElement(By.xpath("//button [contains (@class, 'Buttons___Button-sc-10zybcx-0 Buttons__TextButton-sc-10zybcx-1 Buttons__Pr')]"));
            clickOnElement(By.linkText("Create an account"));
            writeText(By.id("name"),"temp");
            writeText(By.id("email"),"temp.test@yahoo.com");
            //inserting text into the textbox through automation
            writeText(By.id("confirmEmail"),"temp.test+" + timeStamp() + "@yahoo.com");
            Assert.assertNotEquals("Email don't match", driver.findElement(By.id("email")).getAttribute("value"),driver.findElement(By.id("confirmEmail")).getAttribute("value"));
            Assert.assertTrue("form can be submitted",driver.findElement(By.xpath("//button [@type='submit']")).isEnabled());
    }

    @Test
        public void ShoppingMallAutoRegistrationTest() {

        driver.get("https://intu.co.uk/watford");
        //driver.findElement(By.xpath("//a [@href= '/watford/sign-up']")).click();
        clickOnElement(By.xpath("//a [@href= '/watford/sign-up']"));
        writeText(By.id("first_name"),"Maya");
        writeText(By.id("last_name"),"Jaal");
        writeText(By.id("email"),"temp.test+"+ timeStamp() +"@yahoo.com");
        writeText(By.id("date_of_birth"),"4 March 1980");
        //selecting a dropdown field and choosing value from list
        selectByValue(By.id("gender"),"female");
        writeText(By.id("postcode"),"HA2 0RS");
        String actual1 = driver.getTitle();
        String expected1 = "Sign-up for Newsletter";
        Assert.assertEquals("Title mismatch", expected1,actual1);
        clickOnElement(By.xpath("//button [@class='g-recaptcha | form__btn']"));

    }

    @Test
        public void HomeStoreAutoRegistrationTest() {

            driver.get("https://www.matalan.co.uk/");
            //wait until visibility of Element located
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("My Account")));
            clickOnElement(By.linkText("My Account"));
            writeText(By.id("account_form_email"),"temp.trial@yahoo.com");
            clickOnElement(By.xpath("//button [@type='submit' and @data-behavior='save_button']"));
            writeText(By.id("account_form_meta_attributes[first_name][value]"),"Temp");
            writeText(By.id("account_form_meta_attributes[last_name][value]"),"Trial");
            writeText(By.id("account_form_email_confirmation"),"temp.trial+"+ timeStamp() + "@yahoo.com");
            writeText(By.id("account_form_password"),"Abcd!2345");
            writeText(By.id("account_form_password_confirmation"),"Abcd!2345");
            String expected = "http://www.matalan.co.uk";
            String actual1 = driver.getCurrentUrl();
            Assert.assertEquals("URL mismatch", expected,actual1);
    }
    @Test
        public void NopComRegistration() {
        driver.get("https://demo.nopcommerce.com/");

        clickOnElement(By.linkText("Register"));
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("register-button")));
        clickOnElement(By.id("gender-female"));
        writeText(By.id("FirstName"),"Hiral");
        writeText(By.id("LastName"),"Shah");
        writeText(By.id("Email"),"abd+" + timeStamp() +"@yahoo.com");
        Select dropdown4 = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
        dropdown4.selectByVisibleText("24");
        Select dropdown5 = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
        dropdown5.selectByVisibleText("May");
        Select dropdown6 = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
        dropdown6.selectByIndex(5);
        writeText(By.id("Company"),"Whatever");
        writeText(By.id("Password"),"Gayatri!23");
        writeText(By.id("ConfirmPassword"),"Gayatri!23");
        clickOnElement(By.id("register-button"));
        String actual = getTextElement(By.className("result"));
        Assert.assertEquals("registration failed","My registration successfully", getTextElement(By.className("result")));
    }
}
