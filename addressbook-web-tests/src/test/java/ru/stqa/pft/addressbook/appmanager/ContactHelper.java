package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.modelGroup.UserData;
import ru.stqa.pft.addressbook.modelGroup.Users;

import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);

    }


    public void submittingPersonCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillingTheForm(UserData personNew, boolean creation) {
        type(By.name("firstname"), personNew.getFirstName());
        type(By.name("lastname"), personNew.getLastName());
        //type(By.name("company"), personNew.getCompanyName());
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

    public void delete(UserData user) {
        selectUserById(user.getId());
        deleteUser();
        goToHomePage();
    }

    public void submitPersonModification() {
        click(By.name("update"));
    }

    public void initPersonModification(int id) {
        wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();

    }

    public void modify(UserData user) {
        //selectUserById(user.getId());
        initPersonModification(user.getId());
        fillingTheForm(user, false);
        submitPersonModification();
        goToHomePage();
    }

    public void goToHomePage() {

        click(By.linkText("home"));

    }

    public void addNew() {
        click(By.linkText("add new"));
    }

    public void create(UserData user) {
        addNew();
        fillingTheForm(user, true);
        submittingPersonCreation();
        goToHomePage();
    }

    public boolean isThereAUser() {
        return isElementPresent(By.name("selected[]"));

    }

    public void selectUserById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public Users all() {
        Users users = new Users();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement row : elements) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            String firstName = cells.get(2).getText();
            String lastName = cells.get(1).getText();
            int id = Integer.parseInt(row.findElement(By.tagName("input")).getAttribute("value"));
            users.add(new UserData().withId(id).withName(firstName).withLastName(lastName));
        }
        return users;
    }

}

