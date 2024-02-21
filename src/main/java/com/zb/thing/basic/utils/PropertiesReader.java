package com.zb.thing.basic.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    public static Properties properties = new Properties();


    public static Properties load(String[] args){
        try{
            InputStream resource = args.length == 0 ? PropertiesReader.class.getClassLoader().getResourceAsStream("process.properties")
                    : new FileInputStream(new File(args[0]));
            properties.load(resource);
            return properties;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static String getProperties(String key){
        return properties.getProperty(key);
    }


}
