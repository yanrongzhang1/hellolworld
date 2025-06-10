package Automation.Week5Day1

import org.openqa.selenium.{By, WebDriver, WebElement}
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}

import java.time.Duration
import java.util.concurrent.TimeUnit

object Task2 extends App {

  val driver: WebDriver = new ChromeDriver()
  //Implicit wait
  val duration: java.time.Duration = Duration.ofSeconds(10)
  driver.manage.timeouts.implicitlyWait(duration)

  driver.get("https://the-internet.herokuapp.com/login")

  val userName: WebElement = driver.findElement(By.xpath("//input[@id='username']"))
  userName.sendKeys("testUser")

  val password: WebElement = driver.findElement(By.xpath("//input[@id='password']"))
  password.sendKeys("password123")

  val submit: WebElement = driver.findElement(By.xpath("//button[@type='submit']"))
  submit.click()

  //explicit wait
  //  val wait1: WebDriverWait = new WebDriverWait(driver,duration)
  //  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='flash']")))

  val result: WebElement = driver.findElement(By.xpath("//div[@id='flash']"))
  println(result.getText)

  driver.quit()
}
