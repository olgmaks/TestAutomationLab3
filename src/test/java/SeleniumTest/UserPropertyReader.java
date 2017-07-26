package SeleniumTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UserPropertyReader {
    public String login;
    public String password;

    public UserPropertyReader(String fileName){
        FileInputStream fis;
        Properties property = new Properties();
        try {
            fis = new FileInputStream("src/test/resources/"+fileName+".properties");
            property.load(fis);
            this.login = property.getProperty("login");
            this.password = property.getProperty("password");
            System.out.println("In "+fileName+" login is "+login+" and password is "+password);
            fis.close();

        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }
    }

}
