package ru.stqa.pft.addressbook.appmanagerUser;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;


public class SessionHelperUser {

    private FirefoxDriver wd;

    public SessionHelperUser(FirefoxDriver wd) {
        this.wd = wd;
    }

    public void login(String username, String password) {
        wd.findElement(By.id("content")).click();
        wd.findElement(By.name("user")).sendKeys(username);
        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).sendKeys(password);
        wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
    }
}
