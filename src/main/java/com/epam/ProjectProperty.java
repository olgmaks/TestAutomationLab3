package com.epam;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ProjectProperty {

    private InputStream inputStream;
    private Properties property;
    private String propertyFile = "data.properties";

    public ProjectProperty() throws IOException {
        inputStream=getClass().getClassLoader().getResourceAsStream(propertyFile);
        if(inputStream!=null) {
            property =new Properties();
            property.load(inputStream);
        }else
            throw new FileNotFoundException("property file " + propertyFile + " not found in the classpath");
    }

    public String getUserOneLogin(){
        return property.getProperty("userOneLogin");
    }
    public String getUserTwoLogin(){
        return property.getProperty("userTwoLogin");
    }
    public String getUserOnePassword(){
        return property.getProperty("userOnePassword");
    }
    public String getUserTwoPassword(){
        return property.getProperty("userTwoPassword");
    }
}
