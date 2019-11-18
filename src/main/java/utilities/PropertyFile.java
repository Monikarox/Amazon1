package utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;


public class PropertyFile {
	static Logger logger = Logger.getLogger(PropertyFile.class);
	public static String getProperty(String key) throws FileNotFoundException
	{
		try{
			FileReader input=new FileReader("C:\\Users\\Monika_Sahu\\eclipse-workspace\\amazon\\src\\main\\resources\\config.properties");
            Properties prop = new Properties();
            prop.load(input);
            return prop.getProperty(key);
        } catch (IOException ex) {
           logger.info("PEOPERTY FILE EXCEPTION: "+ex.getMessage());
        }
		return "";
	}
	
}
