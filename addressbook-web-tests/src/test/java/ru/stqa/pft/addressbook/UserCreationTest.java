package ru.stqa.pft.addressbook;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

public class UserCreationTest extends UserTestbase{

    @Test
    public void testUserCreationTest() {

        newPersonCreation();
        fillingTheForm(new newPersonData("NewUser", "TestName", "TestLastName", "TestCompany", "4872812406", "example@test.com"));
        submittingPersonCreation();
    }

}
