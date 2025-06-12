package Automation.Week5Day3

import org.openqa.selenium.{By, WebDriver, WebElement}
import org.openqa.selenium.chrome.ChromeDriver

object HandlingFrame extends App {

  val driver: WebDriver = new ChromeDriver()

  driver.get("https://the-internet.herokuapp.com/nested_frames")

  driver.switchTo().frame("frame-top")
  driver.switchTo().frame("frame-middle")

  val middleText: String = driver.findElement(By.id("content")).getText
  println("Middle Text = " + middleText)

  driver.switchTo().defaultContent()

  driver.switchTo().frame(1)

  val bottomText: String = driver.findElement(By.tagName("body")).getText
  println("Bottom Text = " + bottomText)

  driver.switchTo().defaultContent()

  val frameTop: WebElement = driver.findElement(By.name("frame-top"))
  driver.switchTo().frame(frameTop)
  driver.switchTo().frame("frame-left")
  val leftText: String = driver.findElement(By.tagName("body")).getText
  println("Left text - " + leftText)


  driver.quit()


}
