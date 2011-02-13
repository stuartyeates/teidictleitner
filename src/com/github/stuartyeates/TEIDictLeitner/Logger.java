package com.github.stuartyeates.TEIDictLeitner;

import android.os.Environment;
import java.io.File;

public class Logger {
	
	static final String packagename = "com.github.stuartyeates.TEIDictLeitner";
	
	 File path = null;
	 File log = null;
	 
	 public Logger(){
		 try {
		 path = Environment.getExternalStorageDirectory();
		 System.err.println(" clicked 3 " + path.getCanonicalPath());
		 
		 } catch (Throwable t){
			 
		 }
	 }
	
	

}
