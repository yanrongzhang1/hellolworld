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
    case age if age < 8 => println("You can watch U rating films")
    case age if age < 12 => println("You can watch 12A rating films")
    case age if age < 15 => println("You can watch 15 rating films")
    case age if age >= 18 => println(s"You can watch 18 rating films")
  }

  val grade: Double = 90
  if (grade > 100) {
    println("Enter a number greater than 0")
  } else if (grade >= 90) {

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

  //TRY/CATCH
  try {
    //ALL logic - IF/ELSE, PATTERN MATCH, DEF, VAL

    val number = "one".toInt // I want to change the input to a Int from a string
    println(s"The number is $number")
  } catch {
    case error: NumberFormatException => println(s"$error was not a valid input") // often see error as 'e'

  }


}
