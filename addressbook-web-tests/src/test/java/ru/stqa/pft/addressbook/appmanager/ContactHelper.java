package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.modelGroup.PersonData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);

    }


    public void submittingPersonCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillingTheForm(PersonData personNew, boolean creation) {
        type(By.name("firstname"), personNew.getFirstName());
        type(By.name("lastname"), personNew.getLastName());
        type(By.name("company"), personNew.getCompanyName());
        //type(By.name("mobile"), personNew.getMobilePhone());
        //type(By.name("email"), personNew.getEmailAddress());


        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(personNew.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void deleteUser() {
        if (!wd.findElement(By.id("content")).isSelected())
            click(By.id("content"));
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
        wd.switchTo().alert().accept();
    }

    public void submitPersonModification() { click(By.name("update")); }

    public void initPersonModification() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }

    public void newPersonCreation() {
        click(By.linkText("add new"));
    }

    public void createUser(PersonData user) {
        fillingTheForm(user, true );
        submittingPersonCreation();
    }

    public boolean isThereAUser() {
        return isElementPresent(By.name("selected[]"));

    }

    public void selectUser(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<PersonData> getContactList() {
        List<PersonData> users = new ArrayList<PersonData>();
        List<WebElement> elements = wd.findElements(By.name("selected[]"));//id("maintable"));
        for (WebElement element : elements) {
            String name = element.getText();
            PersonData user = new PersonData("firstname", "lastname", null, null);
            users.add(user);
        }
        return users;
    }
}
