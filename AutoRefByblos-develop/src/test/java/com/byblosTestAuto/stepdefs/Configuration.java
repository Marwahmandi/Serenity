package com.byblosTestAuto.stepdefs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;
import org.apache.log4j.Logger;

public class Configuration {
	
	private static final Logger LOGGER = Logger.getLogger(Configuration.class);
	private static Configuration instance = null;
	private static Properties Prop = null;
	private static String conf = null;
	
	private static void loadConfigFile() {

		boolean needToExit = true;
		FileInputStream fis = null;
		File confFile = new File("conf/config.properties");
		if (confFile.exists()) {
			try {				   		
				fis = new FileInputStream(confFile);
				Prop = new Properties();
				Prop.load(fis);								
			}
			catch(Exception e) { 			  			
				LOGGER.error("Exception occured while loading config file => " + confFile, e);
			}
			finally {
				if(fis != null) {
					try { 
						fis.close();
						needToExit = false;
					} 
					catch (Exception e) {
						LOGGER.error("Exception occured while closing config file => " + confFile, e);
					}
				}
			}   
		}
		else {
			LOGGER.error("config file => " + confFile + " doesn't exist");
		}

		if (needToExit) {
			System.exit(1);
		}
	}

	public String getProperty(String key) {
		return Prop.getProperty(key);
	}

	public void setProperty(String key, String value) {
		if (Prop.containsKey(key)) {
			Prop.setProperty(key, value);
			save();
		}
	}

	public void removeProperty(String key) {
		if (Prop.containsKey(key)) {
			Prop.remove(key);
			save();
		}
	}

	public void addProperty(String key, String value) {
		if (Prop.containsKey(key)) {
			Prop.setProperty(key, value);
		}
		else {
			Prop.put(key, value);
		}
		save();
	}

	public void save() {
		try {
			File f = new File(conf);
			OutputStream out = new FileOutputStream( f );
			Prop.store(out, "configuration file");
		}
		catch (Exception e ) {
			e.printStackTrace();
		}
	}

	public static Configuration getInstance() {
		if(instance == null) {
			instance = new Configuration();
		}
		loadConfigFile();
		return instance;
	}
}
