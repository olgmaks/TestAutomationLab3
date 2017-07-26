package epam.com.lab;


import epam.com.lab.bissness.BLoginPage;
import epam.com.lab.bissness.BWriteDraftMessage;
import epam.com.lab.model.Letter;
import epam.com.lab.model.User;
import org.testng.Assert;
import org.testng.annotations.*;

public class DataProviderTest {


    @DataProvider(parallel = true)
    public Object[][] login1() {
        return new Object[][]{{"h.bazyliak@gmail.com", "torgan555"},
                {"sofiia.mailfortesting@gmail.com", "hellow1987"},
                //{"foreverytesting@gmail.com", "123qwertyuiop"},
                {"vladarchenko@gmail.com", "sittermarchenko"},
                //  {"booliynyk@gmail.com", "sitteroliynyk"}
        };
    }

    @Test(dataProvider = "login1", threadPoolSize = 3)
    public void getLogPage(String login, String password) {
        User user = new User(login, password);
        BLoginPage lpage = new BLoginPage();
        lpage.login(user);
        Assert.assertTrue(lpage.isCorrectPassword());
        Letter let = new Letter(Constants1.getValue("ADDRESS"),
                Constants1.getValue("THEME"), Constants1.getValue("TEXT"));
        BWriteDraftMessage page = new BWriteDraftMessage();
        int num1=page.countFromDraftFolder();
        page.writeDraftMessage(let);
        int num2=page.countFromDraftFolder()-1;
        Assert.assertEquals(num1,num2);
        String message = page.textFromDraftMessage();
        Assert.assertEquals(let.getShortContent(), message);
        page.sendMessageFromDraftFolder();
    }


    @AfterMethod
    public void clossBrows() {
        ThreadDriverInstance.close();
    }


}
