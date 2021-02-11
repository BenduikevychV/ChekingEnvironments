package utilities.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config {

    private static Properties properties;
    private static String path = "src/test/resources/config/default.properties";

    private static void readFile() {
        FileInputStream input = null;
        try {
            input = new FileInputStream(path);
            properties = new Properties();
            properties.load(input);
        }catch (IOException e){
            e.getStackTrace();
        }finally {
            try {
            input.close();
            }catch (IOException e){
                e.getStackTrace();
            }
        }
    }

    public static String getProperty(String key){
        readFile();
        return properties.getProperty(key);
    }
}
