package com.gaurav.test.config;

import com.gaurav.test.helper.Constants;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {

    private static ConfigManager configManager;
    private Properties properties;

    public static ConfigManager getInstance(){
        if(configManager == null){
            configManager = new ConfigManager();
        }
        return configManager;
    }

    public void loadProperties(){
        try {
            properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(Constants.CONFIG_FILE_PATH);
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getProperties(String key){
        loadProperties();
        try {
            return properties.getProperty(key);
        } catch (RuntimeException e){
            throw new RuntimeException("Could not find the property"+e);
        }
    }

    public String getProperties(ConfigKeys configKeys) {
        loadProperties();
        try {
            return properties.getProperty(String.valueOf(configKeys));
        } catch (RuntimeException e){
            throw new RuntimeException("Could not find the property"+e);
        }
    }
}
