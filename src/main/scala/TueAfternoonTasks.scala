
object TueAfternoonTasks extends App{
  import scala.collection.mutable.Map
//
//  1. Create a `Seq` of taxpayer forenames representing multiple submissions, including
//  some duplicates. Store this `Seq` in a val.
  val taxpayerForenamesSeq : Seq[String] = Seq("Alice", "Alex", "Adam", "Jack", "Alex", "Alex", "Jack")

//  2. Using string interpolation, print the full list of submissions.
  println("List of submissions: " + taxpayerForenamesSeq)


//  3. Write a method that uses the built-in method `.count` to identify how many times a
//  specific taxpayer submitted their tax returns in the `Seq` from question 1. This method
//  should work for any inputted taxpayer.
  def countSubmissionTimes (foreName: String) : Int = {
    taxpayerForenamesSeq.count(_ == foreName )
  }


//  4. Print a sentence that states how many times a specific person submitted their tax
//  returns using your method for question 3.
  println("Number of submissions of Alex is: " + countSubmissionTimes("Alex"))


//  5. Using a built-in method (research will be required here), convert the `Seq` to a `Set` to
//  remove duplicates.
  val taxpayerForenamesSet: Set[String] = taxpayerForenamesSeq.toSet


//  6. Using string interpolation, print the list of unique taxpayers who submitted.
  println("Tax Payer fornames Set: " + taxpayerForenamesSet)


//  7. Refactor your method from question 3 to work for any inputted collection (HINT: look
//    back at the collection family tree in the PowerPoint).
def countSubmissionTimesAnyCollection (foreName: String, collection: Iterable[Any]) : Int = {
  collection.count(_ == foreName )
}



  //  8. Using your method from question 7, print the count of the same taxpayer in both the
//    `Seq` from question 1 and the `Set` from question 5.

  var numSubmissionsSeq = countSubmissionTimesAnyCollection("Alex", taxpayerForenamesSeq)
  println("Number of submissions for Alex in Seq: " + numSubmissionsSeq)

  var numSubmissionsSet = countSubmissionTimesAnyCollection("Alex", taxpayerForenamesSet)
  println("Number of submissions for Alex in Set: " + numSubmissionsSet)

//  9. Imagine that the user of this service needs to login however there are 6 users that have
//    failed login attempts.
//    a. Write a Map[String, Int] to represent the number of failed attempts for each
//  user.
  var failedLoginUsersMap: scala.collection.mutable.Map[String, Int] = scala.collection.mutable.Map(
    "Alex" -> 1,
    "Adam" -> 2,
    "Jack" -> 3,
    "John" -> 1,
    "Emily" -> 5,
    "Joe" -> 3
  )

  var failedLoginUserSeq: Seq[String] = failedLoginUsersMap.keys.toSeq
  println("user seq : " + failedLoginUserSeq)

//    b.  Print the number of failed attempts for the user at index position 0.
  var userAtIndex0 = failedLoginUserSeq.head
  println(s"First user $userAtIndex0, failed attempts:  " + failedLoginUsersMap(userAtIndex0))
//  var user0 = failedLoginUserSeq[0]


//  c. Add a new user to your Map who has 3 failed attempts.
  failedLoginUsersMap += ("Edward" -> 3)
  println("Add Edward to failedLoginMap: " + failedLoginUsersMap)

//    d. Update the user at index position 1 to have a further failed attempt.
//  failedLoginUsersMap("Adam") =  3
  var userAtIndex1 = failedLoginUserSeq(1)
  println(s"Update $userAtIndex1's failed attempts to : " + failedLoginUsersMap(userAtIndex1))

//    e.Remove the user at index position 5.
var userAtIndex5 = failedLoginUserSeq(5)
  failedLoginUsersMap.remove(userAtIndex5)
  println(s"$userAtIndex5 is removed from the map. " + failedLoginUsersMap)


//  Extension:
//    1. Write two `Sets` that detail submissions on day 1 and day 2. (You can use your `Set` from
//    question 5 if you want!)
//  Using built-in `Set` operations (research required here) and print lines, compare two
//    submission days detailing:
 var day1Set: Set[String] = Set("Adam", "Alex", "Edward", "Jack")
 var day2Set: Set[String] = Set("Emma", "Emily", "Alex", "John")

//    a) Who submitted on both days
  println("Submitted on both days: ", day1Set.intersect(day2Set))
//  b) Who submitted only on the first day
  println("Submitted only on the first day: ", day1Set.diff(day2Set))
//  c) A combined list of all unique submitters
  println("All uses submitted only on two days: ", day1Set.union(day2Set))

//  Research:
//    1. Write a short summary explaining how knowing the difference between `Seq` and `Set`
  //    can help when writing tests.
//  Seq: ordered, allow repeated value, get value at index
  //useful when checking something in the right order
  //  Set: unordered, not allow repeated value, get value at index return boolean value which means whether the set contains the value
  //useful when checking if value is unique or if the value exists


//    2. A) Research the difference between the build in methods:
//    i. Map.get
//  The get() method is utilized to give the value associated with the keys of the map. The values are returned here as an Option i.e, either in form of Some or None.

  println("map.get not found, return " + failedLoginUsersMap.get("abc"))
  println("map.get found, return " + failedLoginUsersMap.get("Alex"))
//  ii. Map(key)
  // either throw error if key not found or return the value if key is found
//  println("map(key) not found, return " + failedLoginUsersMap("abc")) // error,code can not run
  println("map(key) found, return " + failedLoginUsersMap("Alex"))
//  iii. Map.getOrElse
  //return default value if key is not found, otherwise return the value
  println("map.getOrElse not found, return " + failedLoginUsersMap.getOrElse("abc", "Not found"))
  println("map.get found, return " + failedLoginUsersMap.getOrElse("Alex", "Not found"))
//  B) Using you Map from MVP Q9, write an example using each of the commands above.
//    C) In testing, when might it be dangerous to use Map(key) directly?
  // if key does not exist, the program will throw error.


}
