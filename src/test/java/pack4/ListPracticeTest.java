package pack4;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ListPracticeTest {
  @Test
  public void selectElement() throws Exception {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get("http://omayo.blogspot.com/");
//	  driver.findElement(By.xpath("//select[@id='multiselect1']/option[@value='audix']")).click();
	  WebElement muliselect = driver.findElement(By.id("multiselect1"));
	  Select select = new Select(muliselect);
	  select.selectByVisibleText("Audi");
	  select.selectByIndex(1);
	  select.selectByValue("Hyundaix");
	  Thread.sleep(4000);
	  select.deselectByIndex(1);
	  //driver.quit();
  }
  @Test
  public void selectElement2() throws Exception {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get("http://omayo.blogspot.com/");
	  WebElement ddlist = driver.findElement(By.id("drop1"));
	  Select select = new Select(ddlist);
	  select.selectByVisibleText("doc 2");
	  Thread.sleep(4000);
	  select.selectByIndex(0);
	  Thread.sleep(4000);
	  select.selectByValue("mno");
	  Thread.sleep(4000);
	  //driver.quit();
  }
  
  @Test
  public void accessAlertPopup() throws Exception {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get("http://omayo.blogspot.com/");
	  driver.findElement(By.id("alert1")).click();
	  Alert alerte = driver.switchTo().alert();
	  String textAlert = alerte.getText();
	  System.out.println("mon alert text: "+textAlert);
	  Thread.sleep(4000);
	  alerte.accept();
	  
	  //confirm
	  driver.findElement(By.id("confirm")).click();
	  Alert confirmation = driver.switchTo().alert();
	  String textConfirmation = confirmation.getText();
	  System.out.println("mon textConfirmation: "+textConfirmation);
	  Thread.sleep(4000);
	  confirmation.dismiss();

	  //prompt
	  driver.findElement(By.id("prompt")).click();
	  Thread.sleep(4000);
	  Alert prompt = driver.switchTo().alert();
	  Thread.sleep(4000);
	  prompt.sendKeys("toto");
	  Thread.sleep(2000);
	  prompt.accept();
  }
  @Test
  public void javascriptExecutor() throws Exception {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get("http://omayo.blogspot.com/");
	  
	  Thread.sleep(4000);
	  JavascriptExecutor jsExec = (JavascriptExecutor) driver;
	  jsExec.executeScript("window.scrollBy(0,2000)");
	  Thread.sleep(4000);
	  jsExec.executeScript("window.scrollBy(0,-2000)");

  }
  
  @Test
  public void javascriptExecutor2() throws Exception {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get("http://omayo.blogspot.com/");
	  
	  Thread.sleep(4000);
	  JavascriptExecutor jsExec = (JavascriptExecutor) driver;
	  jsExec.executeScript("alert('Salut!')");

  }
  
  @Test
  public void javascriptExecutor3() throws Exception {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get("http://omayo.blogspot.com/");
	  WebElement element = driver.findElement(By.id("pah"));
	  Thread.sleep(4000);
	  JavascriptExecutor jsExec = (JavascriptExecutor) driver;
	  jsExec.executeScript("arguments[0].setAttribute('style','background:red; border:4px dashed green;')", element);
  }
  
}
