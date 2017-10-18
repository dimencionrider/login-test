package integration.test;

import integration.configuration.IntegrationBase;
import integration.pagemodels.BasicDashboardPage;
import integration.pagemodels.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestForm extends IntegrationBase {

    private LoginPage loginPage;
    private BasicDashboardPage basicDashboardPage;

    public TestForm(String browser) {
        super(browser);
    }

    @BeforeMethod
    public void setupHomePage() {
        loginPage = new LoginPage(driver);
        basicDashboardPage = new BasicDashboardPage(driver);
        openBasicHomePage(BASIC_URL);

    }

    //Login as internal Remit User
    @Test
    public void simpleLoginTest() {
        loginPage.enterUsernameAndPassword(USERNAME_1, PASSWORD_1);
        loginPage.clickLogin();
        basicDashboardPage.waitForPageToLoad();
        basicDashboardPage.verifyThatUserIsSuccessfullyLogged();
    }




}
