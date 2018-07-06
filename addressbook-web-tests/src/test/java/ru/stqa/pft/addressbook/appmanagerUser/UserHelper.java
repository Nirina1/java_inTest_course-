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

    private void type(By firstname, String firstName) {
        click(firstname);
        wd.findElement(firstname).sendKeys(firstName);
    }

    public void newPersonCreation() {
        click(By.linkText("add new"));
    }

    private void click(By locator) {
        wd.findElement(locator).click();
    }
}
