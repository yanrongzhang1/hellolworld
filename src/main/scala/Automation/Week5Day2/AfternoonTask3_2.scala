package Automation.Week5Day2


import org.openqa.selenium.{By, WebDriver, WebElement}
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.JavascriptExecutor
import java.time.Duration

object AfternoonTask3_2 extends App {

  //  Use this link: https://demoqa.com/automation-practice-form
  //  Create a simple automation script that locates elements on a test page and uses Web
  //  Element conditional methods to verify their states before interacting.
  //  1. Launch the browser using WebDriver.
  val driver: WebDriver = new ChromeDriver()
  //  2. Navigate to the test URL.
  driver.get("https://demoqa.com/automation-practice-form")
  driver.manage().window().maximize()
  // wait
  //    val duration: java.time.Duration = Duration.ofSeconds(30)
  //    driver.manage.timeouts.implicitlyWait(duration)

  //  3. Locate these elements:
  //    o First Name input field
  val firstName: WebElement = driver.findElement(By.cssSelector("#firstName"))

  //  o Submit button
  val submit: WebElement = driver.findElement(By.xpath("//button[@type='submit']"))

  //  o Hobbies checkbox

  val hobbiesCheckbox1 = driver.findElement(By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[1]/label"))
  val hobbiesCheckbox2 = driver.findElement(By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[2]/label"))
  val hobbiesCheckbox3 = driver.findElement(By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[3]/label"))



  //use findElements

  //  4. Use conditional methods to:
  //    o Check if the First Name input is displayed and enabled before typing a name.
  if (firstName.isDisplayed && firstName.isEnabled) {
    firstName.clear()
    firstName.sendKeys("testName")
    println("firstName is displayed and enabled")
  }
  //  o Check if the Hobbies checkbox is selected; if not, select it.
  if (!hobbiesCheckbox1.isSelected) {
    driver.asInstanceOf[JavascriptExecutor].executeScript("arguments[0].scrollIntoView(true);", hobbiesCheckbox1);
    hobbiesCheckbox1.click()
    println("Sports is selected")
  }

  //  o Check if the Submit button is displayed and enabled before clicking it.
  if (submit.isDisplayed && submit.isEnabled) {
    submit.click()
    println("submit is displayed and enabled")
  }
  //  5. Print meaningful messages for each condition check and action taken.

  //  6. Close the browser at the end.
  //driver.quit()

}
