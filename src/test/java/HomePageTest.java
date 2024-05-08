import org.example.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.List;
import static org.openqa.selenium.By.xpath;

public class HomePageTest extends Class {

    @Test
    @DisplayName("Отображение названия страницы Test home page ")
    void getPageName() {
        driver.get("http://localhost:5000/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement pageName = driver.findElement(xpath("//h1[@class='title']"));
        Assertions.assertEquals("Test home page", pageName.getText());
    }

    @Test
    @DisplayName("Отображение кнопки 'Home'")
    void getButtonHome() {
        driver.get("http://localhost:5000/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement buttonHome = driver.findElement(By.cssSelector("a.navbar-item "));
        Assertions.assertEquals("Home", buttonHome.getText());
    }

    @Test
    @DisplayName("Отображение кнопки 'Login'")
    void getButtonLogin() {
        driver.get("http://localhost:5000/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        List<WebElement> buttonLogin = driver.findElements(By.cssSelector("a.navbar-item"));
        Assertions.assertEquals("Login", buttonLogin.get(1).getText());
    }

    @Test
    @DisplayName("Отображение кнопки 'Sign Up'")
    void getButtonSignUp() {
        driver.get("http://localhost:5000/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        List<WebElement> buttonSignUp = driver.findElements(By.cssSelector("a.navbar-item"));
        Assertions.assertEquals("Sign Up", buttonSignUp.get(2).getText());
    }

    @Test
    @DisplayName("Валидность окна 'Login' при клике на кнопку 'Login'")
    void getFrameLogin() {
        driver.get("http://localhost:5000/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement buttonLogin = driver.findElement(xpath("//*[contains(text(),'Login')]"));
        buttonLogin.click();
        WebElement frameButtonLogin = driver.findElement(xpath("//h3[@class='title']"));
        Assertions.assertEquals("Login", frameButtonLogin.getText());
    }

    @Test
    @DisplayName("Валидность  окна 'Sign Up' при клике на кнопку 'Sigh Up'")
    void getFrameSignUp() {
        driver.get("http://localhost:5000/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement buttonSignUp = driver.findElement(xpath("//*[contains(text(),'Sign Up')]"));
        buttonSignUp.click();
        WebElement frameButtonSignUp = driver.findElement(xpath("//h3[@class='title']"));
        Assertions.assertEquals("Sign Up", frameButtonSignUp.getText());
    }

    @Test
    @DisplayName("Валидность поля ввода 'Email' при регистрации пользователя.")
    void getEmailFieldInSignUpFrame() throws InterruptedException {
        driver.get("http://localhost:5000/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement buttonSignUp = driver.findElement(xpath("//*[contains(text(),'Sign Up')]"));
        buttonSignUp.click();
        Thread.sleep(3000L);
        WebElement fieldEmail = driver.findElement(xpath("//input[@type='email']"));
        Assertions.assertTrue(fieldEmail.isEnabled());
    }

    @Test
    @DisplayName("Валидность поля ввода 'Name' при регистрации пользователя.")
    void getFieldNameInSignUpFrame() throws InterruptedException {
        driver.get("http://localhost:5000/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement buttonSignUp = driver.findElement(xpath("//*[contains(text(),'Sign Up')]"));
        buttonSignUp.click();
        Thread.sleep(3000L);
        WebElement fieldName = driver.findElement(By.cssSelector("input.input.is-large"));
        Assertions.assertTrue(fieldName.isEnabled());
    }

    @Test
    @DisplayName("Валидность  поля ввода 'Password' при регистрации пользователя.")
    void getFieldPassInSignUpFrame() throws InterruptedException {
        driver.get("http://localhost:5000/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement buttonSignUp = driver.findElement(xpath("//*[contains(text(),'Sign Up')]"));
        buttonSignUp.click();
        Thread.sleep(3000L);
        WebElement fieldPass = driver.findElement(xpath("//input[@type='password']"));
        Assertions.assertTrue(fieldPass.isEnabled());
    }

    @Disabled
    @Test
    @DisplayName("Отображение сообщения об ошибке при авторизации с пустыми полями")
    void getMessageErrorInAuthorization() throws InterruptedException {
        driver.get("http://localhost:5000/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement buttonLogin = driver.findElement(xpath("//*[contains(text(),'Login')]"));
        buttonLogin.click();
        WebElement buttonLoginToAuthorization = driver.findElement(
                xpath("//button[@class='button is-block is-info is-large is-fullwidth']"));
        buttonLoginToAuthorization.click();
        Thread.sleep(3000l);
        WebElement frameNotification = driver.findElement(xpath("//div[@class='notification is-danger']"));
        Assertions.assertEquals("Please check your login details and try again.", frameNotification.getText());
    }

    @Test
    @DisplayName("Отображение сообщения об ошибке при регистрации пользователя с пустыми полями на странице ")
    void getMessageErrorInSignUpFrame() throws InterruptedException {
        driver.get("http://localhost:5000/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement buttonSignUp = driver.findElement(xpath("//*[contains(text(),'Sign Up')]"));
        buttonSignUp.click();
        Thread.sleep(3000L);
        WebElement buttonSignUpRegistration = driver.
                findElement(By.xpath("//button[@class='button is-block is-info is-large is-fullwidth']"));
        buttonSignUpRegistration.click();
        Thread.sleep(3000L);
        WebElement frameNotification = driver.findElement(By.xpath("//div[@class='notification is-danger']"));
        Assertions.assertEquals("Email address already exists. Go to login page.", frameNotification.getText());
    }

    @Test
    @DisplayName("Ошибка авторизации  при незаполненом 'Email'")
    void getErrorThrowAuthorizationWithEmptyEmail() throws InterruptedException {
        driver.get("http://localhost:5000/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement buttonLogin = driver.findElement(xpath("//*[contains(text(),'Login')]"));
        buttonLogin.click();
        WebElement fieldPass = driver.findElement(By.xpath("//input[@type='password']"));
        fieldPass.sendKeys("Denisov");
        WebElement checkBox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        checkBox.click();
        WebElement buttonLoginToAuthorization = driver.findElement(
                xpath("//button[@class='button is-block is-info is-large is-fullwidth']"));
        buttonLoginToAuthorization.click();
        Thread.sleep(3000l);
        WebElement frameNotification = driver.
                findElement(By.
                        xpath("//div[@class='notification is-danger']"));
        Assertions.assertEquals("Please check your login details and try again.", frameNotification.getText());
    }

    @Test
    @DisplayName("Ошибка авторизациипри при отсуствии 'Password'")
    void getErrorThrowAuthorizationWithEmptyPass() throws InterruptedException {
        driver.get("http://localhost:5000/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement buttonLogin = driver.findElement(xpath("//*[contains(text(),'Login')]"));
        buttonLogin.click();
        WebElement fieldEmail = driver.findElement(By.xpath("//input[@type='email']"));
        fieldEmail.sendKeys("Waste11@mail.ru");
        WebElement checkBox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        checkBox.click();
        WebElement buttonLoginToAuthorization = driver.findElement(
                xpath("//button[@class='button is-block is-info is-large is-fullwidth']"));
        buttonLoginToAuthorization.click();
        Thread.sleep(3000l);
        WebElement frameNotification = driver.
                findElement(By.
                        xpath("//div[@class='notification is-danger']"));
        Assertions.assertEquals("Please check your login details and try again.", frameNotification.getText());
    }

    @Test
    @DisplayName("Успешная авторизация  при заполнении всех полей")
    void getSuccessAuthorizationInLoginFrame() throws InterruptedException {
        driver.get("http://localhost:5000/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        HomePage homePage = new HomePage(driver);
        homePage.getAuthorizationInPage(getLogin(),getPassword());
        WebElement pageTitle = driver.findElement(By.xpath("//h1[@class='title']"));
        Assertions.assertEquals("Welcome, Pavel!", pageTitle.getText());
    }

    @Test
    @DisplayName("Успешный выход из аккаунта пользователя на главную страницу 'Test home Page'")
    void getExitFromAccount() throws InterruptedException {
        driver.get("http://localhost:5000/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement buttonLogin = driver.findElement(xpath("//*[contains(text(),'Login')]"));
        buttonLogin.click();
        Thread.sleep(5000l);
        WebElement fieldEmail = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//input[@type='email']")));
        fieldEmail.sendKeys("waste11@mail.ru");

        WebElement fieldPass = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//input[@type='password']")));
        fieldPass.sendKeys("Denisov");
        WebElement buttonLoginToAuthorization = driver.findElement(
                xpath("//button[@class='button is-block is-info is-large is-fullwidth']"));
        buttonLoginToAuthorization.click();
        WebElement buttonLogOut = driver.findElement(xpath("//*[contains(text(),'Logout')]"));
        buttonLogOut.click();
        WebElement titlePage = driver.findElement(xpath("//h1[@class='title']"));
        Assertions.assertEquals("Test home page", titlePage.getText());
    }
}