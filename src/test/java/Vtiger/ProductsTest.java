package Vtiger;

import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProductsTest {

	public static void main(String[] args) throws Throwable 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		
		Random ran=new Random();
		int random = ran.nextInt(100);
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[.='Products']")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		String s1="vivo";
		driver.findElement(By.name("productname")).sendKeys(s1+random);
		driver.findElement(By.name("sales_start_date")).sendKeys("2022-04-30");
		WebElement drop1 = driver.findElement(By.name("productcategory"));
		Select sel1=new Select(drop1);
		sel1.selectByValue("Software");
		driver.findElement(By.name("sales_end_date")).sendKeys("2022-05-30");
		WebElement drop2 = driver.findElement(By.name("glacct"));
		Select sc=new Select(drop2);
		sc.selectByValue("302-Rental-Income");
		driver.findElement(By.xpath("//a[.='more currencies »']")).click();
		driver.findElement(By.id("curname1")).sendKeys("255");
		driver.findElement(By.xpath("//img[@src='themes/images/close.gif' and @style='cursor: pointer;']")).click();
		driver.findElement(By.name("tax1_check")).click();
		driver.findElement(By.name("tax2_check")).click();
		driver.findElement(By.name("tax3_check")).click();
		WebElement ele = driver.findElement(By.xpath("//input[@type='file']"));
		ele.sendKeys("C:\\Users\\SanjayBabu\\Downloads\\nikhil-mishra-shri-krishna-5-1a-wm.jpg");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String ele4 = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		if(ele4.contains(s1))
		{
			System.out.println("product is created");
		}else {
			System.out.println("product is not created");
		}
		WebElement ele1 = driver.findElement(By.xpath("//a[.='More']"));
		Actions act=new Actions(driver);
		act.moveToElement(ele1).perform();
		driver.findElement(By.xpath("//a[.='Campaigns']")).click();
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		String s="Tara";
		driver.findElement(By.name("campaignname")).sendKeys(s);
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		Set<String> set = driver.getWindowHandles();
		for (String title: set) 
		{
			driver.switchTo().window(title);
			String tle = driver.getTitle();
			if(tle.contains("Products&action"))
			{
				break;
			}
		}
		driver.findElement(By.id("search_txt")).sendKeys("vivo36");
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[contains(text(),'vivo36')]")).click();
		Set<String> set1 = driver.getWindowHandles();
		for (String title1 : set1) 
		{
			driver.switchTo().window(title1);
			String tel = driver.getTitle();
			if(tel.contains("Campaigns&action"))
			{
				break;
			}
		}
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String ele2 = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(ele2.contains(s))
		{
			System.out.println("test case success");
		}else {
			System.out.println("fail");
		}
		WebElement ele3 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act1=new Actions(driver);
		act1.moveToElement(ele3).perform();
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		driver.quit();
	}
	}