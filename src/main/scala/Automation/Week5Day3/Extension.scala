package Automation.Week5Day3

import org.openqa.selenium.{By, WebDriver, WebElement}
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}

import java.time.Duration
import scala.jdk.CollectionConverters.CollectionHasAsScala

object Extension extends App {

  val driver: WebDriver = new ChromeDriver()


  //  1. Handle Alerts:
  //  • Go to this URL: https://www.tutorialspoint.com/selenium/practice/alerts.php
  driver.get("https://www.tutorialspoint.com/selenium/practice/alerts.php")

  //  • Trigger and accept a simple alert.
  val simpleAlertBtn = driver.findElement(By.cssSelector("div.col-md-8.col-lg-8.col-xl-8 > div:nth-child(2) > button"))
  simpleAlertBtn.click()
  val simpleAlert = driver.switchTo().alert()
  println("Simple Alert Text - " + simpleAlert.getText)
  simpleAlert.accept()

  //  • Trigger and dismiss a confirm alert.
  val confirmAlertBtn = driver.findElement(By.cssSelector("div.col-md-8.col-lg-8.col-xl-8 > div:nth-child(4) > button"))
  confirmAlertBtn.click()
  val confirmAlert = driver.switchTo().alert()
  println("Confirm Alert Text - " + confirmAlert.getText)
  confirmAlert.dismiss()


  //  • Trigger a prompt alert, enter text, and accept.
  val promptAlertBtn = driver.findElement(By.cssSelector("div.col-md-8.col-lg-8.col-xl-8 > div:nth-child(5) > button"))
  promptAlertBtn.click()
  val promptAlert = driver.switchTo().alert()
  println("Prompt Alert Text - " + promptAlert.getText)
  promptAlert.sendKeys("A prompt alert")
  promptAlert.accept()


  //  2. Handle Frames:
  //  • Go to this URL: https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe
  //  • Switch to the frame and interact with the simple content inside it.
  //  • Go to this URL: https://www.tutorialspoint.com/selenium/practice/nestedframes.php
  //  • Switch to a frame that is nested and access content inside it.

  driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe")
  driver.switchTo().frame("iframeResult")
  println(driver.findElement(By.xpath("//body/h2")).getText)
  driver.switchTo().frame(0)
  println(driver.findElement(By.xpath("//body/h1")).getText)


  driver.switchTo().defaultContent()

  driver.get("https://www.tutorialspoint.com/selenium/practice/nestedframes.php")

  val wait1: WebDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10))
  val topFrame: WebElement = wait1.until(ExpectedConditions.presenceOfElementLocated(By.tagName("iframe")))
  driver.switchTo().frame(topFrame)
  println(driver.findElement(By.cssSelector("header > div > a")).getAttribute("href"))

//
//  driver.switchTo().frame(0)

//  val iframeList: List[WebElement] = driver.findElements(By.tagName("iframe")).asScala.toList
//  println(iframeList.size)
  println("Inside outer frame")
  // We don't need to switch to `frame2` here as it isn't a traditional nested iframe, it is part of the html content which makes up `frame1`
  val innerText = driver.findElement(By.tagName("body")).getText // Interact with an element inside the nested frame
  println(s"Text inside nested frame:\n$innerText")
  driver.switchTo().defaultContent() // Switch back to the main content

   driver.quit()
}
