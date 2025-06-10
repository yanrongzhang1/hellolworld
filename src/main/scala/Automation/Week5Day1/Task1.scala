package Automation.Week5Day1

import org.openqa.selenium.{By, WebDriver, WebElement}
import org.openqa.selenium.chrome.ChromeDriver

object Task1 extends App {
  val driver: WebDriver = new ChromeDriver()
  driver.get("https://www.selenium.dev/selenium/web/web-form.html")

  val textInput: WebElement = driver.findElement(By.cssSelector("#my-text-id"))
  textInput.sendKeys("testUser")

  val password: WebElement = driver.findElement(By.cssSelector("input[type='password']"))
  password.sendKeys(("mySecrete"))

  val submit: WebElement = driver.findElement(By.cssSelector("button.btn"))
  submit.click()

  driver.quit()
}
