package test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonTest extends DbConnection {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//String stsearchitem = "samsung";

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		TakesScreenshot tsObj = (TakesScreenshot) driver;

		File fileObj = tsObj.getScreenshotAs(OutputType.FILE);
		File screenshot = new File("AmazonProductImage.png");
		FileUtils.copyFile(fileObj, screenshot);

		List<WebElement> lsproducts = driver.findElements(By.xpath("//div[@class='a-section']//h2//span"));
		List<WebElement> lspricesymbol = driver.findElements(By.xpath(
				"//div[@class='a-section a-spacing-none a-spacing-top-micro s-price-instructions-style']//span[@class='a-price-symbol']"));
		List<WebElement> lsprice = driver.findElements(By.xpath(
				"//div[@class='a-section a-spacing-none a-spacing-top-micro s-price-instructions-style']//span[@class='a-price-whole']"));
		System.out.println("Printing search results of " + name);
		for (int i = 0; i < lsproducts.size(); i++) {
			String stproductname = lsproducts.get(i).getText();
			String stpricesymbol = lspricesymbol.get(i).getText();
			String stprice = lsprice.get(i).getText();
			System.out.println(+i + "-" + stproductname + " " + "Price: " + stpricesymbol + stprice);
		}


		driver.close();

	}

}
