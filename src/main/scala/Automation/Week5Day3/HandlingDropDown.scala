package Automation.Week5Day3

import org.openqa.selenium.{By, WebDriver, WebElement}
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.Select

object HandlingDropDown extends App {

  val driver: WebDriver = new ChromeDriver()

  driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select")
  //name or id of the frame
  driver.switchTo().frame("iframeResult")

  val dropdown: WebElement = driver.findElement(By.name("cars"))

  val select = new Select(dropdown)

  select.selectByVisibleText("Opel")

  println("selected by Visible Text - " + select.getFirstSelectedOption.getText)

  select.selectByValue("volvo")

  println("selected by value - " + select.getFirstSelectedOption.getText)

  select.selectByIndex(3)

  println("selected by Index - " + select.getFirstSelectedOption.getText)


  driver.quit()


}
