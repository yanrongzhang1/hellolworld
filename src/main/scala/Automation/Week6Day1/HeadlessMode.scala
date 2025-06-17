package Automation.Week6Day1

import org.openqa.selenium.chrome.{ChromeDriver, ChromeOptions}
import org.openqa.selenium.{By, WebDriver}

object HeadlessMode extends App {

  val options: ChromeOptions = new ChromeOptions()
  //  options.addArguments("--headless") //Headless mode
  // recommend use this one
  options.addArguments("--headless=new") //Headless mode
  val driver: WebDriver = new ChromeDriver(options)
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
