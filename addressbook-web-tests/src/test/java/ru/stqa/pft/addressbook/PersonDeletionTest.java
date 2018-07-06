package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

import org.openqa.selenium.*;

public class PersonDeletionTest extends UserTestbase {

    @Test
    public void testPersonDeletion() {
        wd.findElement(By.name("searchform")).click();
        wd.findElement(By.linkText("home")).click();
        wd.findElement(By.name("selected[]")).click();
        wd.findElement(By.name("delete")).click();
        wd.findElement(By.linkText("home")).click();
    }
}
