package Automation.Week5Day1

import Automation.Week5Day1.Task2.driver
import org.openqa.selenium.{By, WebDriver, WebElement}
import org.openqa.selenium.chrome.ChromeDriver

import java.time.Duration

object AfternoonTask extends App {

  val driver: WebDriver = new ChromeDriver()

  //Implicit wait
  val duration: java.time.Duration = Duration.ofSeconds(10)
  driver.manage.timeouts.implicitlyWait(duration)

  //1.  Navigates to the above Test web URL.
  driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html")


  //  2. Enters text into:
  //    o A username field
  //    o A password field
  //    o A comments/extra field
  //by.name
  val userName: WebElement = driver.findElement(By.name("username"))
  userName.sendKeys("testUser")

  //cssSelector - Parent > child
  val password: WebElement = driver.findElement(By.cssSelector("tbody>tr:nth-child(2)>td>input"))
  password.sendKeys("password123")

  //tagName
  val comments: WebElement = driver.findElement(By.tagName("textarea"))
  comments.clear()
  comments.sendKeys("This is for testing.")

  // 3. Clicks on:
  //  o A checkbox
  //  o A submit button
  //  o A link on the page

  // cssSelector attribute
  val checkBox: WebElement = driver.findElement(By.cssSelector("input[value='cb1']"))
  checkBox.click()

  // xpath contains attribute
  val submit: WebElement = driver.findElement(By.xpath("//input[contains(@type, 'submit')]"))
  submit.click()

  // linkText
  val goBack: WebElement = driver.findElement(By.linkText("Go back to the form"))
  goBack.click()


  //    4. Use a different locator strategy for each action:
  //    o One action must use `id`
  val form: WebElement = driver.findElement(By.id("HTMLFormElements"))
  println(form.getText)

  //   o One must use `name`
  val passwordByName: WebElement = driver.findElement(By.name("password"))
  passwordByName.sendKeys("12345name")

  //  o One must use `className`
  val explanation: WebElement = driver.findElement(By.className("explanation"))
  println(explanation.getText)

  //  o One must use `tagName`
  val header1: WebElement = driver.findElement(By.tagName("h1"))
  println(header1.getText)

  //  o One must use `cssSelector`
  val option: WebElement = driver.findElement(By.cssSelector("option[selected='selected']"))
  println(option.getText)
  option.click()

  val option2: WebElement = driver.findElement(By.cssSelector("option[value='ms2']"))
  println(option2.getText)
  option2.click()

  //  o One must use `xpath`
  val dropdown: WebElement = driver.findElement(By.xpath("//option[@value='dd1']"))
  dropdown.click()

  //  o One must use `linkText`
  val index: WebElement = driver.findElement(By.linkText("Index"))
  index.click()

  driver.navigate().back()


  //  o One must use `partialLinkText`
  val partialLink: WebElement = driver.findElement(By.partialLinkText("Compen"))
  partialLink.click()

  driver.quit()


}
