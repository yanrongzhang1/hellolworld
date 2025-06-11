package Automation.Week5Day2

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

object AfternoonTask1 extends App {

  //
  //  Task 1:
  //    Use this link: https://demoqa.com/browser-windows
  //  Create a simple automation script that demonstrates usage of key WebDriver browser-
  //    level methods.

  //  1. Launch the browser using WebDriver.
  val driver: WebDriver = new ChromeDriver()

  //  2. Navigate to the test URL.
  driver.get("https://demoqa.com/browser-windows")

  //  3. Fetch and print:
  //    o Page title
  println(driver.getTitle)
  //  o Current URL
  println(driver.getCurrentUrl)

  //  4. Close current window.
  driver.close()

  //  5. End the session.
  driver.quit()

}
