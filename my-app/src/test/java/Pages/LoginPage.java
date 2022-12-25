package Pages;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseSeleniumPage {
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/section/div[2]/div/div/div/form/div[1]/div/input")
    private WebElement emailField;
    @FindBy(xpath = "/html/body/section/div[2]/div/div/div/form/div[2]/div/input")
    private WebElement passField;
    @FindBy(xpath = "/html/body/section/div[2]/div/div/div/form/div[3]/label")
    private WebElement checkBox;
    @FindBy(xpath = "/html/body/section/div[2]/div/div/div/form/button")
    private WebElement loginBtn;
    @FindBy(xpath = "/html/body/section/div[2]/div/div/div/div")
    private WebElement notification;

    public ProfilePage auth(String email, String password){
        emailField.sendKeys(email);
        passField.sendKeys(password);
        loginBtn.click();
        return new ProfilePage();
    }
    public String getNotification(){
        return notification.getText();
    }

    public LoginPage invalidAuth(String email, String password){
        emailField.sendKeys(email);
        passField.sendKeys(password);
        loginBtn.click();
        return this;

    }




}
