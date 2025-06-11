package Automation.Week5Day2

import org.openqa.selenium.{By, JavascriptExecutor, Keys, WebElement}
import org.openqa.selenium.chrome.ChromeDriver

import scala.jdk.CollectionConverters.CollectionHasAsScala
import scala.util.control.Breaks.{break, breakable}

object Extension extends App {

  val driver = new ChromeDriver()

  driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html")

  val currentWindowHandle: String = driver.getWindowHandle

  //  o One must use `partialLinkText`
  val partialLink1: WebElement = driver.findElement(By.partialLinkText("Compen"))
  partialLink1.click()

  // Open a new tab/window (example using JavaScript)
  driver.asInstanceOf[JavascriptExecutor].executeScript("window.open()");

  // switch to a different tab
  val allWindowHandles: Set[String] = driver.getWindowHandles.asScala.toSet
  breakable {
    for (handle <- allWindowHandles) {
      println(handle)
      if (handle != currentWindowHandle) {
        driver.switchTo().window(handle)
        break
      }
    }
  }

  // Navigate to a new URL in the new window
  driver.navigate().to("https://www.example.com")

  //switch back to the original window
  driver.switchTo().window(currentWindowHandle)
  driver.navigate().to("https://demoqa.com/automation-practice-form")


  //NoSuchElementException is thrown if findElement can't locate the element using the specified locator
  //If the specified locator strategy doesn't find any elements, findElements() will return an empty list, preventing an exception.


//difference between .get() and .navigate().to()
//  Factors
//  get()
//  navigate()
//  Interface Part
//
//  The get function is a part of the Webdriver interface.
//
//  The navigate function is a part of the Navigation interface.
//
//  Wait for webpage load
//
//  The get function waits until the webpage is loaded properly and available to return control.
//
//    The navigate function does not wait for the webpage to be loaded properly.
//
//  History tracking feature
//
//  The get function does not have the history tracking feature, thus enabling the user not to go back.
//
//  The navigate function has a history tracking feature. Thus, the user can go back to the previous web page too.
//
//    Refresh feature
//
//  The get function does not support the refresh feature.
//
//    The navigate function supports the refresh feature.
//
//    Forward feature
//
//  The get function does not support the forward function once the user has moved to the earlier webpage.
//
//  The navigate function supports the forward function and lets the user move to the next page once the user has moved to the earlier webpage.
//



//  Selenium Manager is a new tool that helps to get a working environment to run Selenium out of the box. Beta 1 of Selenium Manager
//    will configure the browser drivers for Chrome, Firefox, and Edge if they are not present on the PATH.
  //  driver.close()
  //driver.quit()

}
