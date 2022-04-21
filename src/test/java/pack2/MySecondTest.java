package pack2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MySecondTest {
  @Test
  public void navigateURL() throws Exception {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver = new ChromeDriver();
	  driver.get("https://login.salesforce.com/");
	  driver.findElement(By.className("username")).sendKeys("test");
	  driver.findElement(By.className("password")).sendKeys("test");
	  driver.findElement(By.id("Login")).click();
	 // System.out.println("Text erreur: " + driver.findElement(By.id("error")).getText());
	  WebElement textError = driver.findElement(By.id("error"));
	  String erreur = textError.getText();
	  System.out.println("Message d'erreur est: " + erreur);
	  Thread.sleep(3000);
	  driver.close();
  }
  @Test
  public void forgotPassword() throws Exception {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver = new ChromeDriver();
	  driver.get("https://login.salesforce.com/");
	  driver.findElement(By.className("username")).sendKeys("test");
	  driver.findElement(By.className("password")).sendKeys("test");
	  driver.findElement(By.linkText("Forgot Your Password?")).click();
	  String monUrl = driver.getCurrentUrl();
	  System.out.println("L'URL est : "+ monUrl);
	  String titre = driver.getTitle();
	  System.out.println("Le titre de ma page est : "+titre);
	  Thread.sleep(3000);
	  driver.close();
  }
  
  @Test
  public void commeJeVeux() throws Exception {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver = new ChromeDriver();
	  driver.get("https://login.salesforce.com/");
	  driver.findElement(By.className("username")).sendKeys("pré-test");
	  Thread.sleep(4000);
	  driver.findElement(By.className("username")).clear();
	  Thread.sleep(4000);
	  driver.findElement(By.className("username")).sendKeys("test");
	  driver.findElement(By.className("password")).sendKeys("test");
	  driver.findElement(By.linkText("Forgot Your Password?")).click();
	  String monUrl = driver.getCurrentUrl();
	  System.out.println("L'URL est : "+ monUrl);
	  String titre = driver.getTitle();
	  System.out.println("Le titre de ma page est : "+titre);
	  Thread.sleep(3000);
	  String monHtmlCodeSource = driver.getPageSource();
	  System.out.println(monHtmlCodeSource);
	  driver.close();
  }
  
  @Test
  public void driverQuit() throws Exception {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver = new ChromeDriver();
	  driver.get("http://omayo.blogspot.com/");
	  driver.findElement(By.partialLinkText("Open a popup")).click();
	  Thread.sleep(3000);
	  driver.quit();
  }
}
