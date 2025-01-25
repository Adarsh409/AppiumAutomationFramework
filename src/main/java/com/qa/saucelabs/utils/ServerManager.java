package com.qa.saucelabs.utils;

import java.io.File;
import java.time.Duration;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class ServerManager {
	private static ThreadLocal<AppiumDriverLocalService> server = new ThreadLocal<AppiumDriverLocalService>();
	
	public static void startServer() {
		AppiumDriverLocalService server = getWindowsAppiumService();
		if(!server.isRunning()) {
			server.start();
		}
		
		ServerManager.server.set(server);
	
		
	}
	
	public static AppiumDriverLocalService getServer() {
		return server.get();
	}
	
	public static AppiumDriverLocalService getWindowsAppiumService() {
		
		return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
				//.usingAnyFreePort()
				.usingPort(4723)
				.withTimeout(Duration.ofSeconds(30))
				.withArgument(GeneralServerFlag.SESSION_OVERRIDE));
//				.withLogFile(new File(TestParams.getPlatformName()+File.separator+"Server.log")));
	}

}
