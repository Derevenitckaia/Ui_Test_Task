package Pages;

import core.BaseSeleniumTest;
import org.junit.Assert;
import org.junit.Test;

public class PagesTest extends BaseSeleniumTest {

    //    Нужно ввести  новые данные, т.к эти уже зарегистрированы

    @Test
    public void checkSignup1(){
        String email = "qwerty20@gmail.com";
        String name = "qwerty10";
        String password = "qwerty";
        String profilePageTitle = "Welcome, qwerty10!";
        HomePage homePage = new HomePage();
        SignUpPage signupPage = homePage.openSignup();
        LoginPage loginPage = signupPage.signupWithName(email, name, password);
        ProfilePage profilePage = loginPage.auth(email, password);
        Assert.assertEquals(profilePage.getTitle(), profilePageTitle);

    }

    //    Нужно ввести  новые данные, т.к эти уже зарегистрированы
    @Test
    public void checkSignup2(){
        String email = "qwerty210@gmail.com";
        String password = "qwerty";
        String profilePageTitle = "Welcome, !";
        HomePage homePage = new HomePage();
        SignUpPage signupPage = homePage.openSignup();
        LoginPage loginPage = signupPage.signupWithoutName(email, password);
        ProfilePage profilePage = loginPage.auth(email, password);
        Assert.assertEquals(profilePage.getTitle(), profilePageTitle);

    }


    @Test

    public void checkSignupWithSameEmail(){
        String email = "qwerty101@gmail.com";
        String password = "qwerty";
        String notification = "Email address already exists. Go to login page.";
        HomePage homePage = new HomePage();
        SignUpPage signupPage = homePage.openSignup();
        signupPage  = signupPage.signupWithSameEmail(email, password);
        Assert.assertEquals(signupPage.getNotification(), notification);


    }

    @Test
    public void checkLoginAndLogout(){
        String email = "qwerty@gmail.com";
        String password = "qwerty";
        String homePageTitle = "Test home page";
        String profilePageTitle = "Welcome, qwerty!";
        HomePage homePage = new HomePage();
        Assert.assertEquals(homePage.getTitle(), homePageTitle);
        LoginPage loginPage = homePage.openLogin();
        ProfilePage profilePage = loginPage.auth(email, password);
        Assert.assertEquals(profilePage.getTitle(), profilePageTitle);

        //logout check
        homePage = profilePage.logout();
        Assert.assertEquals(homePage.getTitle(), homePageTitle);


    }
    @Test
    public void checkInvalidPassword(){
        String email = "qwerty@gmail.com";
        String password = "qwert";
        String homePageTitle = "Test home page";
        String notification = "Please check your login details and try again.";
        HomePage homePage = new HomePage();
        Assert.assertEquals(homePage.getTitle(), homePageTitle);
        LoginPage loginPage = homePage.openLogin();
        loginPage = loginPage.invalidAuth(email, password);
        Assert.assertEquals(loginPage.getNotification(), notification);

    }
    @Test
    public void checkInvalidEmail(){
        String email = "qwert@gmail.com";
        String password = "qwerty";
        String homePageTitle = "Test home page";
        String notification = "Please check your login details and try again.";
        HomePage homePage = new HomePage();
        Assert.assertEquals(homePage.getTitle(), homePageTitle);
        LoginPage loginPage = homePage.openLogin();
        loginPage = loginPage.invalidAuth(email, password);
        Assert.assertEquals(loginPage.getNotification(), notification);

    }

}
