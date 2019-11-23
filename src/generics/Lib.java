package generics;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.relevantcodes.extentreports.ExtentReports;
import io.appium.java_client.AppiumDriver;

public class Lib {
	
public  AppiumDriver<WebElement> driver;
	
	public void setAppium() throws MalformedURLException {
	DesiredCapabilities capabilities = new DesiredCapabilities();
	capabilities.setCapability("deviceName","Honor 7X");
	capabilities.setCapability("udid", "NSM3Y18413029399");
	capabilities.setCapability("platformName","Android");
	capabilities.setCapability("platformVersion", "9"); 
//	capabilities.setCapability("appPackage", "com.android.calculator2");
//	capabilities.setCapability("appActivity","com.android.calculator2.Calculator");
	capabilities.setCapability("appPackage", "com.serviont.inteliapp");
	capabilities.setCapability("appActivity","com.serviont.inteliapp.MainActivity");
	driver = new AppiumDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}
	
	public static ExtentReports generateExtentReport() {
		ExtentReports extent =null;
		try {
			Date d = new Date();
			String currentDate = d.toString().replaceAll(":","_");
			extent=new ExtentReports(System.getProperty("user.dir")+"/ExtentReports/"+"InteliServe Test Automation Report" +"_"+ currentDate + ".html", true);
			extent.loadConfig(new File(System.getProperty("user.dir")+"/testdata/ReportsConfig.xml")); 
			extent.addSystemInfo("Appium Version", "1.15.1").addSystemInfo("Platform", "Android").addSystemInfo("Android Version", "9-Pie").addSystemInfo("User Name", "Vishal Madhur");
		}catch(Exception e) {
		}
		return extent;
	}

	public static String captureScreenshots(WebDriver driver,String testCaseName){
		Date d = new Date();
		String currentDate = d.toString().replaceAll(":","_");
		String screenShotPath = System.getProperty("user.dir") + "/screenshots/" +testCaseName+"_"+currentDate+".png";
		try{
			TakesScreenshot ts = (TakesScreenshot)driver;
			File srcFile=ts.getScreenshotAs(OutputType.FILE);
			File destFile = new File(screenShotPath);
			FileUtils.copyFile(srcFile, destFile);
		}catch(Exception e){
		}
		return screenShotPath;
	}
}

