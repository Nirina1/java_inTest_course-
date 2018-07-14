package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperBase {

    protected WebDriver wd;

    public HelperBase(WebDriver wd) {
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
