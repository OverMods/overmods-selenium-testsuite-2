package org.overmods.selenium.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OverMods {
    private final WebDriver driver;

    public OverMods(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("http://localhost/overmods");
    }

    WebElement waitFor(By by) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void login(String login, String pass) {
        WebElement divLogin = waitFor(By.xpath("//img[@class='login_icon']"));
        divLogin.click();

        WebElement inputLogin = waitFor(By.id("overmodsLogin_username"));
        WebElement inputPass = waitFor(By.id("overmodsLogin_password"));
        WebElement submit = waitFor(By.xpath("//button[text()='Log in']"));

        inputLogin.sendKeys(login);
        inputPass.sendKeys(pass);
        submit.click();
    }

    public void signup(String login, String email, String pass) {
        WebElement divLogin = waitFor(By.xpath("//img[@class='login_icon']"));
        divLogin.click();

        WebElement signUp = waitFor(By.xpath("//button[@class='ghost_button' and @id='signUp']"));
        signUp.click();

        WebElement inputLogin = waitFor(By.id("overmodsSignup_username"));
        WebElement inputEmail = waitFor(By.id("overmodsSignup_email"));
        WebElement inputPass = waitFor(By.id("overmodsSignup_password"));
        WebElement inputConfirm = waitFor(By.id("overmodsSignup_confirm_password"));
        WebElement submit = waitFor(By.xpath("//button[text()='Log in']"));

        inputLogin.sendKeys(login);
        inputEmail.sendKeys(email);
        inputPass.sendKeys(pass);
        inputConfirm.sendKeys(pass);
        //submit.click();
    }
}
