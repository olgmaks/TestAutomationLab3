package SeleniumTest;

import SeleniumTest.business_objects.GmailInBoxBO;
import SeleniumTest.business_objects.GmailLoginBO;
import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class ImpotrantMarkAndDeleteTest {


    @DataProvider(parallel = true)
    public Object[][] getTestData() {
        URLPropertyReader urlReader = new URLPropertyReader("url");
        UserPropertyReader firstUser = new UserPropertyReader("firstUser");
        UserPropertyReader secondUser = new UserPropertyReader("secUser");
        UserPropertyReader thirdUser = new UserPropertyReader("thirdUser");

        return new Object[][]{
                {urlReader.URL, firstUser.login, firstUser.password},
                {urlReader.URL, secondUser.login, secondUser.password},
                {urlReader.URL, thirdUser.login, thirdUser.password}
        };
    }

    @Test(dataProvider = "getTestData", threadPoolSize=3)
    public void LoginSetImportantAndDelete(String URL, String login, String password) {
        System.out.println("Url is "+URL+" login is "+login+" and password is "+password);

        DriverManager.startConnection(URL);
        boolean checker;
        GmailLoginBO I=new GmailLoginBO();
        checker = I.asUser(login);
        Assert.assertEquals(checker, true);
        checker = I.withPassword(password);
        Assert.assertEquals(checker, true);
        GmailInBoxBO inbox = new GmailInBoxBO();
        inbox.safeCurrentImportantLetters();
        int first = inbox.markNextAsImportant(0);
        int second = inbox.markNextAsImportant(first+1);
        int third = inbox.markNextAsImportant(second+1);
        Assert.assertTrue(first>=0);
        Assert.assertTrue(second>=0);
        Assert.assertTrue(third>=0);
        List<Integer> changes =inbox.findChanges();

        Assert.assertTrue(changes.size()==3);
        Assert.assertTrue(changes.get(0)>=0);
        Assert.assertTrue(changes.get(1)>=0);
        Assert.assertTrue(changes.get(2)>=0);


        inbox.safeCurrentImportantLetters();
        inbox.deleteLettersFromImportant(changes);
        changes.clear();
        for (int change: changes
                ) {
            System.out.print(change+" ");
        }
        System.out.println("size= "+changes.size());
        changes = inbox.findChanges();
        for (int change: changes
             ) {
            System.out.print(change+" ");
        }
        System.out.println("size= "+changes.size());
        Assert.assertTrue(changes.size()==3);
        Assert.assertTrue(changes.get(0)<0);
        Assert.assertTrue(changes.get(1)<0);
        Assert.assertTrue(changes.get(2)<0);
        DriverManager.closeDriver();
    }


}
