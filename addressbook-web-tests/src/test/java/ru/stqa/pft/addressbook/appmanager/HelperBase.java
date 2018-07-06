package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HelperBase {

    protected FirefoxDriver wd;

    public HelperBase(FirefoxDriver wd) {
        this.wd = wd;
    }

    protected void type(By localizator, String text) {
        click(localizator);
        wd.findElement(localizator).clear();
        wd.findElement(localizator).sendKeys(text);
    }

    protected void click(By localizator) {
        wd.findElement(localizator).click();
    }
}
