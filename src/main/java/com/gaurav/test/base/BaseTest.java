package com.gaurav.test.base;

import com.gaurav.test.config.ConfigKeys;
import com.gaurav.test.config.ConfigManager;
import com.gaurav.test.helper.Constants;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected ConfigManager configManager;

    @BeforeClass
    public void setUp(){
        configManager = ConfigManager.getInstance();
    }

    public String getBaseURI(){
        return configManager.getProperties(ConfigKeys.BASE_URI);
    }
}
