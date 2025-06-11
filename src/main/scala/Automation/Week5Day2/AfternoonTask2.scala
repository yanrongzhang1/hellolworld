package Automation.Week5Day2

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

object AfternoonTask2 extends App{
//  Use this link: https://demoqa.com/automation-practice-form
//  Create a simple automation script that demonstrates usage of key WebDriver browser-
//    level methods.

  //  1. Launch the browser using WebDriver.
  val driver: WebDriver = new ChromeDriver()

  //  2. Navigate to the test URL.
  driver.get("https://demoqa.com/automation-practice-form")

  //  3. Navigate:
  //    o to "https://example.com"
  driver.navigate().to("https://example.com")

  //  o back
  driver.navigate().back()

  //    o forward
  driver.navigate().forward()

  //    o refresh
  driver.navigate().refresh()

  //    4. Using built in methods, maximise and minimise the browser window.
  driver.manage().window().maximize()

  driver.manage().window().minimize()

  //  5. Print part of the page source.
  val pageSource: String = driver.getPageSource
  println(pageSource.length)
  println(pageSource.substring(0,100))

  //  6. Close current window.
  driver.close()

  //  7. End the session.
  driver.quit()
}
