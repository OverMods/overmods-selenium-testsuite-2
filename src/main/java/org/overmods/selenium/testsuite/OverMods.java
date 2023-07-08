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

    public void navigateGame(String title) {
        WebElement pGame = waitFor(By.xpath(String.format("//p[@game='%s']", title)));
        pGame.click();
    }

    public void navigateMod(String title) {
        WebElement h3Title = waitFor(By.xpath(String.format("//h3[text()='%s']", title)));
        h3Title.click();
    }

    public void setRating(int rating) {
        WebElement labelStar = waitFor(By.xpath(String.format("//label[@for='star%d']", 5-rating+1)));
        labelStar.click();
    }

    public void writeComment(String comment) {
        WebElement textareaComment = waitFor(By.xpath("//textarea[@id='overmodsCommentArea']"));
        WebElement submit = waitFor(By.xpath("//button[@type='submit' and text()='Post']"));

        textareaComment.sendKeys(comment);
        submit.click();
    }

    public void download() {
        WebElement buttonDownload = waitFor(By.xpath("//button[@class='download']"));
        buttonDownload.click();
    }

    public void profile() {
        waitFor(By.xpath("//img[@class='profile_icon']")).click();
    }

    public void updateEmail(String currentEmail, String newEmail) {
        waitFor(By.xpath("//div[@class='container'][2]")).click();
        ////*[@id="app"]/div[3]/div[1]/div[2]/div[3]/div[3]/div[1]/div/span[2]
    }
}
