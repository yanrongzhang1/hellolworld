package Automation.Week5Day3

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.{By, WebDriver, WebElement}

object HandlingButtonsAndLinks extends App {

  val driver: WebDriver = new ChromeDriver()

  driver.get("https://www.selenium.dev/selenium/web/web-form.html")

  driver.manage().window().maximize()

  val button: WebElement = driver.findElement(By.cssSelector("[type='submit']"))
  if (button.isEnabled) {
    println("button text - " + button.getText)
    button.click()
  } else {
    println("Button is not enabled")
  }

 // Handling Hyperlinks
  driver.get("https://www.selenium.dev/")
  val myLink: WebElement = driver.findElement(By.cssSelector("a[href*='docum']"))
  println("Destination URL - " + myLink.getAttribute("href"))

  driver.quit()


}
