package ru.stqa.pft.addressbook.testUser;

import org.testng.annotations.Test;

public class PersonDeletionTest extends UserTestbase {

    @Test
    public void testPersonDeletion() {
        //wd.findElement(By.cssSelector("body")).click();
        applicationTestUser.deleteUser();

        }

}


