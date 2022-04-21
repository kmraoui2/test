package pack3;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PratiqueWebDriver {

	@Test
	public void takeScreenshot() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://omayo.blogspot.com/");
		File screen = driver.findElement(By.cssSelector("[value='orange']")).getScreenshotAs(OutputType.FILE);
		File toFile = new File("screenshot\\image1.png");
		FileHandler.copy(screen, toFile);
		// other option: FileUtils.copyFile(screen, new File("screenshot\\\\image1.png"));

	}
	
	@Test
	public void takeScreenshot2() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://omayo.blogspot.com/");
		File screen = driver.findElement(By.cssSelector(".widget-content>img")).getScreenshotAs(OutputType.FILE);
		File toFile = new File("screenshot\\image2.png");
		FileHandler.copy(screen, toFile);
	}
	
	@Test
	public void takeFullScreenshot() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/");
		File screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File toFile = new File("screenshot\\image3.png");
		FileHandler.copy(screen, toFile);
	}
	
	@Test
	public void screenshotAndReport() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		Reporter.log("Ouverture de la login page");
		driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
		driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
		Reporter.log("remplir le formulaire de login.");
		driver.findElement(By.cssSelector("#login-button")).click();
		Thread.sleep(3000);
		Reporter.log("affichage du homepage");
		driver.findElement(By.cssSelector("#react-burger-menu-btn")).click();
		// a faire ... cliquer sur le menu et puis se deloguer ...
		File screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File toFile = new File("screenshot\\image4.png");
		FileHandler.copy(screen, toFile);
		Reporter.log("fermeture du navigateur.");
		Reporter.log("<a target=\"_blank\" href=\"C:\\Automatisation\\selenium_maven\\screenshot\\image4.png\">screenshot</a>");
		driver.quit();
	}
	
	@Test
	public void navigateMethod() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		Thread.sleep(4000);
		driver.navigate().to("https://www.google.com");
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(3000);
		driver.navigate().forward();
		Thread.sleep(3000);
		driver.quit();
	}
	@Test
	public void findMultipleElementsMethod() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		List<WebElement> maListe = driver.findElements(By.cssSelector("input"));
		//System.out.println("maListe ="+maListe);
		for(WebElement element: maListe) {
			String monAttribut = element.getAttribute("name");
			System.out.println("Attribut="+monAttribut);
		}
		driver.quit();
	}
	
	@Test
	public void findMultipleElementsMethod2() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
		driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
		driver.findElement(By.cssSelector("#login-button")).click();
		List<WebElement> myElements = driver.findElements(By.cssSelector("a"));
		for(WebElement element: myElements) {
			String href = element.getAttribute("href");
			System.out.println("href ="+ href);
			String linkText = element.getText();
			System.out.println("linkText ="+ linkText);
		}
		driver.quit();
	}
	@Test
	public void getDifferentValues() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		WebElement element = driver.findElement(By.cssSelector("#login-button"));
		String color = element.getCssValue("background-color");
		System.out.println("ma couleur = "+color);
		driver.quit();
	}
	@Test
	public void getNavigatorClass() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		String nomDriver= driver.getClass().getSimpleName();
		System.out.println("nom driver : "+ nomDriver);
		driver.quit();
	}
	
	
}
