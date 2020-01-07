package utilities;

import java.util.Date;

import org.apache.logging.log4j.Logger;



public class TestLogs {
	
	
	public static Logger log = org.apache.logging.log4j.core.Logger(TestLogs.class.getName());

	public static void main(String[] args) {
		
		Date d = new Date();
		
		System.out.println(d.toString().replace(":", "_").replace(" ", "_"));
		System.setProperty("current.date", d.toString().replace(":", "_").replace(" ", "_"));
		PropertyConfigurator.configure("./src/test/resources/properties/log4j.properties");
		
		log.info("This is the information log");
		
		log.error("Here the error logs will be printed");

	}

}
