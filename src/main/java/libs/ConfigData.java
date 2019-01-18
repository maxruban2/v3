package libs;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigData {
    private static String cfgFile="src/main/resources/config.properties";
    /*
     *  Return value from .properties file
     */
    private static String getValueFromFile(String key, String fileName)  {
        Properties p = new Properties();
        // Create stream for reading from file
        try {
            FileInputStream cfg = new FileInputStream(fileName);
            // Load Properties from input stream
            p.load(cfg);
            cfg.close();
        }catch(IOException e){

        }

        // Return value for the property
        return(p.getProperty(key));
    }

    /*
     *  Return value from config file.
     *  Note, please, that returned value is String.
     *  We should take care of value's type by himself when will use config data value in the test.
     */
    public static String getCfgValue(String key) {

        return(getValueFromFile(key, cfgFile));
    }



}
