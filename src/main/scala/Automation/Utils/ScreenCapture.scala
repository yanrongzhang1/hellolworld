package Automation.Utils

import org.openqa.selenium.io.FileHandler
import org.openqa.selenium.{By, OutputType, TakesScreenshot, WebDriver}

import java.io.File
import java.nio.file.Paths
import java.text.SimpleDateFormat
import java.util.Date
class ScreenCapture {
  def screenCapture(driver: WebDriver, directory: String, result: String): Unit = {

    //create new folder dynamically

    val screenshotsDir = new File(directory)

    if (!screenshotsDir.exists())
      screenshotsDir.mkdirs() // Create screenshots directory

//    val timeStamp = new SimpleDateFormat("yyyy-MM-dd_HHmmss").format(new Date())
//    println(timeStamp)

    val timeFormat = s"yyyy-MM-dd-'$result'_HHmmss"
    val timeStamp = new SimpleDateFormat(timeFormat).format(new Date())
    println(timeStamp)

    val srcTimestamp: File = driver.asInstanceOf[TakesScreenshot].getScreenshotAs(OutputType.FILE)
    FileHandler.copy(srcTimestamp, new File(s"$screenshotsDir/$timeStamp.png"))
  }
}
//
//  val element = driver.findElement(By.name("my-disabled")) // Locate the element by its name (update if needed)
//  val srcElement: File = element.getScreenshotAs(OutputType.FILE) // Capture only that element
//  // Save the screenshot of the element
//  FileHandler.copy(srcElement, new File("/Users/yanrong.zhang/Documents/screenshots/TestResult_Specific.png"))
//
//}