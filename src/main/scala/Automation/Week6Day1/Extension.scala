package Automation.Week6Day1

import Automation.Utils.ScreenCapture
import org.openqa.selenium.{By, WebElement}
import org.openqa.selenium.chrome.ChromeDriver

import java.time.Duration
import scala.jdk.CollectionConverters.CollectionHasAsScala

object Extension extends App {
  //  Write a Scala program that clicks a column header to trigger sorting, then verifies that the rows on
  //    the page are in the correct order (ascending and descending).
  //    URL: https://the-internet.herokuapp.com/tables
  //  The page contains two sortable HTML tables (#table1, #table2).
  //  Clicking any column header cycles unsorted → ascending → descending.
  val driver = new ChromeDriver()
   driver.manage.timeouts.implicitlyWait(Duration.ofSeconds(10))

  driver.get("https://the-internet.herokuapp.com/tables")
  //  1. Navigate to the URL and locate Table 1.
  val table1 = driver.findElement(By.id("table1"))
  val headers = table1.findElements(By.tagName("th"))

  //  2. Trigger sorting.
  headers.get(1).click()

  //  3. Capture the column values after each click.

  def compareTableColumn(table: WebElement, column: Int, order: String): Unit = {
    val rows = table.findElements(By.tagName("tr"))
    var firstRow = rows.get(1).findElements(By.tagName("td")).get(column).getText
    for (i <- 2 until (rows.size)) {

      val nextRow = rows.get(i).findElements(By.tagName("td")).get(1).getText
      //print(nextRow >= firstRow)
      if (order == "ASC") {
        assert(nextRow >= firstRow)
      }
      else {
        assert(nextRow <= firstRow)
      }
      firstRow = nextRow
    }
  }
  //  4. Verify ascending and descending order.
  compareTableColumn(table1, 1, "ASC")
  val capture = new ScreenCapture()
  capture.screenCapture(driver, "/Users/yanrong.zhang/Documents/Week6Day1/Table", "ASC")
  headers.get(1).click()

  compareTableColumn(table1, 1, "DESC")

  capture.screenCapture(driver, "/Users/yanrong.zhang/Documents/Week6Day1/Table", "DESC")

  driver.quit()
}





