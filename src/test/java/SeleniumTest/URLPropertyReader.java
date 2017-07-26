package SeleniumTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class URLPropertyReader {
    public String URL;
    public URLPropertyReader(String fileName){
        FileInputStream fis;
        Properties property = new Properties();
        try {
            fis = new FileInputStream("src/test/resources/"+fileName+".properties");
            property.load(fis);
            this.URL = property.getProperty("URL");

            System.out.println("In "+fileName+" url is "+URL);

        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }
    }

}
