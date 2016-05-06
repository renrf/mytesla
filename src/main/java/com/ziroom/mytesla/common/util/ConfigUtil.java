package com.ziroom.mytesla.common.util;

import com.ziroom.platform.tesla.config.ApplicationConfiguration;
import com.ziroom.platform.tesla.config.TeslaConfigurationFactory;

public class ConfigUtil {
	private static ApplicationConfiguration configuration = null;
	
	private static ApplicationConfiguration getConfiguration(){
		if(configuration == null){
			configuration = TeslaConfigurationFactory.getInstance();
		}
		return configuration;
	}
	
	public static String getString(String key){
		return getString(key, null);
	}
	public static String getString(String key, String defaultValue){
		return getConfiguration().getString(key, null);
	}
	public static int getInt(String key){
		return getInt(key, 0);
	}
	public static int getInt(String key, int defaultValue){
		return getConfiguration().getInt(key, defaultValue);
	}
	public static long getLong(String key){
		return getLong(key, 0L);
	}
	public static long getLong(String key, long defaultValue){
		return getConfiguration().getLong(key, 0L);
	}
	public static boolean getBoolean(String key){
		return getBoolean(key, false);
	}
	public static boolean getBoolean(String key, boolean defaultValue){
		return getConfiguration().getBoolean(key, defaultValue);
	}
}
