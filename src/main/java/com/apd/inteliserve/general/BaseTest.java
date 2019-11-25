package com.apd.inteliserve.general;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class BaseTest extends Lib {
	public static ExtentReports extent;
	public static ExtentTest extentTest;

	@BeforeTest
	public void setEnvironmet() throws MalformedURLException, InterruptedException {
		extent=generateExtentReport();
	}

	@BeforeMethod
	public void startApplication() throws InterruptedException, MalformedURLException {
		setAppium();
		Thread.sleep(3000);
		WebElement accept=driver.findElement(By.xpath("//android.widget.TextView[@text='ACCEPT']"));
		accept.click();
		Thread.sleep(3000);
		WebElement email=driver.findElement(By.xpath("//android.widget.EditText[@text='Email Address']"));
		email.sendKeys("madhurvishal5@gmail.com");
		Thread.sleep(3000);
		WebElement signIn=driver.findElement(By.xpath("//android.widget.TextView[@text='Sign in']"));
		Thread.sleep(3000);
		signIn.click();
		Thread.sleep(10000);
		WebElement chooseAccount=driver.findElement(By.xpath("//android.widget.TextView[@text='madhurvishal5@gmail.com']"));
		Thread.sleep(3000);
		chooseAccount.click();
		Thread.sleep(10000);
		WebElement hemburgur=driver.findElement(By.className("android.widget.TextView"));
		Thread.sleep(3000);
		hemburgur.click();
		Thread.sleep(5000);
	}

	@AfterMethod
	public void closeApplication(ITestResult result) throws IOException, InterruptedException
	{
		if(result.getStatus()==ITestResult.FAILURE){
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getName()); 
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getThrowable()); 
			String screenshotPath = Lib.captureScreenshots(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); 
		}
		else if(result.getStatus()==ITestResult.SKIP){
			extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS){
			extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());
		}
		extent.endTest(extentTest);
		Thread.sleep(5000);
		driver.quit();
	}

	@AfterTest
	public void endReport(){
		
		extent.flush();
		extent.close();
	}
}