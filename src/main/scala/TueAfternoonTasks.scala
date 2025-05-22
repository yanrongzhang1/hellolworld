//import scala.collection.mutable

object TueAfternoonTasks extends App {

//  import scala.collection.mutable.Map

  //
  //  1. Create a `Seq` of taxpayer forenames representing multiple submissions, including
  //  some duplicates. Store this `Seq` in a val.
  val taxpayerForenamesSeq: Seq[String] = Seq("Alice", "Alex", "Adam", "Jack", "Alex", "Alex", "Jack")

  //  2. Using string interpolation, print the full list of submissions.
  println("List of submissions: " + taxpayerForenamesSeq)


  //  3. Write a method that uses the built-in method `.count` to identify how many times a
  //  specific taxpayer submitted their tax returns in the `Seq` from question 1. This method
  //  should work for any inputted taxpayer.
  def countSubmissionTimes(foreName: String): Int = {
    taxpayerForenamesSeq.count(_ == foreName)
  }


  //  4. Print a sentence that states how many times a specific person submitted their tax
  //  returns using your method for question 3.
  println("Alex, Number of submissions is: " + countSubmissionTimes("Alex"))


  //  5. Using a built-in method (research will be required here), convert the `Seq` to a `Set` to
  //  remove duplicates.
  val taxpayerForenamesSet: Set[String] = taxpayerForenamesSeq.toSet


  //  6. Using string interpolation, print the list of unique taxpayers who submitted.
  println("Tax Payer forenames Set: " + taxpayerForenamesSet)


  //  7. Refactor your method from question 3 to work for any inputted collection (HINT: look
  //    back at the collection family tree in the PowerPoint).
  def countSubmissionTimesAnyCollection(foreName: String, collection: Iterable[Any]): Int = {
    collection.count(_ == foreName)
  }

  //  8. Using your method from question 7, print the count of the same taxpayer in both the
  //    `Seq` from question 1 and the `Set` from question 5.

  val numSubmissionsSeq = countSubmissionTimesAnyCollection("Alex", taxpayerForenamesSeq)
  println("Alex, Number of submissions in Seq: " + numSubmissionsSeq)

  val numSubmissionsSet = countSubmissionTimesAnyCollection("Alex", taxpayerForenamesSet)
  println("Alex, Number of submissions in Set: " + numSubmissionsSet)

  //  9. Imagine that the user of this service needs to login however there are 6 users that have
  //    failed login attempts.
  //    a. Write a Map[String, Int] to represent the number of failed attempts for each
  //  user.
//  var failedLoginUsersMap: scala.collection.mutable.Map[String, Int] = scala.collection.mutable.Map(
  //var failedLoginUsersMap: mutable.Map[String, Int] = mutable.Map(
  val failedLoginUsersMap: Map[String, Int] = Map(
    "Alex" -> 1,
    "Adam" -> 2,
    "Jack" -> 3,
    "John" -> 1,
    "Emily" -> 5,
    "Joe" -> 3
  )

  val failedLoginUserSeq: Seq[String] = failedLoginUsersMap.keys.toSeq
  println("user seq : " + failedLoginUserSeq)

  //    b.  Print the number of failed attempts for the user at index position 0.
  val userAtIndex0 = failedLoginUserSeq.head
  println(s"First user: $userAtIndex0, failed attempts:  " + failedLoginUsersMap(userAtIndex0))
  println(failedLoginUsersMap.toSeq.head._2)
  //  var user0 = failedLoginUserSeq[0]


  //  c. Add a new user to your Map who has 3 failed attempts.
//  failedLoginUsersMap += ("Edward" -> 3)
//  println("Add Edward to failedLoginMap: " + failedLoginUsersMap)
  val updateUsersMap: Map[String, Int] = failedLoginUsersMap + ("Edward" -> 3)
  println("UpdateUsersMap = " + updateUsersMap)

  //    d. Update the user at index position 1 to have a further failed attempt.
  //  failedLoginUsersMap("Adam") =  3
//  val userAtIndex1 = failedLoginUserSeq(1)
//  failedLoginUsersMap(userAtIndex1) = failedLoginUsersMap(userAtIndex1) + 1
//  println(s"Update $userAtIndex1's failed attempts to : " + failedLoginUsersMap(userAtIndex1))
  val userAtIndex1:String = failedLoginUsersMap.toSeq(1)._1
  val updatedFailedLoginUsersMap:Map[String, Int] = failedLoginUsersMap.updated(userAtIndex1, failedLoginUsersMap(userAtIndex1) + 1)
  println("Update user at index 1: " + updatedFailedLoginUsersMap)
  //    e.Remove the user at index position 5.
  val userAtIndex5:String = failedLoginUsersMap.toSeq(5)._1
  val removeUserAtIndex5: Map[String, Int] = failedLoginUsersMap - userAtIndex5
  println(s"$userAtIndex5 is removed from the map. " + removeUserAtIndex5)


  //  Extension:
  //    1. Write two `Sets` that detail submissions on day 1 and day 2. (You can use your `Set` from
  //    question 5 if you want!)
  //  Using built-in `Set` operations (research required here) and print lines, compare two
  //    submission days detailing:
  val day1Set: Set[String] = Set("Adam", "Alex", "Edward", "Jack")
  val day2Set: Set[String] = Set("Emma", "Emily", "Alex", "John")

  //    a) Who submitted on both days
  println("Submitted on both days: " +  day1Set.intersect(day2Set))
  //  b) Who submitted only on the first day
  println("Submitted only on the first day: " + day1Set.diff(day2Set))
  //  c) A combined list of all unique submitters
  println("All users submitted on two days: " + day1Set.union(day2Set))

  //  Research:
  //    1. Write a short summary explaining how knowing the difference between `Seq` and `Set`
  //    can help when writing tests.
  //  Seq: ordered, allow repeated value, get value at index
  //useful when checking something in the right order
  //  Set: unordered, not allow repeated value, get value at index return boolean value which means whether the set contains the value
  //useful when checking if the value exists


  //    2. A) Research the difference between the build in methods:
  //    i. Map.get
  //  The get() method is utilized to give the value associated with the keys of the map. The values are returned here as an Option i.e, either in form of Some or None.

  println("map.get not found, return " + failedLoginUsersMap.get("abc"))
  println("map.get found, return " + failedLoginUsersMap.get("Alex"))
  //  ii. Map(key)
  // either throw error if key not found or return the value if key is found
  //  println("map(key) not found, return " + failedLoginUsersMap("abc")) // error, code can not run
  println("map(key) found, return " + failedLoginUsersMap("Alex"))
  //  iii. Map.getOrElse
  //return default value if key is not found, otherwise return the value
  println("map.getOrElse not found, return " + failedLoginUsersMap.getOrElse("abc", "Not found"))
  println("map.get found, return " + failedLoginUsersMap.getOrElse("Alex", "Not found"))
  //  B) Using you Map from MVP Q9, write an example using each of the commands above.
  //    C) In testing, when might it be dangerous to use Map(key) directly?
  // if key does not exist, the program will throw error.





//answers

  // MVP
  // 1. Seq of forenames:
  val taxpayerForenames: Seq[String] = Seq("April", "Chay", "April", "Andy", "Anjali")

  // 2. Print full list:
  println(s"Full list of taxpayer submissions: $taxpayerForenames")

  // 3. Count submissions by April:
  def nameCount(inputName: String): Int = taxpayerForenames.count(name => name == inputName)

  // 4. Print the amount of times a specific person submitted:
  println("April submitted " + nameCount("April") + " times.")

  // 5. Convert to Set to remove duplicates:
  val uniqueTaxpayers: Set[String] = taxpayerForenames.toSet

  // 6. Unique list:
  println(s"Unique taxpayers: $uniqueTaxpayers")

  // 7. Refactor counting method to count for any inputted collection:
  def nameCountRefactor(x: String, forenames: Iterable[String]): Int = forenames.count(name => name == x)

  // 8. Print the count submissions by April in the Seq and Set:
  println("I'm counting 'April' in the Seq: " + nameCountRefactor("April", taxpayerForenames))
  println("I'm counting 'April' in the Set: " + nameCountRefactor("April", uniqueTaxpayers))

  //9a.Write a Map[String, Int] to represent the number of failed attempts for each user.
  val failedLogins: Map[String, Int] = Map(
    "april" -> 2,
    "anjali" -> 1,
    "chay" -> 0,
    "andy" -> 4,
    "paige" -> 1,
    "joe" -> 2
  )
  //9b. Print the number of failed attempts for the user at index position 0.
  val firstUserFailedAttempts: Int = failedLogins.toSeq.head._2 //if i didn't convert to a Seq the Map would be unordered and index(0) would change.
  println("User at index 0 failed login numbers is: " + firstUserFailedAttempts)
  //9c.
  val updatedUser: Map[String, Int] = failedLogins + ("sue" -> 3)
  println(updatedUser)
  // 9d. Update the user at index position 1 to have a further failed attempt.
  val userAtIndex_1: String = failedLogins.toSeq(1)._1
  val updatedLogins: Map[String, Int] = failedLogins.updated(userAtIndex_1, failedLogins(userAtIndex_1) + 1)
  println("Update user at Index 1 " + updatedLogins)
  //9e. Remove the user at index position 5.
  val userAtIndex_5: String = failedLogins.toSeq(5)._1
  val removeIndex_5: Map[String, Int] = failedLogins - userAtIndex_5
  println(removeIndex_5)


  //Extension
  // 1. 2 Sets:
  val day1Submissions: Set[String] = Set("Chay", "Andy", "Anjali")
  val day2Submissions: Set[String] = Set("April", "Chay", "Andy")
  // a. Who submitted on both days
  val bothDays = day1Submissions intersect day2Submissions
  println(s"Submitted on both days: $bothDays")
  // b. Who submitted only on the first day
  val onlyDay1 = day1Submissions diff day2Submissions
  println(s"Only submitted on Day 1: $onlyDay1")
  val onlyDay2 = day2Submissions diff day1Submissions //extra: second day only. Notice the only change is the order.
  println(s"Only submitted on Day 2: $onlyDay2")
  // c. A combined list of all unique submitters
  val allSubmitters = day1Submissions union day2Submissions
  println(s"All unique submitters: $allSubmitters")

  //Research:
  /** Research task 1:
   * Understanding Set vs Seq is important for testers because the choice affects how tests behave. For example, if a test is checking a list of results where order matters, Seq is the right choice. But if the goal is just to verify uniqueness or membership, a Set is safer and clearer. Using the wrong type can lead to false negatives in tests (e.g., failing because order changed but data is correct). It also helps when setting up test data — avoiding duplicates can prevent subtle bugs. Knowing this lets testers write better, more reliable tests and understand developer intentions more clearly.
   */

  //2a/b.i. Map.get - returns an option, you either get it (Some) or you don't (None). This makes it safe to use when a key might not exist.
  println(failedLogins.get("andy")) //returns the value of the inputted key wrapped in a `Some`
  println(failedLogins.get("sarah")) //not in the list so returns a None
  //2a/b.ii. Map(key) - returns the value directly for the inputted key. Will throw an exception if it isn't there (not as safe).
  println(failedLogins("andy")) //returns the value of the inputted key
  //  println(failedLogins("sarah")) //throws an exception and cannot continue code execution
  //2a/b.iii. Map.getOrElse(key, default) - this means if the key isn't there it will return the default value that is given.
  println(failedLogins.getOrElse("andy", 0))
  println(failedLogins.getOrElse("sarah", 0))

  //2c. In testing, when might it be dangerous to use Map(key) directly?
  /** Using Map(key) is dangerous to use in test as a missing key will cause your code to throw a NoSuchElementException, which could:
   * 1. Crash your test suite
   * 2. Mask other issues by stopping execution
   * 3. Create flaky tests that only fail in some environments
   * Always best to use getOrElse
   */

}

