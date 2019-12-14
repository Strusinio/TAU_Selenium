package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SignInPage {

    private WebDriver webDriver;

    public SignInPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public WebElement getCreateAccountButton() {
        return webDriver.findElement(By.name("SubmitCreate"));
    }
    public WebElement getEmailInput() {
        return webDriver.findElement(By.name("email_create"));
    }
    public WebElement getRegisterButton() {
        return webDriver.findElement(By.name("submitAccount"));
    }
    public WebElement getValidationError() {
        return webDriver.findElement(By.xpath("//*[@id=\"center_column\"]/div"));
    }
    public WebElement getGenderMale() {
        return webDriver.findElement(By.id("uniform-id_gender1"));
    }
    public WebElement getFirstName() {
        return webDriver.findElement(By.name("customer_firstname"));
    }
    public WebElement getLastName() {
        return webDriver.findElement(By.name("customer_lastname"));
    }
    public WebElement getPassword() {
        return webDriver.findElement(By.name("passwd"));
    }
    public Select getDay() {
        return new Select(webDriver.findElement(By.name("days")));
    }
    public Select getMonth() {
        return new Select(webDriver.findElement(By.name("months")));
    }
    public Select getYear() {
        return new Select(webDriver.findElement(By.name("years")));
    }
    public WebElement getAdress() {
        return webDriver.findElement(By.name("address1"));
    }
    public WebElement getCity() {
        return webDriver.findElement(By.name("city"));
    }
    public Select getState(){
        return new Select(webDriver.findElement(By.name("id_state")));
    }
    public WebElement getZip(){
        return webDriver.findElement(By.name("postcode"));
    }
    public Select getCountry(){
        return new Select(webDriver.findElement(By.name("id_country")));
    }
    public WebElement getMobilePhone(){
        return webDriver.findElement(By.name("phone_mobile"));
    }
    public WebElement getAdressReference(){
        return webDriver.findElement(By.name("alias"));
    }
    public WebElement getWelcomeMsg() {
        return webDriver.findElement(By.xpath("//*[@id=\"center_column\"]/p"));
    }

}
