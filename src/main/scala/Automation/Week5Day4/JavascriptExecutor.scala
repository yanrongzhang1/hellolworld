package Automation.Week5Day4

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.{By, JavascriptExecutor, WebDriver, WebElement}

import java.time.Duration

object JavascriptExecutor extends App {
  //Instantiating the ChromeDriver for interacting with the Chrome Browser
  val driver: WebDriver = new ChromeDriver()

  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10))

  // Accessing the web url for testing
  driver.get("https://proleed.academy/exercises/selenium/selenium-element-id-locators-practice-form.php")
//  driver.manage().window().maximize()


  //  val emailAddress: WebElement = driver.findElement(By.id("email"))
  val emailAddress: WebElement = driver.findElement(By.id("email"))
  emailAddress.sendKeys("test@gmail.com")
  println(("Email address entered - Passed"))

  val password: WebElement = driver.findElement((By.id("password")))
  password.sendKeys("Password123")
  println(("Password entered - Passed"))


  val login: WebElement = driver.findElement(By.id("login"))
  val js = driver.asInstanceOf[JavascriptExecutor]
  js.executeScript("arguments[0].scrollIntoView(true);", login)
  js.executeScript("arguments[0].click()", login)
  println(("Logged in successfully - Passed"))


  val header = driver.findElement(By.tagName("h2")).getText
  assert(header == "Thank You!")


  driver.quit()


}


//val elements = List(element1, element2)
//js.executeScript(
//  """
//  for (let i = 0; i < arguments.length; i++) {
//    arguments[i].scrollIntoView(true);
//  }
//  """,
//  elements: _*
//)