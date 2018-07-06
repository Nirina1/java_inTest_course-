package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class PersonDeletionTest extends UserTestbase {

    @Test
    public void testPersonDeletion() {
        //wd.findElement(By.cssSelector("body")).click();
        deleteUser();

        }

}


