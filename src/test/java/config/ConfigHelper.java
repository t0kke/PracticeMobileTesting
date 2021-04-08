package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigHelper {
	public static String getBrowserstackUser() {
		return getRemoteConfig().browserstackUser();
	}

	public static String getBrowserstackKey() {
		return getRemoteConfig().browserstackKey();
	}

	public static String getBrowserstackAppUrl(){
		return getRemoteConfig().browserstackAppUrl();
	}

	private static RemoteConfig getRemoteConfig() {
		return ConfigFactory.newInstance().create(RemoteConfig.class, System.getProperties());
	}

}
