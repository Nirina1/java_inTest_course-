package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class HelperBase {

    protected WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    protected void type(By localizator, String text) {
        click(localizator);
        if (text != null) {
            String existingText = wd.findElement(localizator).getAttribute("value");
            if (! text.equals(existingText)) {
                wd.findElement(localizator).clear();
                wd.findElement(localizator).sendKeys(text);
            }
          }
        }

        protected void click (By localizator){
            wd.findElement(localizator).click();
        }

        public boolean isAlertPresent () {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
            }
        }
    }

