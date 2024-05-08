package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[contains(text(),'Login')]")
    private WebElement buttonLogin;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement fieldEmail;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement fieldPass;

    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement checkBox;

    @FindBy(xpath = "//button[@class='button is-block is-info is-large is-fullwidth']")
    private WebElement buttonLoginToAuth;

    public void getAuthorizationInPage(String email,String pass) throws InterruptedException {
        buttonLogin.click();
        fieldEmail.sendKeys(email);
        fieldPass.sendKeys(pass);
        checkBox.click();
        buttonLoginToAuth.click();
    }
}
