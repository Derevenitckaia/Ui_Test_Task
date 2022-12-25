package Pages;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import readProperities.SiteProperties;

import java.io.IOException;

public class HomePage extends BaseSeleniumPage {
    public HomePage(){
        driver.get("http://localhost:5000/");
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@id=\"navbarMenuHeroA\"]/div/a[2]")
    private WebElement loginBtn;

    @FindBy(xpath = "//*[@id=\"navbarMenuHeroA\"]/div/a[3]")
    private WebElement signupBtn;

    @FindBy(xpath = "/html/body/section/div[2]/div/h1")
    private WebElement title;

    public String getTitle(){
        return title.getText();
    }

    public LoginPage openLogin(){
        loginBtn.click();
        return new LoginPage();
    }
    public SignUpPage openSignup(){
        signupBtn.click();
        return new SignUpPage();
    }



}
