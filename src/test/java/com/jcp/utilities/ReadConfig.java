package com.jcp.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig() {

		File src = new File("./Configuration/application.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getBaseURL() {
		String url = pro.getProperty("baseURL");

		return url;
	}
	
	public String getEmail() {
		String email = pro.getProperty("username");

		return email;
	}
	
	public String getPassword() {
		String pwd = pro.getProperty("password");

		return pwd;
	}
	
	public String getChromeDriverPath() {
		String chromePath = pro.getProperty("chromepath");

		return chromePath;
	}
	
	public String getFFDriver() {
		String gecko = pro.getProperty("geckopath");

		return gecko;
	}

	public String getIEDriver() {
		String ie = pro.getProperty("IEPath");

		return ie;
	}
	
}
