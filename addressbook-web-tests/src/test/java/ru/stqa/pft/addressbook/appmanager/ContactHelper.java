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
        userCache = null;
        goToHomePage();
    }

    public void submitPersonModification() {
        click(By.name("update"));
    }

    public void initPersonModification(int id) {
        wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();

    }

    public void modify(UserData user) {
        initPersonModification(user.getId());
        fillingTheForm(user, false);
        submitPersonModification();
        userCache = null;
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
        userCache = null;
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

    private Users userCache = null;

    public Users all() {
        if (userCache != null) {
            return new Users(userCache);
        }
        userCache = new Users();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement row : elements) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int id = Integer.parseInt(row.findElement(By.tagName("input")).getAttribute("value"));
            String lastName = cells.get(1).getText();
            String firstName = cells.get(2).getText();
            String allPhones = cells.get(5).getText();
            String address = cells.get(3).getText();
            String allEmails = cells.get(4).getText();
            userCache.add(new UserData().withId(id).withFirstName(firstName).withLastName(lastName).
                     withAllPhones(allPhones).withAddress(address).withAllEmails(allEmails));
        }
        return new Users(userCache);
    }

    public UserData infoFromEditForm(UserData user) {
        initPersonModification(user.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");
        String email1 = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        wd.navigate().back();
        return new UserData().withId(user.getId()).withFirstName(firstname).withLastName(lastname)
                .withHomePhone(home).withMobile(mobile).withWorkPhone(work).withAddress(address)
                .withEmail1(email1).withEmail2(email2).withEmail3(email3);

    }
}

