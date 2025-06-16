package Automation.Week5Day4

import org.openqa.selenium.{By, Keys, WebDriver, WebElement}
import org.openqa.selenium.chrome.{ChromeDriver, ChromeOptions}
import org.openqa.selenium.interactions.Actions

object Research extends App {

  //  To upload a file in Selenium, the primary method is using the sendKeys() method on the file input element, which is an input element with the type="file" attribute. Selenium handles this directly, without needing to simulate native OS actions. For Java, you would typically use the findElement method to locate the file input element, then use sendKeys to provide the file path.


  val chromOptions: ChromeOptions = new ChromeOptions()
  chromOptions.addArguments("--headless=new");
  val prefs: Map[String, String] = Map (
    "download.default_directory" -> "Documents",
    "savefile.default_directory"-> "Documents"
  )
  chromOptions.setExperimentalOption("prefs", prefs)
  val driver: WebDriver = new ChromeDriver(chromOptions)

  driver.get("https://www.selenium.dev/selenium/web/web-form.html")
  val fileInput: WebElement = driver.findElement(By.name("my-file"))
  fileInput.sendKeys("/Users/yanrong.zhang/Downloads/test.txt.pages")


  //download - need to set chrome options
  //  ChromeOptions options = new ChromeOptions();
  //  Map<String, Object> prefs = new HashMap<String, Object>();
  //  prefs.put("download.default_directory", "/directory/path");
  //  options.setExperimentalOption("prefs", prefs);

//  driver.navigate().to("https://www.w3schools.com/howto/tryit.asp?filename=tryhow_html_download_link")
//  val imageLink: WebElement = driver.findElement(By.tagName("a"))
  //  imageLink.click()
  driver.navigate().to("https://demoqa.com/upload-download")
  val downloadbtn: WebElement = driver.findElement(By.id("downloadButton"))
  downloadbtn.click()

  //Actions

  //  1. What is the Selenium Actions class, and why is it used?
  //  • Explain its purpose and the types of user interactions it supports.
  //Actions class can be used to perform complex user interactions like drag n drop, double click etc.
  // click, sendKeys, clickAndHold

  //  What is the difference between Actions Class and Action Class in Selenium?
  //  With the above explanations of Actions Class & Action Class, we can now conclude that Actions is a class that is based on a builder design pattern.  This is a user-facing API for emulating complex user gestures.
  //
  //  Whereas Action is an Interface which represents a single user-interaction action. It contains one of the most widely used methods perform().
  //   2.  List and describe at least five commonly used methods in the Actions class.
  //  • Provide example scenarios where each method would be useful.
  //KeyDown(element, Keys.SHIFT).sendKeys("abc").keyUp(Keys.SHIFT)
  //  Now, build this sequence using the build() method of Actions class and get the composite action. Build method generates a composite action containing all actions so far which are ready to be performed.
  //
  //    Action action = actions.build();
  //  action.perform()

  //  Different Methods for performing Keyboard Events:
  //    keyDown(modifier key): Performs a modifier key press.
  //  sendKeys(keys to send ): Sends keys to the active web element.
  //  keyUp(modifier key): Performs a modifier key release.
  //  Different Methods for performing Mouse Events:
  //    click(): Clicks at the current mouse location.
  //  doubleClick(): Performs a double-click at the current mouse location.
  //  contextClick() : Performs a context-click at middle of the given element.
  //  clickAndHold(): Clicks (without releasing) in the middle of the given element.
  //  dragAndDrop(source, target): Click-and-hold at the location of the source element, moves to the location of the target element
  //    dragAndDropBy(source, xOffset, yOffset):  Click-and-hold at the location of the source element, moves by a given offset
  //  moveByOffset(x-offset, y-offset): Moves the mouse from its current position (or 0,0) by the given offset
  //    moveToElement(toElement): Moves the mouse to the middle of the element
  //  release(): Releases the depressed left mouse button at the current mouse location

  driver.get("https://demoqa.com/buttons")
  val rightClickBtn: WebElement = driver.findElement(By.id("rightClickBtn"))
  val doubleClickBtn: WebElement = driver.findElement(By.id("doubleClickBtn"))
  val action1: Actions = new Actions(driver)
  action1.contextClick(rightClickBtn).perform()
  action1.doubleClick(doubleClickBtn).perform()
  driver.get("https://demoqa.com/droppable/")
  val drag: WebElement = driver.findElement(By.cssSelector("#draggable"))
  val drop: WebElement = driver.findElement(By.cssSelector("#droppable"))
  action1.dragAndDrop(drag, drop).perform()

  driver.get("https://www.selenium.dev/selenium/web/web-form.html")
  val textInput: WebElement = driver.findElement(By.name("my-text"))
  action1.keyDown(textInput, Keys.SHIFT).sendKeys("abc").keyUp(Keys.SHIFT).perform()

  //   3.  How do you chain multiple actions together using the Actions class?
  //  • Write a small code snippet (in Scala) demonstrating a chain of actions.
  //  4. What is the difference between `click()` and `moveToElement(element).click()`? Why might
  //  you use one over the other?

//  moveToElement method is mostly used to simulate mouse hover actions over such elements to make it visible, which can later be interacted with.


  //  5. Explain how you would perform a drag-and-drop operation using the Actions class. Include
  //  sample code if possible.
  //  6. How does the Actions class handle elements that are not visible or are covered by other
  //    elements? What exceptions might occur, and how can they be handled?
//use javascript execute to scroll into the view and then perform actions

  //  7. Can the Actions class be used effectively in headless browser mode?
  //  • Discuss any limitations or considerations.
  //yes

//  While moveToElement is generally supported, it might not always behave as expected in a headless browser, especially when dealing with complex layouts or interactions. In some cases, it may be necessary to adjust the viewport size or use other techniques to ensure proper element positioning.
//difficult to do visual verification
  //javascript execution might behave differently
  //  8. Research the use of TouchActions in Selenium.
  //  • How is it related to the Actions class, and when would you use it?
// Chain touch actions:
  // create an action instance Use methods like clickAndHold(), moveToLocation(), release(), perform() to construct a sequence of touch actions.
  //  9. Investigate the difference between `moveToElement()` and `moveByOffset()`
  //.
  //  • Provide examples of when each is appropriate.
  //moveByOffset does not reference any element, just move to a new positon relative to the current position.
  // for example, dragging something to a new positon
  //  10. Find a real-world example where the Actions class helped solve a complex UI interaction
  //  problem.
  // • Summarize the problem and how the Actions class was used to solve it.
  //when hovering over an element, a sub menu appear and user can choose from it.



}
