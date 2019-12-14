import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.MainPage;
import pageObject.SignInPage;

public class test {

    private static final String MAIN_PAGE_URL = "http://automationpractice.com/index.php";
    private MainPage mainPage;
    private SignInPage signInPage;
    private WebDriver driver;


    @Before
    public void setUp() {
        WebDriverManager.chromedriver().version("79.0.3945.36").setup();
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        signInPage = new SignInPage(driver);
    }

    @Test
    public void testGoToSignInPage() throws InterruptedException {
        driver.get(MAIN_PAGE_URL);
        Thread.sleep(1000);
        WebElement signInButton = mainPage.getSignInButton();
        signInButton.click();
        Thread.sleep(2000);
        signInPage.getEmailInput().sendKeys("test8918955@mail.com");
        WebElement createAccount = signInPage.getCreateAccountButton();
        createAccount.click();
        Thread.sleep(2000);
        signInPage.getRegisterButton().click();
        Thread.sleep(2000);
        WebElement validationError = signInPage.getValidationError();
        Assert.assertTrue(validationError.isDisplayed());
        Assert.assertTrue(validationError.getText().contains("There are 8 errors"));//invalid registration test
    }

    @Test
    public void testGoToSignInPage2() throws InterruptedException {
        driver.get(MAIN_PAGE_URL);
        Thread.sleep(1000);
        WebElement signInButton = mainPage.getSignInButton();
        signInButton.click();
        Thread.sleep(2000);
        String emailStart = RandomStringUtils.randomAlphabetic(8);
        signInPage.getEmailInput().sendKeys(emailStart + "@mail.com");
        WebElement createAccount = signInPage.getCreateAccountButton();
        createAccount.click();
        Thread.sleep(3000);
        signInPage.getGenderMale().click();
        signInPage.getFirstName().sendKeys("TestName");
        signInPage.getLastName().sendKeys("TestLast");
        signInPage.getPassword().sendKeys("password");
        signInPage.getDay().selectByValue("4");
        signInPage.getMonth().selectByValue("12");
        signInPage.getYear().selectByValue("1991");
        signInPage.getAdress().sendKeys("Langdon way, PO Box 386, Windows");
        signInPage.getCity().sendKeys("Las Vegas");
        signInPage.getState().selectByValue("28");
        signInPage.getZip().sendKeys("80424");
        signInPage.getCountry().selectByValue("21");
        signInPage.getMobilePhone().sendKeys("123456789");
        signInPage.getAdressReference().sendKeys("LasVegasTest");
        signInPage.getRegisterButton().click();
        Thread.sleep(2000);
        Assert.assertEquals("Welcome to your account. Here you can manage all of your personal information and orders.", signInPage.getWelcomeMsg().getText());

    }

    @Test
    public void testGoToSignInPage3() throws InterruptedException {
        driver.manage().window().setSize(new Dimension(600, 400));
        driver.get(MAIN_PAGE_URL);
        Thread.sleep(1000);
        WebElement signInButton = mainPage.getSignInButton();
        signInButton.click();
        Thread.sleep(2000);
        String emailStart = RandomStringUtils.randomAlphabetic(8);
        signInPage.getEmailInput().sendKeys(emailStart + "@mail.com");
        WebElement createAccount = signInPage.getCreateAccountButton();
        createAccount.click();
        Thread.sleep(3000);
        signInPage.getGenderMale().click();
        signInPage.getFirstName().sendKeys("TestName");
        signInPage.getLastName().sendKeys("TestLast");
        signInPage.getPassword().sendKeys("password");
        signInPage.getDay().selectByValue("4");
        signInPage.getMonth().selectByValue("12");
        signInPage.getYear().selectByValue("1991");
        signInPage.getAdress().sendKeys("Langdon way, PO Box 386, Windows");
        signInPage.getCity().sendKeys("Las Vegas");
        signInPage.getState().selectByValue("28");
        signInPage.getZip().sendKeys("80-424");
        signInPage.getCountry().selectByValue("21");
        signInPage.getMobilePhone().sendKeys("123456789");
        signInPage.getAdressReference().sendKeys("LasVegasTest");
        signInPage.getRegisterButton().click();
        Thread.sleep(2000);
        Assert.assertTrue(signInPage.getValidationError().getText().contains("There is 1 error"));
        Assert.assertTrue(signInPage.getValidationError().getText().contains("The Zip/Postal code you've entered is invalid. It must follow this format: 00000"));

    }

    @After
    public void after() {
        driver.quit();
    }
}
