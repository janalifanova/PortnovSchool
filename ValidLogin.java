package com.example.tests;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

//import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class ValidLogin {

	public static void main(String[] args) throws Exception {{
		
		Scanner input = new Scanner(System.in);
	    System.out.println("Please enter your name : "); 
	    String userName = input.next();
	    System.out.println("Please enter your pwd : ");
	    String password = input.next();
		
	    //Open Firefox
		WebDriver wd = new FirefoxDriver();
       //Go to Bluescape.com 
        wd.get("https://bluescape.com/");
       
        wd.findElement(By.xpath(".//*[@id='nav-menu-item-228']/a/span[1]")).click();
       //wd.findElement(By.partialLinkText("Welcome")).click();
        Thread.sleep(2000);
	    assertEquals("https://portal.bluescape.com/users/sign_in", wd.getCurrentUrl());
	    
	    
		wd.findElement(By.id("user_email")).sendKeys(userName);
		wd.findElement(By.id("user_password")).sendKeys(password);
		wd.findElement(By.name("commit")).click();
		Thread.sleep(2000);
		assertEquals("Yana Lifanova", wd.findElement(By.linkText("Yana Lifanova")).getText());
		//assertEquals("Workspaces", wd.findElement(By.xpath("html/body/div[1]/div[1]/div[1]/div[1]/div[1]/h2")).getText());
		input.close();
		wd.close();
		
	}

}
}