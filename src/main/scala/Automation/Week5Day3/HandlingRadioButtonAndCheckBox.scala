package Automation.Week5Day3

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.{By, WebDriver, WebElement}

object HandlingRadioButtonAndCheckBox extends App {

  val driver: WebDriver = new ChromeDriver()

  driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html")


  driver.quit()


}
