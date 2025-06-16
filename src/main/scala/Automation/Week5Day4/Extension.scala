package Automation.Week5Day4

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.{ExpectedConditions, FluentWait, WebDriverWait}
import org.openqa.selenium.{By, JavascriptExecutor, WebDriver, WebElement}

import java.time.Duration
import scala.jdk.CollectionConverters.CollectionHasAsScala

object Extension extends App {

  val driver: WebDriver = new ChromeDriver()
  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10))
  driver.get("https://cosmocode.io/automation-practice-webtable/")

  //  1. JavaScript Executor
  //  • Scroll to the bottom of the page using JavaScript.
  //  • Change the background colour of the "Country" column header.
  //  • Retrieve and print the page title using JavaScript.
  val jsExecutor = driver.asInstanceOf[JavascriptExecutor]
  jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);")

  val countryHeader: WebElement = driver.findElement(By.xpath("//table[@id='countries']/tbody/tr/td[2]"))
  jsExecutor.executeScript("arguments[0].style.background = 'red' ", countryHeader)
  jsExecutor.executeScript("window.scrollTo(0, 0);")

  val title = jsExecutor.executeScript("return document.title;")
  println(title)

  //  2. Fluent Wait
  //  • Use Fluent Wait to wait for a specific row (e.g., "India") to become visible.
  //  • Set polling every 500ms, timeout after 15 seconds.\
  val fulentWait: FluentWait[WebDriver] = new FluentWait[WebDriver](driver)
    .withTimeout(Duration.ofSeconds(15))
    .pollingEvery(Duration.ofMillis(500))

  fulentWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"countries\"]/tbody/tr[78]")))
  jsExecutor.executeScript("arguments[0].style.background = 'red' ;", driver.findElement(By.xpath("//*[@id=\"countries\"]/tbody/tr[78]")))
  println("set background to red")


  //  3. Table Validation
  //  • Write a test that verifies if a specific language (e.g., "French") is listed in the table.
  //  • Extract and print all country names from the first column.
  val rows: Array[WebElement] = driver.findElements(By.xpath("//table/tbody/tr[position() >1]")).asScala.toArray

  var numFrenchFound: Int = 0
  for (i <- rows.indices){
    val language = rows(i).findElement(By.cssSelector("td:nth-child(5"))
    if( language.getText.contains("French")){
      numFrenchFound = numFrenchFound + 1
      jsExecutor.executeScript("arguments[0].style.background = 'blue';", language )
    }

  }
  println("Number of countries primary language has French is " + numFrenchFound)
  assert(numFrenchFound > 0,  "French not listed")

  //  • Highlight the corresponding row if found.

  driver.quit()

}
