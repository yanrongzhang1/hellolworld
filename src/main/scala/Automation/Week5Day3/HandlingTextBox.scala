package Automation.Week5Day3

import org.openqa.selenium.{By, WebDriver, WebElement}
import org.openqa.selenium.chrome.ChromeDriver

object HandlingTextBox extends App {

  val driver: WebDriver = new ChromeDriver()

  driver.get("https://www.selenium.dev/selenium/web/web-form.html")

  val text: WebElement = driver.findElement(By.id("my-text-id"))
  text.sendKeys(("Welcome to Mercator"))
  println("The value has benn entered")

  println("The attribute value: " +  text.getAttribute("value"))

  // getText return empty value
  val text2: String = text.getText
  println("Get text : " + text2)

  text.clear()
  println("The value has been cleared down")


  driver.quit()


}
