package generics;

import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;


public class Calculator extends BaseClass {
	@Test
	public  void  opencalculator() throws MalformedURLException{
		extentTest = extent.startTest(Calculator.class.getName());
		extentTest.log(LogStatus.INFO, "Test Started");
		extentTest.log(LogStatus.INFO, "Performing Operations");
		WebElement two=driver.findElement(By.id("com.android.calculator2:id/digit_2"));
		two.click();
		WebElement plus=driver.findElement(By.id("com.android.calculator2:id/op_add"));
		plus.click();
		WebElement four=driver.findElement(By.id("com.android.calculator2:id/digit_4"));
		four.click();
		WebElement equalTo=driver.findElement(By.id("com.android.calculator2:id/eq"));
		equalTo.click();
		extentTest.log(LogStatus.INFO, "Operations Performed Susccessfully");
		WebElement results=driver.findElement(By.className("android.widget.EditText"));
		extentTest.log(LogStatus.INFO, "Fetching Result");
		String actRes= results.getText();
		System.out.println("Result is " +actRes);
		String expRes="7";
		extentTest.log(LogStatus.INFO, "Matching Result");
		SoftAssert s= new SoftAssert();
		s.assertEquals(actRes, expRes);
		extentTest.log(LogStatus.FAIL, "Result is correct");
		s.assertAll();
	}
}

