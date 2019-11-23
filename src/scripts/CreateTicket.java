package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import generics.BaseClass;

public class CreateTicket extends BaseClass {
	
	@Test
	public void createTicket() throws InterruptedException {
	extentTest = extent.startTest(CreateTicket.class.getName());
	extentTest.log(LogStatus.INFO, "Test Started");
	extentTest.log(LogStatus.INFO, "Performing Operations");
	driver.findElement(By.xpath("//android.widget.TextView[@text='Create Ticket']")).click();
	Thread.sleep(5000);
	WebElement title=driver.findElement(By.xpath("//android.widget.EditText[@text='Give an appropriate topic title to your ticket']"));
	title.sendKeys("Appium Tool");
	Thread.sleep(3000);
	WebElement description=driver.findElement(By.xpath("//android.widget.EditText[@text='Write about the topic you have a question about.']"));
	description.sendKeys("Appium Tool is used for Mobile Automation Testing");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//android.widget.TextView[@text='CREATE TICKET']")).click();
	Thread.sleep(5000);
	extentTest.log(LogStatus.PASS, "Test Successfull");
	}
}
