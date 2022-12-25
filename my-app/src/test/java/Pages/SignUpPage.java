package Pages;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends BaseSeleniumPage {
    public SignUpPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/section/div[2]/div/div/div/form/div[1]/div/input")
    private WebElement emailField;
    @FindBy(xpath = "/html/body/section/div[2]/div/div/div/form/div[2]/div/input")
    private WebElement nameField;
    @FindBy(xpath = "/html/body/section/div[2]/div/div/div/form/div[3]/div/input")
    private WebElement passwordField;
    @FindBy(xpath = "/html/body/section/div[2]/div/div/div/form/button")
    private WebElement signupBtn;
    @FindBy(xpath = "/html/body/section/div[2]/div/div/div/div")
    private WebElement notification;

    public LoginPage signupWithName(String email, String name, String password){
        emailField.sendKeys(email);
        nameField.sendKeys(name);
        passwordField.sendKeys(password);
        signupBtn.click();

        return new LoginPage();
    }

    public LoginPage signupWithoutName(String email, String password){
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signupBtn.click();

        return new LoginPage();
    }
    public SignUpPage signupWithSameEmail(String email, String password){
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signupBtn.click();

        return this;
    }

    public String getNotification(){
        return notification.getText();
    }
}
