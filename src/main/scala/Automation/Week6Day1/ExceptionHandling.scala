package Automation.Week6Day1

import Automation.Utils.ScreenCapture
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import org.openqa.selenium.{By, NoSuchElementException, WebDriver}

import java.time.Duration

object ExceptionHandling extends App {

  val driver: WebDriver = new ChromeDriver()

  try {
    driver.get("https://www.selenium.dev/selenium/web/web-form.html")


//    driver.get("https://the-internet.herokuapp.com/dynamic_loading/1\n\n ")
    driver.findElement(By.id("invalid_id")).click()

//    val explicitWait = new WebDriverWait(driver, Duration.ofSeconds(3))
//    explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")))
  }
  catch {
//    case e: NoSuchElementException =>
//      println("element not found" + e.getMessage)
    case e: NoSuchElementException =>
      println("Element not found")
      //e.printStackTrace()
    case e: Exception =>
      println("Print any exception" + e.getMessage)
      e.printStackTrace()
  }
  finally {
    if (driver != null) {
      driver.quit()
    }

  }

//create new folder dynamically
//  val screenshotsDir = new File("screenshots")
//  if (!screenshotsDir.exists())
//    screenshotsDir.mkdirs() // Create screenshots directory

  //getFullPageScreenShotAs
  //javaCopyEdit((FirefoxDriver) driver).getFullPageScreenshotAs(OutputType.FILE);

  //Automate folder creation with date/time stamps to avoid overwrites
  //new File("screenshots/" + LocalDate.now()).mkdirs();


}
