object WedHandlingMultipleOptions extends App {
  val weather: String = "sunny"

  //IF/ELSE
  if (weather == "rainy") {
    println("Take a coat with a hood")
  } else if (weather == "sunny") { //you can have as many else/if as you need, if long use pattern match
    println("Wear sun cream")
  } else if (weather == "cold") {
    println("Wear a warm coat")
  } else { //catch for anything not defined in the else/if
    println("Not a valid weather option")
  }

  //PATTERN MATCH
  weather match {
    case "rainy" => println("Take a coat with a hood")
    case "sunny" => println("Wear sun cream")
    case "cold" => println("Wear a warm coat")
    case _ => println("Not a valid weather option")
  }


  val season: String = "winter"
  //How we approach this when we have multiple options:
  if (weather == "cold" || season == "winter") {
    println("Take a coat")
  } else {
    println("A light jacket fine")
  }

  (weather, season) match {
    case (weather, season) if weather == "cold" || season == "winter" => println("Take a coat")
    case _ => println("A light jacket fine")
  }


  // INT - slightly more careful
  //val age: Int = 0

  // if (age < 0) {

  //  if (age >= 18){
  //    println(s"You are an adult because you are $age")
  //  } else if( age >= 0 && age < 18){
  //    println(s"You are a child because you are $age")
  //  } else {
  //    println(s"Invalid age")
  //  }
  //  age match {
  //    case age if age >= 18 => println(s"You are an adult because you are $age")
  //    case age if (age >= 0 && age < 18) => println(s"You are a child because you are $age")
  //    case _ => println(s"Invalid age")
  //  }
  //  age match {
  //    case age if age < 0 => println("Enter a positive number")
  //    case age if age  >= 18 => println(s"You are an adult because you are $age")
  //    case age if age < 18 => println(s"You are a child because you are $age")
  //  }
  //

  val givenAge: Int = 18
  givenAge match {
    case age if age < 4 => println("Enter a number above 3")
    case age if age < 8 => println("You can watch U only films")
    case age if age < 12 => println("You can watch U or PG rating films")
    case age if age < 15 => println("You can watch U, PG or 12A rating films")
    case age if age < 18 => println("You can watch U, PG, 12A or 15 rating films")
    case age if age >= 18 => println(s"You can watch U, PG, 12A, 15 or 18 rating films")
  }

  val grade: Int = 49
  if (grade > 100 || grade < 0) {
    println(s"$grade is not valid")
  } else if (grade >= 90) {
    println("Your grade is A")
  }else if (grade >= 80) {
    println("Your grade is B")
  }else if (grade >= 70) {
    println("Your grade is C")
  }else if (grade >= 60) {
    println("Your grade is D")
  }else if (grade >= 50) {
    println("Your grade is E")
  }else if (grade >= 0) {
    println("Your grade is F")
  }

  val studentGrade: Int = 100
  studentGrade match {
    case g if g < 0 || g > 100  => println(s"$grade is not valid")
    case g if g >= 90 => println("Your grade is A")
    case g if g >= 80 => println("Your grade is B")
    case g if g >= 70 => println("Your grade is C")
    case g if g >= 60 => println("Your grade is D")
    case g if g >= 50 => println("Your grade is E")
    case g if g >= 0 => println("Your grade is F")
  }

  // OPTIONS (getOrElse)
  val name: Option[String] = Some("April")
  val emptyName: Option[String] = None
  println(name)
  println(emptyName)

  //getOrElse is used when we want to return a default value if the None is returned.
  //It will also take the Some away, leaving us with just the internals.
  def getName(name: Option[String]): String = name.getOrElse("This user has left the field empty")
  println(getName(name))
  println(getName(emptyName))


  class ChocolateBar(val filling: Option[String]) {
    def getFilling: String = filling.getOrElse("Just chocolate")
  }
  val myChocolateBar1 = new ChocolateBar(Some("Cream") )
  println("Chocolate bar filling is: " + myChocolateBar1.getFilling)
  val myChocolateBar2 = new ChocolateBar(None)
  println("Chocolate bar filling is: " + myChocolateBar2.getFilling)
  //TRY/CATCH
  try {
    //ALL logic - IF/ELSE, PATTERN MATCH, DEF, VAL

    val number = "one".toInt // I want to change the input to a Int from a string
    println(s"The number is $number")
  } catch {
    case error: NumberFormatException => println(s"$error was not a valid input") // often see error as 'e'

  }


}
