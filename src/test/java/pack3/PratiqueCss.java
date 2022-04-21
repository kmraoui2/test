package pack3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PratiqueCss {

	@Test 
	public void loginTest() throws Exception{
		  WebDriverManager.chromedriver().setup();
		  WebDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get("https://the-internet.herokuapp.com/login");
		  driver.findElement(By.cssSelector("#username")).sendKeys("tomsmith");
		  driver.findElement(By.cssSelector("#password")).sendKeys("SuperSecretPassword!");
		  Thread.sleep(5000);
		  driver.findElement(By.cssSelector("[type=submit]")).click();
		  Thread.sleep(5000);
		  driver.findElement(By.cssSelector("[href='/logout']")).click();
		  //driver.close();
	}
	
	@Test 
	public void forgotPwdTest() throws Exception{
		  WebDriverManager.chromedriver().setup();
		  WebDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get("https://the-internet.herokuapp.com/forgot_password");
		  driver.findElement(By.cssSelector("#email")).sendKeys("test@test.com");
		  Thread.sleep(3000);
		  driver.findElement(By.cssSelector("#form_submit")).click();
		  //driver.close();
	}
	@Test 
	public void getAttributeTest() throws Exception{
		  WebDriverManager.chromedriver().setup();
		  WebDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get("https://the-internet.herokuapp.com/forgot_password");
		  String attributID = driver.findElement(By.cssSelector("#form_submit")).getAttribute("id");
		  System.out.println("la valeur de l'ID est: "+attributID);
		  //driver.close();
	}	
	
	@Test 
	public void cssImageTest() throws Exception{
		  WebDriverManager.chromedriver().setup();
		  WebDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get("http://automationpractice.com/");
		  String url = driver.findElement(By.cssSelector("a[title='My Store']>img")).getAttribute("src");
		  System.out.println("l'URL est: "+url);
		  //driver.close();
	}
	@Test 
	public void cssImageTest2() throws Exception{
		  WebDriverManager.chromedriver().setup();
		  WebDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		  boolean display1 = driver.findElement(By.cssSelector("div[class='submit'] [value='my-account']")).isDisplayed();
		  System.out.println("Element affiché 1 ? : "+display1);
		  boolean display2 = driver.findElement(By.cssSelector("#SubmitCreate")).isDisplayed();
		  System.out.println("Element affiché 2 ? : "+display2);

	}
	
	@Test 
	public void actifInactifTest() throws Exception{
		  WebDriverManager.chromedriver().setup();
		  WebDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get("http://omayo.blogspot.com/");
		  boolean actif = driver.findElement(By.cssSelector("#but1")).isEnabled();
		  System.out.println("Element actif 1 ? : "+ actif);
		  boolean actif2 = driver.findElement(By.cssSelector("#but2")).isEnabled();
		  System.out.println("Element actif 2 ? : "+ actif2);
	}
	@Test 
	public void checkedTest() throws Exception{
		  WebDriverManager.chromedriver().setup();
		  WebDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get("http://omayo.blogspot.com/");
		  boolean checked = driver.findElement(By.cssSelector("[value='orange']")).isSelected();
		  Thread.sleep(3000);
		  System.out.println("Element checked 1 ? : "+ checked);
		  driver.findElement(By.cssSelector("[value='orange']")).click();
		  Thread.sleep(3000);
		  boolean checked2 = driver.findElement(By.cssSelector("[value='orange']")).isSelected();
		  System.out.println("Element checked apres click : "+ checked2);
	//	  boolean checked2 = driver.findElement(By.cssSelector("[value='blue']")).isSelected();
	//	  System.out.println("Element checked 2 ? : "+ checked2);
	}
}
