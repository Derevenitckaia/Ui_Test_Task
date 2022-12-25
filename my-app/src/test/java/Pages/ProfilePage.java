package Pages;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends BaseSeleniumPage {
    public ProfilePage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "/html/body/section/div[2]/div/h1")
    private WebElement title;
    @FindBy(xpath = "//*[@id=\"navbarMenuHeroA\"]/div/a[3]")
    private WebElement logoutBtn;

    public String getTitle(){
        return title.getText();
    }

    public HomePage logout(){
        logoutBtn.click();
        return new HomePage();
    }
}
