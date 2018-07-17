package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.modelGroup.GroupData;
import ru.stqa.pft.addressbook.modelGroup.PersonData;

public class TestsHelper extends HelperBase {

    public TestsHelper(WebDriver wd) {
        super(wd);

    }

    public void returnToGroupPage() {
        click(By.linkText("groups"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void deleteSelectedGroups() {
        click(By.name("delete"));
    }

    public void selectGroup() {
        click(By.name("selected[]"));
    }

    public void selectUser() {
        click(By.name("selected[]"));
    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public void submittingPersonCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillingTheForm(PersonData personNew, boolean creation) {
        type(By.name("firstname"), personNew.getFirstName());
        type(By.name("lastname"), personNew.getLastName());
        type(By.name("company"), personNew.getCompanyName());
        type(By.name("mobile"), personNew.getMobilePhone());
        type(By.name("email"), personNew.getEmailAddress());

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
}
