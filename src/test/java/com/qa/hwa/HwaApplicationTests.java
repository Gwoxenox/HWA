package com.qa.hwa;

import org.springframework.boot.test.context.SpringBootTest;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

@SpringBootTest
class HwaApplicationTests {

	private WebDriver driver;
	  private Map<String, Object> vars;
	  JavascriptExecutor js;
	  @Before
	  public void setUp() {
	    driver = new ChromeDriver();
	    js = (JavascriptExecutor) driver;
	    vars = new HashMap<String, Object>();
	  }
	  @Test
	  public void addaseries() {
	    driver.get("http://localhost:8080/");
	    driver.manage().window().setSize(new Dimension(974, 1040));
	    driver.findElement(By.id("name")).click();
	    driver.findElement(By.id("name")).sendKeys("F1");
	    driver.findElement(By.id("car")).click();
	    driver.findElement(By.id("car")).sendKeys("Ferrari");
	    driver.findElement(By.cssSelector("#newSeries > fieldset > input")).click();
	    driver.findElement(By.cssSelector("html")).click();
	    driver.findElement(By.cssSelector(".card-body")).click();
	    assertThat(driver.findElement(By.cssSelector(".card-text:nth-child(1)")).getText(), is("Id: 1"));
	  }
	  @Test
	  public void addarace() {
	    driver.get("http://localhost:8080/");
	    driver.manage().window().setSize(new Dimension(974, 1040));
	    driver.findElement(By.id("seriesId")).click();
	    driver.findElement(By.id("seriesId")).sendKeys("1");
	    driver.findElement(By.id("raceNo")).click();
	    driver.findElement(By.id("raceNo")).sendKeys("1");
	    driver.findElement(By.id("circuit")).click();
	    driver.findElement(By.id("circuit")).sendKeys("Monza");
	    driver.findElement(By.id("noOfLaps")).click();
	    driver.findElement(By.id("noOfLaps")).sendKeys("50");
	    driver.findElement(By.cssSelector("#newRace > fieldset > input")).click();
	    driver.findElement(By.cssSelector("#raceCards .card-body")).click();
	    driver.findElement(By.cssSelector("#raceCards .card-body")).click();
	    assertThat(driver.findElement(By.cssSelector("#raceCards .card-text:nth-child(1)")).getText(), is("Series: 1"));
	  }
	  @Test
	  public void addaracewrongseries() {
	    driver.get("http://localhost:8080/");
	    driver.manage().window().setSize(new Dimension(974, 1040));
	    driver.findElement(By.id("seriesId")).click();
	    driver.findElement(By.id("seriesId")).sendKeys("98");
	    driver.findElement(By.id("raceNo")).click();
	    driver.findElement(By.id("raceNo")).sendKeys("2");
	    driver.findElement(By.id("circuit")).click();
	    driver.findElement(By.id("circuit")).sendKeys("Rainbow Road");
	    driver.findElement(By.id("noOfLaps")).click();
	    driver.findElement(By.id("noOfLaps")).sendKeys("700");
	    driver.findElement(By.cssSelector("#newRace > fieldset")).click();
	    driver.findElement(By.cssSelector("#newRace > fieldset > input")).click();
	    driver.findElement(By.cssSelector("#newRace li:nth-child(1)")).click();
	    driver.findElement(By.id("seriesId")).sendKeys("1");
	    {
	      WebElement element = driver.findElement(By.cssSelector("#newRace li:nth-child(2) > label"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element).clickAndHold().perform();
	    }
	    {
	      WebElement element = driver.findElement(By.cssSelector("#newRace li:nth-child(2) > label"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element).perform();
	    }
	    {
	      WebElement element = driver.findElement(By.cssSelector("#newRace li:nth-child(2) > label"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element).release().perform();
	    }
	    driver.findElement(By.cssSelector("#newRace li:nth-child(2)")).click();
	    driver.findElement(By.id("raceNo")).sendKeys("3");
	    driver.findElement(By.id("circuit")).click();
	    driver.findElement(By.cssSelector("#newRace ul")).click();
	    driver.findElement(By.id("circuit")).sendKeys("Yoshi Circuit");
	    {
	      WebElement element = driver.findElement(By.cssSelector("li:nth-child(4) > label"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element).clickAndHold().perform();
	    }
	    {
	      WebElement element = driver.findElement(By.cssSelector("li:nth-child(4) > label"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element).perform();
	    }
	    {
	      WebElement element = driver.findElement(By.cssSelector("li:nth-child(4) > label"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element).release().perform();
	    }
	    driver.findElement(By.cssSelector("li:nth-child(4)")).click();
	    driver.findElement(By.id("noOfLaps")).sendKeys("22");
	    driver.findElement(By.cssSelector("#newRace > fieldset > input")).click();
	    driver.findElement(By.cssSelector(".col:nth-child(2) .card-body")).click();
	    driver.findElement(By.cssSelector(".col:nth-child(2) .card-body")).click();
	    assertThat(driver.findElement(By.cssSelector(".col:nth-child(2) .card-text:nth-child(3)")).getText(), is("Circuit: Yoshi Circuit"));
	  }
	  @Test
	  public void deletearace() {
	    driver.get("http://localhost:8080/");
	    driver.manage().window().setSize(new Dimension(974, 1040));
	    driver.findElement(By.cssSelector("#raceCards > .col:nth-child(1) .card-link")).click();
	    driver.findElement(By.cssSelector("#raceCards .card-body")).click();
	    driver.findElement(By.cssSelector("#raceCards .card-body")).click();
	    assertThat(driver.findElement(By.cssSelector("#raceCards .card-text:nth-child(3)")).getText(), is("Circuit: Yoshi Circuit"));
	  }
	  @Test
	  public void deleteseriesinuse() {
	    driver.get("http://localhost:8080/");
	    driver.manage().window().setSize(new Dimension(974, 1040));
	    driver.findElement(By.linkText("Delete")).click();
	    driver.findElement(By.cssSelector("#seriesCards .card-body")).click();
	    driver.findElement(By.cssSelector("#seriesCards .card-body")).click();
	    assertThat(driver.findElement(By.cssSelector("#seriesCards .card-text:nth-child(1)")).getText(), is("Id: 1"));
	  }
	  @Test
	  public void deleteaseries() {
	    driver.get("http://localhost:8080/");
	    driver.manage().window().setSize(new Dimension(974, 1040));
	    driver.findElement(By.id("name")).click();
	    driver.findElement(By.id("name")).sendKeys("IndyCar");
	    driver.findElement(By.id("car")).sendKeys("Dallara");
	    driver.findElement(By.cssSelector("#newSeries > fieldset > input")).click();
	    driver.findElement(By.cssSelector("#raceCards .card-link")).click();
	    driver.findElement(By.linkText("Delete")).click();
	    driver.findElement(By.cssSelector(".card-body")).click();
	    driver.findElement(By.cssSelector(".card-body")).click();
	    assertThat(driver.findElement(By.cssSelector(".card-text:nth-child(1)")).getText(), is("Id: 2"));
	  }
	  @After
	  public void tearDown() {
	    driver.quit();
	  }
}
