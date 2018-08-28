package ru.stqa.pft.addressbook.tests;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.modelGroup.UserData;
import ru.stqa.pft.addressbook.modelGroup.Users;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;



public class UserCreationTest extends TestBase {

    @DataProvider
    public Iterator<Object[]> validUsersForXml() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/users.xml")))) {
            String xml = "";
            String line = reader.readLine();
            while (line != null) {
                xml += line;
                line = reader.readLine();
            }
            XStream xstream = new XStream();
            xstream.processAnnotations(UserData.class);
            List<UserData> users = (List<UserData>) xstream.fromXML(xml);
            return users.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
        }
    }

    @DataProvider
    public Iterator<Object[]> validUsersForJson() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/users.json")))) {
            String json = "";
            String line = reader.readLine();
            while (line != null) {
                json += line;
                line = reader.readLine();
            }

            Gson gson = new Gson();
            List<UserData> users = gson.fromJson(json, new TypeToken<List<UserData>>() {
            }.getType());
            return users.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
        }
    }


    @Test(dataProvider = "validUsersForJson")
    public void testUserCreationTest(UserData user) {
        Users before = app.db().users();
        //File photo = new File("src/test/resources/alpaka.png");
        app.users().goToHomePage();
        app.users().create(user);
        assertThat(app.users().getContactCount(), equalTo(before.size() + 1));
        Users after = app.db().users();
        assertThat(after, equalTo(
                before.withAdded(user.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
        verifyUserListInUI();
    }


}
