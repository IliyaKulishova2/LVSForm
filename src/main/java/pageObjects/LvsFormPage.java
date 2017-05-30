package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Илия on 4/21/2017.
 */
public class LvsFormPage {
    public LvsFormPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(css = "input[name='first_name']")
    private WebElement fieldFirstName;

    @FindBy(css = "input[name='last_name']")
    private WebElement fieldLastName;

    @FindBy(css = "input[name='phone']")
    private WebElement fieldPhoneNumber;

    @FindBy(css = "input[name='email']")
    private WebElement fieldEmail;

    @FindBy(xpath = ".//*[@id='videostreaming-1']/div/div[2]/form/div[11]/div/div/select/option[3]")
    private WebElement selectMake;

    @FindBy(xpath = ".//*[@id='videostreaming-1']/div/div[2]/form/div[12]/div/div/select/option[2]")
    private WebElement selectModel;

    @FindBy(xpath = ".//*[@id='videostreaming-1']/div/div[2]/form/div[13]/div/div/select/option[2]")
    private WebElement selectBody;

    @FindBy(css = ".btn.btn-primary.btn-submit")
    private WebElement clickOnButtonSubmit;

    @FindBy(css = ".btn.btn-primary.btn-message-ok")
    private WebElement clickOnButtonOk;

    @FindBy(css = ".lvsHead")
    private WebElement submitMessage;

    public void fieldFirstName(String firstName){
        fieldFirstName.clear();
        fieldFirstName.sendKeys(firstName);
    }

    public void fieldLastName(String lastName){
        fieldLastName.clear();
        fieldLastName.sendKeys(lastName);
    }

    public void fieldPhoneNumber(String phoneNumber){
        fieldPhoneNumber.sendKeys(phoneNumber);

    }

    public void fieldEmail(String email){
        fieldEmail.clear();
        fieldEmail.sendKeys(email);
    }

    public void selectMake(){
        selectMake.click();
    }

    public void selectModel(){
        selectModel.click();
    }

    public void selectBody(){
        selectBody.click();
    }

    public void clickOnButtonSubmit(){
        clickOnButtonSubmit.click();
    }

    public void clickOnButtonOk(){
        clickOnButtonOk.click();
    }

    public String getFirstName(){
        return fieldFirstName.getAttribute("value");
    }

    public String getLastName(){
        return fieldLastName.getAttribute("value");
    }

    public String getPhoneNumber(){
        return fieldPhoneNumber.getAttribute("value");
    }

    public String getEmail(){
        return fieldEmail.getAttribute("value");
    }

    public String getMessage(){
        return submitMessage.getAttribute("value");
    }
}
