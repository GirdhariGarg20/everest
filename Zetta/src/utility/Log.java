package utility;

import org.apache.log4j.Logger;

public class Log {
	
	public static Logger Log= Logger.getLogger(Log.class.getName());
	
	public static void startTestCase(String sTestCaseName){
		
		Log.info("*******************************************************************************");
		Log.info("*************************** "+ sTestCaseName +" *******************************");
		Log.info("*******************************************************************************");
		Log.info("*******************************************************************************");
		
	}
	
	public static void endTestCase(){
		Log.info("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		Log.info("XXXXXXXXXXXXXXXXXXXXXX   "+ "End Test Case" +"      XXXXXXXXXXXXXXXXXXXXXXXXXXX");
		Log.info("X");
		Log.info("X");
		Log.info("X");
		Log.info("X");
	}
	
	public static void info(String message){
		Log.info(message);
		
	}
	public static void warn(String message){
		Log.warn(message);
	}
	
	public static void error(String message){
		Log.error(message);
	}
	public static void fatel(String message){
		Log.fatal(message);
	}
}
