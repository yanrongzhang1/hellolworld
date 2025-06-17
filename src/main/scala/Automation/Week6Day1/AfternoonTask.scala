package Automation.Week6Day1

import Automation.Utils.ScreenCapture
import org.openqa.selenium.{By, TimeoutException}
import org.openqa.selenium.chrome.{ChromeDriver, ChromeOptions}
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}

import java.time.Duration

object AfternoonTask extends App {

  //  MVP:
  //    Automate the following scenario:
  //  Headless Login with Screenshot Capture and exception handling.
  //  1. Use ChromeDriver with `
  //  --headless=new option`

  val options = new ChromeOptions()
  options.addArguments("--headless=new")
  val driver = new ChromeDriver(options)

  //  2. Navigate to the login URL - https://the-internet.herokuapp.com/login
  //    a. Username: tomsmith
  //  b. Password: SuperSecretPassword!
  try {
    driver.get("https://the-internet.herokuapp.com/login")
    val username = driver.findElement(By.id("username"))
    username.sendKeys("tomsmith1")
    val password = driver.findElement(By.id("password"))
    password.sendKeys("SuperSecretPassword!")

    //    3. Submit the login form.
    val submit = driver.findElement(By.tagName("button"))
    submit.click()

    driver.findElement(By.id("pw")).click()
    //  4. Wait for the result message (success or failure).

    val explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10))
    explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'flash')]")))

    explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'flash1')]")))
    //  5. Take a screenshot [Wrap key steps in a utility function that takes a screenshot].
    //  6. Save as screenshots/YYYY-MM-DD-success-<timestamp>.png or screenshots/YYYY-MM-
    //    DD-failure-<timestamp>.png

    val capture = new ScreenCapture()
    if (driver.findElement(By.id("flash")).getAttribute("class").contains("success")) {
      capture.screenCapture(driver, "/Users/yanrong.zhang/Documents/Week6Day1", "success")
    }
    else {
      capture.screenCapture(driver, "/Users/yanrong.zhang/Documents/Week6Day1", "failure")
    }
  }catch{
    case e: NoSuchElementException =>
      println("No element found")
//      println(e.getMessage)
    case e: TimeoutException =>
      println("Time out exception")
      println(e.getMessage)
    case e: Exception =>{
      println(e.getMessage)
      e.printStackTrace()
    }
  }


  //  7. Use try / catch / finally:
  //  a. catch Selenium exceptions (e.g., NoSuchElementException, TimeoutException)
  //  8. Finally, call driver.quit().
  finally {
    driver.quit()
  }
  //
}
