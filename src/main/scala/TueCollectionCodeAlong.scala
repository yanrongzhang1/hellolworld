object TueCollectionCodeAlong extends App {

  val firstSet: Set[Int] = Set(1, 2, 3, 4, 5, 5) //Not ordered, does not allow repeats
  println("First set: " + firstSet)

  val firstSeq: Seq[Int] = Seq(1, 2, 3, 4, 5, 5) //Ordered, allow repeat values
  println("First seq: " + firstSeq)

  //Map take 2 parameters (Key -> Value). We call these Key Value pairs. Key must be unique ( we cannot have 2 keys that are the same).
  val firstMap: Map[String, Int] = Map(
    "one" -> 1,
    "two" -> 2,
    "three" -> 3,
    "four" -> 4,
    "five" -> 5,
    "five" -> 5 // will remove when compiled (doesn't throw and error)
  )

  println("First Map: " + firstMap)

  // Accessing data
  val getSeqHead: Int = firstSeq.head //index position 0 (first element)
  println("Seq Head: " + getSeqHead)
  val getSeqTail: Seq[Int] = firstSeq.tail //Everything BUT the head
  println("Seq Tail: " + getSeqTail)
  val getSeqIndex: Int = firstSeq(3) // only works with ordered collections
  println("Seq Index : " + getSeqIndex)

  //SET
  val getSetIndex: Boolean = firstSet(30) //CHECK IS THE VALUE IS contained in the Set ( can also use .contains) firstSet.contains(30)
  println("Exist in Set: " + getSetIndex)
  //Often filter for information
  val filterSet: Set[Int] = firstSet.filter(_ < 3)
  println("filterSet: " + filterSet)

  val filterNotSet: Set[Int] = firstSet.filterNot(_ < 3)
  println("FilterNot set: " + filterNotSet)

  val evenSet: Set[Int] = firstSet.filter(_ % 2 == 0)
  println("Even set: " + evenSet)


  //Map
  val getMapValue: Int = firstMap("one") //Enter key to get the value. Only works this way round.
  println("Get Map Value: " + getMapValue)

  //find(number => number._2 == 1) (number => number same as _)
  val getMapKey: String = firstMap.find(_._2 == 3).get._1 // find the value that is equal to 1 and get the key that matches it.
  println("Get Map Key: " + getMapKey)


  val nameSeq: Seq[String] = Seq("Alex", "Adam", "Jane", "Emily")
  println("Name seq: ", nameSeq)

  val colourMap: Map[Int, String] = Map(
    1 -> "red",
    2 -> "yellow",
    3 -> "blue",
    4 -> "green"
  )
  val blue = colourMap.find(_._2 == "blue").get._1
  println("Colour blue: " + blue)


  val numberSet: Set[Int] = Set(1, 2, 5, 6, 8, 10)
  val hightThanTwoSet = numberSet.filter(_ > 2)
  println("Higher than 2 set: ", hightThanTwoSet)

  //map (method = lowercase 'm')
  //use a map to iterate (move through) a collection
  def tripledSet(inputSet: Set[Int]): Set[Int] = inputSet.map {
    //    _ * 3  - this is the same as below
    number => number * 3
  }

  println("Triple Set: " + tripledSet(firstSet))


  def tripledSeq(inputSeq: Seq[Int]): Seq[Int] = inputSeq.map {
    //    _ * 3  - this is the same as below
    number => number * 3
  }

  println("Triple Seq: " + tripledSeq(firstSeq))


  def tripledMap(inputMap: Map[String, Int]): Map[String, Int] = inputMap.map {
    //    _ * 3  - this is the same as below
    case (key, value) => (key + "s", value * 3) //can also change the key, e.g., key + "s"
  }

  println("tripledMap: " + tripledMap(firstMap))


  //.exists = all that could be (get colleciton back)
  //.contains (check - true/false - boolean)

  def addOneSet(inputSet: Set[Int]): Set[Int] = inputSet.map {
    _ + 1
  }

  //def checkContainsLetterR(inptSeq:Seq[String])] :Boolean =
  //nameSeq.exists(word => word.contains('r'))
  //
  //  val oddNumberOnly = firstset.filter{
  //    number => number %2 != 0
  //  }
  //
  //  val containsR:Boolean = names.exists(name => name.contains("r"))
  //}

  val flatMapNames: Seq[Char] = nameSeq.flatMap(_.toUpperCase) //get letter out of list
  println("FlatMap: " + flatMapNames)


  val newSeq: Seq[Int] = Seq(6, 7, 8)
  //Append - add to end
  val appendedListOne = firstSeq :+ newSeq

  println("Append :+ " + appendedListOne)
  val appendListTwo = firstSeq ++ newSeq
  println("Append ++" + appendListTwo)

  //Prepend
  val prependSeqOne = newSeq ++ firstSeq
  println("Prepend ++ " + prependSeqOne)

  val prependSeqTwo = newSeq +: firstSeq
  println("Prepend +: " + prependSeqTwo)

  val prependValue = 6 +: firstSeq
  println(prependValue)

  //prependSeqTwo.flatMap(_+1)
}
