package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LvsFormPage;

import java.util.concurrent.TimeUnit;

/**
 * Created by Iliya on 4/21/2017.
 */
public class LvsFormTest {
    static WebDriver driver;
    public String baseUrl = "http://www.map2.iliya.ixloo.com";
    private LvsFormPage lvsFormPage;
    private String firstName = "First";
    private String lastName = "Last";
    private String phoneNumber = "1111111111";
    private String email = "test_1@dxloo.com";
    private String message = "Your request has been received.";


    @BeforeTest
    public void openBrowser(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl + "/lvsform");
    }


    @Test
    public void fillLVSForm(){
        lvsFormPage = new LvsFormPage(driver);
        lvsFormPage.fieldFirstName(firstName);
        lvsFormPage.fieldLastName(lastName);
        lvsFormPage.fieldPhoneNumber(phoneNumber);
        lvsFormPage.fieldEmail(email);
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);

        Assert.assertEquals(lvsFormPage.getFirstName(), firstName);
        Assert.assertEquals(lvsFormPage.getLastName(), lastName);
        Assert.assertEquals(lvsFormPage.getPhoneNumber(), "111-111-1111");
        Assert.assertEquals(lvsFormPage.getEmail(), email);

        lvsFormPage.selectMake();
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        lvsFormPage.selectModel();
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        lvsFormPage.selectBody();
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        lvsFormPage.clickOnButtonSubmit();
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);

    //    Assert.assertEquals(lvsFormPage.getMessage(), message);
    //    driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);

        lvsFormPage.clickOnButtonOk();



    }

    @AfterTest
    public void closeBrowser(){
        if (driver != null)
        driver.quit();
    }
}
