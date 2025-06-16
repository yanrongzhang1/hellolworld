package Automation.Week5Day5

import org.openqa.selenium.{By, WebElement}
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.{By, WebElement}
import org.openqa.selenium.chrome.ChromeDriver
import java.util
import scala.jdk.CollectionConverters.CollectionHasAsScala

//object LoopPractice extends App {
//
//  //for comprehension
//  /**
//   * for( item <- collection){
//   * // Do something to every item
//   * }
//   */
//
//
//  val fruits: List[String] = List("Apple", "Banana", "Cherry", "Melon")
//
//  for (fruit <- fruits) {
//    println(fruit)
//  }
//
//  //turn into selenium
//  /**
//   * .asScalar -> turn it into scala from java
//   * for (fruit <- fruits.asScala){
//   * println(fruit.getText)
//   * }
//   */
//  val driver = new ChromeDriver()
//  driver.get("https://example.com")
//
//  //loop through a list of elements
//  val items: util.List[WebElement] = driver.findElements(By.id("i"))
//  for (item <- items.asScala) {
//    println(item.getText)
//  }
//
//  //click all buttons within a selection
//  val buttons: util.List[WebElement] = driver.findElements((By.cssSelector((".my-buttons"))))
//  for (button <- buttons.asScala) {
//    button.click()
//  }
//
//  //find a specific element( within a loop - collection of a types)
//  //need to use an `if` within the for comp
//
//  val links = driver.findElements(By.tagName("a"))
//  //find the 'contact us' link
//
//  for (link <- links.asScala) {
//    if (link.getText.contains("Contact")) {
//      link.click()
//    } else {
//      println("No links containing `contact` were found.")
//    }
//  }
//  //Tables
//  <table>
//    <tr>
//      <td>Apple</td> <td>Red</td>
//    </tr>
//    <tr>
//      <td>Banana</td> <td>Yellow</td>
//    </tr>
//
//  </table>
//
//  //loop through table rows
//  val rows = driver.findElements((By.tagName("tr")))
//  for ((row, index) <- rows.asScala.zipWithIndex) {
//    val cells = row.findElements((By.tagName("td")))
//    val makeString = cells.asScala.map(_.getText).mkString(" , ".trim)
//    println(makeString)
//  }
//  //zipWithIndex Method
//  //pair each row with its index (starting from 0)
//  // Row 0: Apple | Red
//
//  //Does a value exist?
//  val doesBananaExist = rows.asScala.exists{
//    row => val cells = row.findElements((By.tagName("td"))).asScala
//      cells.exists(_.getText == "Banana")
//  }
//  assert(doesBananaExist, "Yay bananas!")
//}
