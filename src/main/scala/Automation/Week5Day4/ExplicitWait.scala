package Automation.Week5Day4

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import org.openqa.selenium.{By, JavascriptExecutor, WebDriver}

import java.time.Duration

object ExplicitWait extends App {
  //Instantiating the ChromeDriver for interacting with the Chrome Browser
  val driver: WebDriver = new ChromeDriver()

  // Accessing the web url for testing
  driver.get("https://www.w3schools.com/howto/howto_css_custom_checkbox.asp")
  driver.manage().window().maximize()

  val explicitWait = new WebDriverWait(driver, Duration.ofMinutes(1))

  val checkBox = explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"main\"]/div[3]/div[2]/label[1]")))
  val js = driver.asInstanceOf[JavascriptExecutor]
  js.executeScript("arguments[0].scrollIntoView(true);", checkBox)
  js.executeScript("arguments[0].click()", checkBox)
//  checkBox.click()

  println("Checkbox is clicked")



    driver.quit()


}
