package ru.stqa.pft.addressbook.testGroup;


import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.modelGroup.UserData;
import ru.stqa.pft.addressbook.modelGroup.Users;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;



public class UserCreationTest extends TestBase {

    @DataProvider
    public Iterator<Object[]> validUsers() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/users.xml")));
        String xml = "";
        String line = reader.readLine();
        while (line != null){
            xml += line;
            line = reader.readLine();
        }
        XStream xstream = new XStream();
        xstream.processAnnotations(UserData.class);
        List<UserData>  users = (List<UserData>) xstream.fromXML(xml);
        return users.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
    }


    @Test(dataProvider = "validUsers")
    public void testUserCreationTest(UserData user) {
        app.goTo().goHomePage();
        Users before = app.contacts().all();
        //File photo = new File("src/test/resources/alpaka.png");
        //UserData user = new UserData().withFirstName("test10").withLastName("test").withPhoto(photo).withGroup("test1");
        app.contacts().create(user);
        assertThat(app.contacts().getContactCount(), equalTo(before.size() + 1));
        Users after = app.contacts().all();
        assertThat(after, equalTo(
                before.withAdded(user.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }

    @Test
    public void testCurrentDir() {
        File currentDir = new File(".");
        System.out.println(currentDir.getAbsolutePath());
        File photo = new File("src/test/resources/alpaka.png");
        System.out.println(photo.getAbsolutePath());
        System.out.println(photo.exists());
    }

}
