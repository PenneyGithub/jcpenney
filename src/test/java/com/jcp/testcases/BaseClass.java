package com.jcp.testcases;



import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.jcp.utilities.ReadConfig;

public class BaseClass extends ReadConfig{
	

			public static WebDriver driver;
			public static Logger logger;
			
			@SuppressWarnings("deprecation")
			@Parameters("browser")
			@BeforeClass
			public void setUP(String browser) {
				
				if(browser.toLowerCase().equals("chrome")) {
				
				System.setProperty("webdriver.chrome.driver",getChromeDriverPath());
				driver = new ChromeDriver();
				}

				else if (browser.toLowerCase().equals("firefox")) {

					System.setProperty("webdriver.gecko.driver", getFFDriver());
					driver = new FirefoxDriver();
				}

				else if (browser.toLowerCase().equals("ie")) {

					System.setProperty("webdriver.ie.driver", getIEDriver());
					DesiredCapabilities capabilities = DesiredCapabilities.edge();
					driver = new EdgeDriver(capabilities);
					
				}
				
			logger= Logger.getLogger("JCPENNEY");
			PropertyConfigurator.configure("Log4j.properties");
			
			}
			
			@AfterClass
			
			public void tearDown()
			{
				
				driver.quit();
			}
			
	public void capturescreen(WebDriver driver,String tname) throws IOException {
		TakesScreenshot screen = (TakesScreenshot)driver;
		File source = screen.getScreenshotAs(OutputType.FILE);
		File target= new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
}

}
