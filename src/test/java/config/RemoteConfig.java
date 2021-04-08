package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
		"system:properties",
		"classpath:remote.properties"
})
public interface RemoteConfig extends Config{
	@Key("browserstack.user")
	String browserstackUser();

	@Key("browserstack.key")
	String browserstackKey();

	@Key("browserstack.app.url")
	String browserstackAppUrl();
}
