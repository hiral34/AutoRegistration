package ABCLtd;
import com.google.common.annotations.VisibleForTesting;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AutoRegistrationFormFill {
    static protected WebDriver driver;
    @Test
    public void userAutoRegistrationTest(){
        System.setProperty("webdriver.chrome.driver","src\\test\\java\\BrowserDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//waiting time
        driver.get("https://www.next.co.uk/");
        driver.findElement(By.xpath("//ul/li [@data-section=\"myAccount\"]")).click();  //locator using relative xpath
        driver.findElement(By.xpath("//a [@href='https://www.next.co.uk/secure/account/Register']")).click();   //locator using attributes of link tag
        driver.findElement(By.id("Title")); //locator by id
        Select dropdown = new Select(driver.findElement(By.id("Title")));   //selecting dropdown element through locator id
        dropdown.selectByValue("Mrs");  //selecting one of the value from dropdown list
        driver.findElement(By.id("FirstName")).sendKeys("Temp");
        driver.findElement(By.id("LastName")).sendKeys("Trial");
        driver.findElement(By.id("Email")).sendKeys("temp.trial@yahoo.com");
        driver.findElement(By.id("Password")).sendKeys("Temp123");
        driver.findElement(By.id("DobDate")).sendKeys("240382");
        driver.findElement(By.id("PhoneNumber")).sendKeys("01234567890");
        driver.findElement(By.id("HouseNumberOrName")).sendKeys("13");
        driver.findElement(By.id("Postcode")).sendKeys("HA2 0RS");
        driver.findElement(By.id("SearchPostcode")).click();
        //WebElement radio1 =  driver.findElement(By.xpath("//input [@id='RequestDirNo']"));
        //radio1.click();
        driver.findElement(By.xpath("//label [@for='RequestDirNo']")).click();
        driver.findElement(By.id("SignupButton")).click();
    }
    @Test
    /*public void GroceryAutoRegistrationTest(){
        System.setProperty("webdriver.chrome.driver","src\\test\\java\\BrowserDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.get("https://www.marksandspencer.com/");
        //driver.findElement(By.xpath("//a/i [@class='navigation-primary__menu-icon navigation-icon--my-account']")).click();
        driver.findElement(By.xpath("//li/a [contains(@href,'/webapp/wcs/stores/servlet/MSResUserRegistration?catalogId=10051')]")).click();
        driver.findElement(By.id("registerEmail")).sendKeys("temp.trial@yahoo.com");
        driver.findElement(By.id("registerPassword")).sendKeys("Abc!2345");
        driver.findElement(By.xpath("//button [@class='ctnbtn--inactive']")).click();
    }*/
    public void GroceryAutoRegistrationTest() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\java\\BrowserDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.tesco.com/");
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("username")).sendKeys("temp.tiral@yahoo.com");
        driver.findElement(By.id("password")).sendKeys("Abc!2345");
        driver.findElement(By.xpath("//label [@for='registration.index.form.fields.clubcard-radio-buttons.dont-have-clubcard']")).click();
        Select dropdown = new Select(driver.findElement(By.id("title")));
        dropdown.selectByValue("Mrs");
        driver.findElement(By.id("first-name")).sendKeys("Temp");
        driver.findElement(By.id("last-name")).sendKeys("Trial");
        driver.findElement(By.id("phone-number")).sendKeys("01234567890");
        driver.findElement(By.id("postcode")).sendKeys("HA2 0RS");
        driver.findElement(By.xpath("//button [@class='ui-component__button' and @type='button']")).click();
        Select dropdown2 = new Select(driver.findElement(By.id("address-dropdown")));
        dropdown2.selectByValue("13 Chatsworth Gardens");
        driver.findElement(By.xpath("//button [@class='ui-component__button' and @type='submit']")).click(); //to make the locator unique, used and attribute
    }
    @Test
        public void ShoppingAutoRegistrationTest() {
            System.setProperty("webdriver.chrome.driver", "src\\test\\java\\BrowserDrivers\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.get("https://completelyretail.co.uk/scheme/Waterfields-Retail-Park-Watford");
            driver.findElement(By.xpath("//button [contains (@class, 'Buttons___Button-sc-10zybcx-0 Buttons__TextButton-sc-10zybcx-1 Buttons__Pr')]")).click();
            driver.findElement(By.linkText("Create an account")).click();
            driver.findElement(By.id("name")).sendKeys("temp");
            driver.findElement(By.id("email")).sendKeys("temp.test@yahoo.com");
            driver.findElement(By.id("confirmEmail")).sendKeys("temp.test@yahoo.com");     //inserting text into the textbox through automation
    }
    @Test
        public void ShoppingMallAutoRegistrationTest() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\java\\BrowserDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://intu.co.uk/watford");
        driver.findElement(By.xpath("//a [@href= '/watford/sign-up']")).click();
        driver.findElement(By.id("first_name")).sendKeys("Maya");
        driver.findElement(By.id("last_name")).sendKeys("Jaal");
        driver.findElement(By.id("email")).sendKeys("temp.test@yahoo.com");
        driver.findElement(By.id("date_of_birth")).sendKeys("4 March 1980");
        Select dropdown3 = new Select(driver.findElement(By.id("gender"))); //selecting a dropdown field and choosing value from list
        dropdown3.selectByValue("female");
        driver.findElement(By.id("postcode")).sendKeys("HA2 0RS");
        driver.findElement(By.xpath("//button [@class='g-recaptcha | form__btn']")).click();
    }
    @Test
        public void HomeStoreAutoRegistrationTest() {
            System.setProperty("webdriver.chrome.driver", "src\\test\\java\\BrowserDrivers\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.get("https://www.matalan.co.uk/");
            driver.findElement(By.linkText("My Account")).click();
            driver.findElement(By.id("account_form_email")).sendKeys("temp.test@yahoo.com");
            driver.findElement(By.xpath("//button [@type='submit' and @data-behavior='save_button']")).click();
            driver.findElement(By.id("account_form_meta_attributes[first_name][value]")).sendKeys("Temp");
            driver.findElement(By.id("account_form_meta_attributes[last_name][value]")).sendKeys("Trial");
            driver.findElement(By.id("account_form_email_confirmation")).sendKeys("temp.trial@yahoo.com");
            driver.findElement(By.id("account_form_password")).sendKeys("Abcd!2345");
            driver.findElement(By.id("account_form_password_confirmation")).sendKeys("Abcd!2345");
    }
}
