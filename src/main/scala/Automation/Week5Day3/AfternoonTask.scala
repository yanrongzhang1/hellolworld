package Automation.Week5Day3

import org.openqa.selenium.{By, WebDriver, WebElement}
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.{ExpectedConditions, Select, WebDriverWait}

import java.time.Duration

object AfternoonTask extends App {

  val driver: WebDriver = new ChromeDriver()

  // wait

  //      driver.manage.timeouts.implicitlyWait(duration)
  //  1. Navigate to the site: https://testpages.herokuapp.com/styled/index.html
  //  • Once here, maximise the page.
  driver.get("https://testpages.herokuapp.com/styled/index.html")
  driver.manage().window().maximize()

  //  2. Handle Text Boxes:
  //  • Go to the "HTML Form Example" page.
  //  • Fill in the username and password fields.
  val htmlForm: WebElement = driver.findElement(By.cssSelector("a[href*='basic-html-form']"))
  htmlForm.click()
  println("Go to HTML Form Example Page")

  val username: WebElement = driver.findElement(By.cssSelector("input[name='username']"))
  username.sendKeys("username")
  println("Fill in username")

  val password: WebElement = driver.findElement(By.cssSelector("input[name='password']"))
  password.sendKeys("password")
  println("Fill in password")


  //  3. Handle Checkbox:
  //  • Locate a checkbox.
  //  • Select the checkbox located if not already selected.
  val checkbox1: WebElement = driver.findElement(By.xpath("//input[@value='cb1']"))
  if (!checkbox1.isSelected) {
    checkbox1.click()
    println("CheckBox1 has been selected")
  }

  //  4. Handle Radio Buttons:
  //  • Select a radio option.
  val radio3: WebElement = driver.findElement(By.cssSelector("input[value='rd3']"))
  if (!radio3.isSelected) {
    radio3.click()
    println("radio 3 has been selected")
  }

  //  5. Handle Dropdown/Select:
  //  • Choose an option from the dropdown.
  val selectValues: WebElement = driver.findElement(By.name("multipleselect[]"))
  val select = new Select(selectValues)
  select.selectByVisibleText("Selection Item 3")
  println("Select by visible text - " + select.getFirstSelectedOption.getText)

  val dropdown: WebElement = driver.findElement(By.name("dropdown"))
  val selectDropDown = new Select(dropdown)
  selectDropDown.selectByValue("dd5")
  println("Select by value - " + selectDropDown.getFirstSelectedOption.getText)

  //  6. Handle Buttons:
  //  • Click the "Submit" button.
  val submit: WebElement = driver.findElement(By.cssSelector("input[type='submit']"))
  submit.click()
  println("Form has been submitted")

  //  7. Handle Links:
  //  • Click a link to return to the homepage.
  //explicit wait
  val wait1: WebDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30))
  wait1.until(ExpectedConditions.titleContains("Processed"))
  val goback: WebElement = driver.findElement(By.cssSelector("a#back_to_form"))
  goback.click()
  println("Go back to form")

  driver.quit()
}
