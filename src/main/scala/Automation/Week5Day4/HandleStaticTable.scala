package Automation.Week5Day4

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.{By, JavascriptExecutor, WebDriver}

import scala.jdk.CollectionConverters.CollectionHasAsScala

object HandleStaticTable extends App {
  //Instantiating the ChromeDriver for interacting with the Chrome Browser
  val driver: WebDriver = new ChromeDriver()

  // Accessing the web url for testing
  driver.get("https://www.w3schools.com/html/html_tables.asp")
  driver.manage().window().maximize()

  val rows = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[position() > 1]"))

  for ( i <- 0 until  rows.size()){
    val cols = rows.get(i).findElements(By.tagName("td"))


    val rowText = cols.toArray.map(_.asInstanceOf[org.openqa.selenium.WebElement].getText).mkString((" | "))
    println(s"Row ${i+1}: $rowText")

    val js = driver.asInstanceOf[JavascriptExecutor]
    //js.executeScript("arguments[0].scrollIntoView(true);", rows.get(i))
    js.executeScript("arguments[0].click()", rows.get(i))
    println(s"Row ${i+1} clicked")
  }
//  //table[@id='customers']/tbody/tr[position() > 1]
  //driver.quit()


}
