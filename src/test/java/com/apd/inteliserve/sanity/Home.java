package com.apd.inteliserve.sanity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.apd.inteliserve.general.BaseTest;
import com.relevantcodes.extentreports.LogStatus;

public class Home extends BaseTest{

	@Test
	public void homePageTesting() throws InterruptedException {
		extentTest = extent.startTest(Home.class.getName());
		extentTest.log(LogStatus.INFO, "Test Started");
		extentTest.log(LogStatus.INFO, "Performing Operations");
		driver.findElement(By.xpath("//android.widget.TextView[@text='Home']")).click();
		Thread.sleep(3000);
		WebElement textBox=driver.findElement(By.className("android.widget.EditText"));
		textBox.sendKeys("Tell me about Unisys ");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//android.widget.Button[@text='Send message']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='No']")).click();
	}
}