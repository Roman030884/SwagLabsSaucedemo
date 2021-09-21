package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {


    private static final By LOGIN_BUTTON = By.cssSelector("#login-button");
    private static final By USER_NAME_FIELD = By.id("user-name");
    private static final By PASSWORD_FIELD = By.id("password");
    private static final String URL_LOGIN_PAGE = "https://www.saucedemo.com/";
    private static final By PRODUCTS_PAGE_NAME = By.xpath("//span[text()='Products']");
    private static final String userName = "performance_glitch_user";
    private static final String password = "secret_sauce";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open login page")
    public void open() {
        driver.get(URL_LOGIN_PAGE);
    }

    @Step("Log in to your personal account")
    public void inputUserNameAndPasswordClickLogin() {
        driver.findElement(USER_NAME_FIELD).sendKeys(userName);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

    @Step("Find element name page Products")
    public String findElementNamePageProducts() {
        return driver.findElement(PRODUCTS_PAGE_NAME).getText();
    }

    @Step("Filling out the field user name and password from the UserNamesAndPassword.xlsx file")
    public void fillOutFieldsOfRegistration(String userName, String password) {
        driver.findElement(USER_NAME_FIELD).sendKeys(userName);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();

    }
}
