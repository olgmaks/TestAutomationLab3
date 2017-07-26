package epam.com.lab;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



public class Constants1 {


    private static Properties prop = new Properties();
    private static InputStream input = null;

    public static String getValue(String value) {

        String result=null;
        try {

            input = new FileInputStream("src/main/resources/constant.properties");


            prop.load(input);

            result = prop.getProperty(value);
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        return result;
    }

}











