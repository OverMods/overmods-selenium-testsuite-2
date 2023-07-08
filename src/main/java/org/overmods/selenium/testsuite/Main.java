package org.overmods.selenium.testsuite;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\nikolay\\bin\\chromedriver.exe");
        OverMods om = new OverMods(new ChromeDriver());

        om.open();
        om.login("test", "test");
        //om.signup("test3", "test3@test.org", "test3");
        om.navigateGame("Minecraft");
        om.navigateMod("test Mod");
        //om.setRating(3);
        //om.writeComment("Selenium test");
        //om.download();
    }
}