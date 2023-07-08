package org.overmods.selenium.testsuite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\nikolay\\bin\\chromedriver.exe");
        OverMods om = new OverMods(new ChromeDriver());

        om.open();
        //om.login("test", "test");
        om.signup("test3", "test3@test.org", "test3");
    }
}