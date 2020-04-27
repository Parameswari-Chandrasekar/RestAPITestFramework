package com.employeeapi.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class Utilities {

    public static Properties gProp=null;
    public static int gConfigCount = 0;

   public static String readConfig(String keyValue)
    {
        try {
            if(gConfigCount==0) {
                gProp = new Properties();
                gProp.load(new FileInputStream(System.getProperty("user.dir")+"\\config.properties"));
                gConfigCount++;
            }
          return gProp.get(keyValue).toString();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }

    }
}
