package Automation.Week5Day4

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.{By, WebDriver, WebElement}

import scala.jdk.CollectionConverters.CollectionHasAsScala

object HandleWindows extends App {
  //Instantiating the ChromeDriver for interacting with the Chrome Browser
  val driver: WebDriver = new ChromeDriver()

  // Accessing the web url for testing
  driver.get("https://the-internet.herokuapp.com/windows")
  driver.manage().window().maximize()

  val parentWindow = driver.getWindowHandle
  println("Handle for the parent windowL " + parentWindow)

  driver.findElement(By.linkText(("Click Here"))).click()

  val allWindows: List[String] = driver.getWindowHandles.asScala.toList
  val it = allWindows.iterator

  while(it.hasNext) {
    val handle = it.next()

    if (handle != parentWindow){
      driver.switchTo().window(handle)
      println("The current window " + handle)

      println("The page title is - " + driver.getTitle)
    }
  }

  driver.quit()


}
