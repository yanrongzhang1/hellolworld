package Automation.Week5Day4

import org.openqa.selenium.{By, JavascriptExecutor, WebDriver, WebElement}
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.{ExpectedCondition, ExpectedConditions, WebDriverWait}

import java.time.Duration
import scala.jdk.CollectionConverters.CollectionHasAsScala

object AfternoonTask extends App {
  //  1. Navigate to the Practice Table URL: https://cosmocode.io/automation-practice-webtable/
  val driver: WebDriver = new ChromeDriver()
  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10))
  driver.get("https://cosmocode.io/automation-practice-webtable/")

  //  2. Static Table Handling
  //  • Locate the table containing country data.
  val countryTable: WebElement = driver.findElement(By.id("countries"))

  //  • Extract and print all country names from the first column.
  val rows: Array[WebElement] = driver.findElements(By.xpath("//table/tbody/tr[position() >1]")).asScala.toArray

  for (i <- rows.indices) {
    val countryElement: WebElement = rows(i).findElement(By.cssSelector("td:nth-child(2)"))
    println(s"Row ${i + 1}: ${countryElement.getText}")

    //  • Use JavaScript Executor to highlight each row as it’s read.
    val jsExecutor = driver.asInstanceOf[JavascriptExecutor]
//    jsExecutor.executeScript("arguments[0].setAttribute('style', 'background: yellow;');", rows(i))
    jsExecutor.executeScript("arguments[0].style.background =  'yellow';", rows(i))
    if (i > 0) {
      jsExecutor.executeScript("arguments[0].setAttribute('style', 'background: white;');", rows(i - 1))
    }
  }

  //  3. Implicit Wait
  //  • Set a global implicit wait of 10 seconds.

  //  4. Explicit Wait
  //  • Wait for a specific country row (e.g., "Germany") to be visible.
  //  • Once visible, extract its capital and currency.
  val explicitWait: WebDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30))
  explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"countries\"]/tbody/tr[66]")))

  val row: WebElement = driver.findElement(By.xpath("//*[@id=\"countries\"]/tbody/tr[66]"))
  val cols: List[WebElement] = row.findElements(By.tagName("td")).asScala.toList

  println(s"Country: ${cols(1).getText}, Capital: ${cols(2).getText}, Currency: ${cols(3).getText}")


  driver.quit()

}
