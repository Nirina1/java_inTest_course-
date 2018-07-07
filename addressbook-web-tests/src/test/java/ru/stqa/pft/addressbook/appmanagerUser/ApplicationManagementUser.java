package ru.stqa.pft.addressbook.appmanagerUser;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class ApplicationManagementUser {
    FirefoxDriver wd;

    private UserHelper userHelper;
    private SessionHelperUser sessionHelperUser;

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
        sessionHelperUser = new SessionHelperUser(wd);
        sessionHelperUser.login("admin", "secret");
    }

    public void stop() {
        wd.quit();
    }

   public UserHelper getUserHelper() {
        return userHelper;
    }
}
