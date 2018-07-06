package ru.stqa.pft.addressbook.appmanagerUser;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class ApplicationTestUser {
    FirefoxDriver wd;

    private UserHelper userHelper;

    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public void init() {
        wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/");
        userHelper = new UserHelper(wd);
        logingToAddressbook("admin", "secret");
    }

    private void logingToAddressbook(String username, String password) {
        wd.findElement(By.id("content")).click();
        wd.findElement(By.name("user")).sendKeys(username);
        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).sendKeys(password);
        wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
    }

    public void stop() {
        wd.quit();
    }

    public void deleteUser() {
        wd.findElement(By.linkText("home")).click();
        if (!wd.findElement(By.id("4")).isSelected()) {
            wd.findElement(By.id("4")).click();
        }
        wd.findElement(By.xpath("//div[@id='content']/form[2]/div[2]/input")).click();
    }

    public UserHelper getUserHelper() {
        return userHelper;
    }
}
