package utilities.config;

import utilities.GeneralUtils;

import javax.swing.text.Utilities;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigEnv {

    private static Properties properties;

    private static void readFile() {
        String path = "src/test/resources/config/" + GeneralUtils.chooseEnv() + ".properties";
        FileInputStream input = null;
        try {
            input = new FileInputStream(path);
            properties = new Properties();
            properties.load(input);
        } catch (IOException e) {
            e.getStackTrace();
        } finally {
            try {
                input.close();

            } catch (IOException e) {
                e.getStackTrace();
            }
        }
    }

    public static String getProperty(String key) {
        readFile();
        return properties.getProperty(key);
    }

}
