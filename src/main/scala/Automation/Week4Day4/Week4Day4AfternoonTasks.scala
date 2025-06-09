package Automation.Week4Day4

import org.openqa.selenium.{By, WebDriver, WebElement}
import org.openqa.selenium.chrome.ChromeDriver
import scala.jdk.CollectionConverters._

object Week4Day4AfternoonTasks extends App {

  val driver: WebDriver = new ChromeDriver()
    driver.get("https://www.selenium.dev/selenium/web/web-form.html")
  //  driver.manage().window().maximize()

    val textInput: WebElement = driver.findElement(By.id("my-text-id"))
    textInput.sendKeys("Alice")
    println("TextInput entered - passed")

    val password: WebElement = driver.findElement(By.name("my-password"))
    password.sendKeys("12345")
    println("Password entered - passed")

    val formControls: List[WebElement] = driver.findElements(By.className("form-control")).asScala.toList
    val numFormControls: Int = formControls.length
    formControls(2).sendKeys("This is a test comment")
    println("Textarea entered - passed")

    val inputTags: List[WebElement] = driver.findElements(By.tagName("input")).asScala.toList
    val numTags: Int = inputTags.length
  //  for (tag <- inputTags) println(tag.getTagName)
    println(s"There are $numTags <input> tags")

    val linkText: WebElement = driver.findElement(By.linkText("Return to index"))
    linkText.click()
    println("LinkText clicked")

    driver.navigate().back()

    val partialLinkText: WebElement = driver.findElement(By.partialLinkText("Return"))
    partialLinkText.click()
    println("Partial LinkText clicked")

  //MVP
//  driver.get("https://www.w3schools.com/html/html_examples.asp")
//  val buttons: List[WebElement] = driver.findElements(By.className("w3-button")).asScala.toList
//  val numButtons: Int = buttons.length
//  println(s"There are $numButtons buttons")
//
//  val images: List[WebElement] = driver.findElements(By.tagName("img")).asScala.toList
//  val numImages: Int = images.length
//  println(s"There are $numImages images")
//
//  val header1s: List[WebElement] = driver.findElements(By.tagName("h1")).asScala.toList
//  val numHeader1s: Int = header1s.length
//  println(s"There are $numHeader1s h1")
//
//  def findNumTags(name: String): Int = {
//    val elements: List[WebElement] = driver.findElements(By.tagName(name)).asScala.toList
//    elements.length
//  }
//
//  val tagSet: Set[String] = Set("p", "a", "h1", "button")
//  for (tag <- tagSet) {
//    val num: Int = findNumTags(tag)
//    println(s"There are $num <$tag>s")
//  }
//
//  val hyperLinkTagSet: Set[String] = Set("a", "img", "iframe")
//  var total: Int = 0
//  for (tag <- hyperLinkTagSet) {
//    val num: Int = findNumTags(tag)
//    total = total + num
//  }
//  println(s"There are $total hyperlinks")
//
//  driver.get("https://demoqa.com/text-box/")
//  val fullName: WebElement = driver.findElement(By.cssSelector("input[placeholder='Full Name']"))
//  fullName.sendKeys("test place holder")
//
//  val header_with_space: WebElement = driver.findElement(By.xpath("//*[normalize-space(text()) = 'Text Box']"))
//  println(header_with_space.getText)
////*[normalize-space(text())='Same as current house address']
////*[contains(normalize-space(), 'Same as current house address')]
//  hidden element
//click the button to make the element visible
//driver.get("https://www.w3schools.com/howto/howto_js_toggle_hide_show.asp")
//  driver.findElement(By.xpath("//*[normalize-space(text()) = 'Toggle Hide and Show']")).click()

//drag and drop
//
//driver.get("https://the-internet.herokuapp.com/drag_and_drop")
//  driver.findElement(By.id("column-a"))







  driver.quit()


}
