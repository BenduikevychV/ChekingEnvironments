package utilities;

import utilities.config.Config;

public class GeneralUtils {

    public static String chooseBrowser(){
       String browser = System.getProperty("browser");
        if(null==browser){
            browser = Config.getProperty("browser");
        }
        return browser;
    }

    public static String chooseEnv(){
        String env = System.getProperty("env");
        if(null==env){
            env = Config.getProperty("env").toUpperCase();
        }
        return env.toUpperCase();
    }

}
//mvn verify -Dbrowser=chromee
//mvn verify -Denv=UAT