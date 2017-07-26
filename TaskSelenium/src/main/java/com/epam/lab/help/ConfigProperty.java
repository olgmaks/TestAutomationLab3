package com.epam.lab.help;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperty {
    Properties property  = new Properties();

    public String getPropertyValue(String key){
        try{
            FileReader reader = new FileReader("src/main/resources/config.properties");
            property.load(reader);

        }
        catch(FileNotFoundException ex){
            ex.printStackTrace();
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return  property.getProperty(key);
    }
}
