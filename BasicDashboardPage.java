package integration.pagemodels;

import integration.configuration.AbstractWebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class BasicDashboardPage extends AbstractWebComponent {

    @FindBy(css = "a[href='/vacation']")
    public WebElement myVacationsNavPannelLink;


    public BasicDashboardPage(WebDriver driver) {
        super(driver);
    }


    //methods _______________________________________________________________________________________

    public void waitForPageToLoad() {
        waitForPage.until(ExpectedConditions.visibilityOf(myVacationsNavPannelLink));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void clickMyVacationsNavPannelLink() {
        myVacationsNavPannelLink.click();
    }

    public void verifyThatUserIsSuccessfullyLogged() {
        waitForPage.until(ExpectedConditions.visibilityOf(myVacationsNavPannelLink));
        Assert.assertTrue(isElementPresent(By.cssSelector("a[href='/vacation']")), "Something went wrong, user is not logged");
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

}