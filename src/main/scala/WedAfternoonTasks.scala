object WedAfternoonTasks extends App {
  //  MVP:
  //    1. John from primary school maths is trying to buy as many watermelons as possible and we need to
  //  give him a reality check. John can reasonably carry 3 watermelons without a bag, and 5 with one
  //  bag.
  //    a)  Create a value to store a number of watermelons.
  val numWatermelons: Int = 6
  //    b) Use your Scala knowledge to print appropriate messages based on the criteria above to tell
  //  John whether he:

  if (numWatermelons <= 0) {
    println(s"Invalid number $numWatermelons")
  } else if (numWatermelons <= 3) {
    println(s"Only $numWatermelons watermelons, you don't need a bag.")
  } else if (numWatermelons > 3 && numWatermelons <= 5) {
    println(s"$numWatermelons watermelons, you need a bag!")
  } else if (numWatermelons > 5) {
    println(s"$numWatermelons watermelons, you can't carry them")
  }

  //pattern matching
  numWatermelons match {
    case num if num <= 0 => println(s"Invalid number $num")
    case num if num <= 3 => println(s"$num watermelons, Doesn't need a bag")
    case num if num <= 5 => println(s"$num watermelons, Need a bag")
    case num if num > 5 => println(s"$num watermelons, Can't carry them")
  }

  //    i. Doesn't need a bag
  //    ii. Needs a bag
  //  iii. Can't carry them
  //  Be sure to consider how you will handle invalid numbers.
  //  c) Use string interpolation to add to each message the number of watermelons John is trying to
  //    buy.
  //      d) Create a value to store a
  //    `Boolean` that indicates whether John has a bag with him or not.
  val hasBag: Boolean = false
  //     e) Use an if/else statement and this `Boolean` value to tell John whether he can or cannot by the
  //  desired number of watermelons in Task 1.
  if (numWatermelons <= 0) {
    println(s"Invalid number: $numWatermelons")
  } else if (numWatermelons <= 3) {
    println(s"you can buy $numWatermelons watermelons")
  } else if (numWatermelons <= 5 && hasBag) {
    println(s"you can buy $numWatermelons watermelons")
  } else {
    println(s"you can not buy $numWatermelons watermelons")
  }
  (numWatermelons, hasBag) match {
    case (num, _) if num <= 0 => println(s"Invalid number: $num")
    case (num, _) if num <=3 => println(s"you can buy $num watermelons")
    case (num, bag) if num <= 5 && bag => println(s"you can buy $num watermelons")
    case num => println(s"you can not buy $num watermelons")
  }

  //  2. A person is paid £0.45 per mile travelled. When they input their miles travelled it goes in as a
  //  `String` (e.g. “twenty”). Given the distance inputted, calculate the amount to be paid back being
  //    sure to use try/catch to account for errors.
  val miles = "twenty"
  try {
    val moneyToPay = miles.toInt * 0.45
  }
  catch {
    case e: NumberFormatException => println(s"$e was not a valid input")
  }



  //    Extension:
  //    Logical operators used in IF statements (e.g., && or <) have an order of precedence.
  //  1. What is this order, where can we find it?
  //https://www.tutorialspoint.com/scala/rules_for_operators_in_scala.htm
  //  Category	Operator	Associativity
  //  Postfix	() []	Left to right
  //    Unary	! ~	Right to left
  //  Multiplicative	* / %	Left to right
  //  Additive	+ -	Left to right
  //  Shift	>> >>> <<	Left to right
  //  Relational	> >= < <=	Left to right
  //    Equality	== !=	Left to right
  //    Bitwise AND	&	Left to right
  //    Bitwise XOR	^	Left to right
  //    Bitwise OR	|	Left to right
  //    Logical AND	&&	Left to right
  //    Logical OR	||	Left to right
  //    Assignment	= += -= *= /= %= >>= <<= &= ^= |=	Right to left
  //  Comma	,	Left to right

  //    Let's try to apply it, try to predict the answer before coding it:
  //    2. What would (true || false && false) result in?
  val example1: Boolean = true || false && false //true
  println("Example 1, expected true: " + example1)

  //    3.  What about ((true || false) && false)? (Note the parentheses used here.)
  val example2: Boolean = (true || false) && false //false
  println("Example 2, expected false: " + example2)

  //  4. And finally, how about (1 < 4 && 7 != 10 || 9 + 10 == 21)?
  val example3: Boolean = 1 < 4 && 7 != 10 || 9 + 10 == 21 //true
  println("Example 3, expected true: " + example3)
  //    Research:
  //    If statements always return values. This means we can assign values based on if statements.
  //    How would we go about doing this, or where could we search to find out?
  //https://docs.scala-lang.org/overviews/scala-book/if-then-else-construct.html
  //  Try out the example below:
  //    1. Create two values that hold integers. Assign any integer you'd like to these values.
  val num1: Int = 8
  val num2: Int = 7
  //    2. Create a new value of type `String` and assign it "yes" if the first value is greater than the second,
  //  and "no" if the second value is greater. (Don’t overthink this!)
  val greaterThan: String = if (num1 > num2) "yes" else "no"
  println(s"Num 1 is greater than num 2, yes or no: $greaterThan")


}
