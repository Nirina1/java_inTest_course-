package ru.stqa.pft.addressbook.appmanagerUser;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.modelUser.PersonData;

public class UserHelper {

    private FirefoxDriver wd;

    public UserHelper(FirefoxDriver wd) {
        this.wd = wd;

    }

    public void submittingPersonCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillingTheForm(PersonData personNew) {
        type(By.name("firstname"), personNew.getFirstName());
        type(By.name("middlename"), personNew.getMiddleName());
        type(By.name("lastname"), personNew.getLastName());
        type(By.name("company"), personNew.getCompanyName());
        type(By.name("mobile"), personNew.getMobilePhone());
        type(By.name("email"), personNew.getEmailAddress());
    }

    public void deleteUser() {
        // wd.findElement(By.linkText("home")).click();
        if (!wd.findElement(By.id("content")).isSelected())
            click(By.id("content"));
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
        wd.switchTo().alert().accept();
    }

    public void goHomePage() {
        click(By.linkText("home"));
    }



    private void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).sendKeys(text);
    }

    public void newPersonCreation() {
        click(By.linkText("add new"));
    }

    private void click(By locator) {
        wd.findElement(locator).click();
    }
}
