package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.Retry;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "UserNamesAndPassword", dataProviderClass = UserNamesAndPassword.class, retryAnalyzer = Retry.class
            , description = "Checking the the specified password and user names")

    public void open(String userName, String password) {

        loginPage.open();
        loginPage.fillOutFieldsOfRegistration(userName,
                password);
        Assert.assertEquals(loginPage.findElementNamePageProducts(), "PRODUCTS", "Element was not found," +
                " password or (and) user_name is wrong");
    }

}
