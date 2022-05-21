import java.util.*;

public class CheckSystem{
    public static void main(String[] args){
        System.out.println("running CheckSystem ...");

        Properties properties = System.getProperties();
        System.out.println("system properties : " + properties);
        Set<String>propertiesNames = properties.stringPropertyNames();
        
        for (String key : propertiesNames){
        	String value = System.getProperty(key);
        	System.out.println(key + " ----> " + value);
        }
    }
}