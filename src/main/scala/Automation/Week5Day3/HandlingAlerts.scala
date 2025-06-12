package Automation.Week5Day3

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.{By, WebDriver, WebElement}

object HandlingAlerts extends App {

  val driver: WebDriver = new ChromeDriver()

  driver.get("https://the-internet.herokuapp.com/javascript_alerts")

  //Simple Alert Code
  driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button")).click()
  val alert = driver.switchTo().alert()
  println("Simple Alert Text = " + alert.getText)
  alert.accept()
  println("Simple Alert Passed")

  // Confirmation Alert Code
  driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button")).click()
  val alert2 = driver.switchTo().alert()
  println("Confirmation Alert Text = " + alert2.getText)
  alert2.dismiss()
  println("Confirmation Alert Passed")

  // Prompt Alert Code
  driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button")).click()
  val alert3 = driver.switchTo().alert()
  println("Prompt Alert Text = " + alert3.getText)
  alert3.sendKeys("Welcome")
  alert3.accept()
  println("Prompt Alert Passed")

  driver.quit()


}
