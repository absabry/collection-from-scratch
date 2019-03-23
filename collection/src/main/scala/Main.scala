import scala.annotation.tailrec
import classes.{AbstractList, Empty, List}

object Main extends App {

  def createListintegers(): List[Int] = {
    new List[Int](0,
      new List[Int](1,
        new List[Int](2,
          new List[Int](3, Empty))))
  }
  def createListStrings() : List[String] = {
    new List[String]("Hello world",
      new List[String]("that's awesome",
        new List[String]("Hello you, how are you? I'm " +
          "good how about you? I'm good thank you for asking",
          new List[String]("And that's the end of the list of strings", Empty))))
  }
  def valuesToList(values : Array[String]): AbstractList[String] = {
    /**
      * convert an Array to List
      **/
    @tailrec
    def utils(i:Int = 0, list: AbstractList[String] = Empty) : AbstractList[String]= {
      if (i == values.length -1) list ++ List(values(i), Empty)
      else utils(i+1, list ++ List(values(i), Empty))
    }
    utils()
  }

  val listOfIntegers: List[Int] = createListintegers()
  println("list of integers : " + listOfIntegers)

  val listOfStrings: List[String] = createListStrings()
  println("List of strings: " + listOfStrings)

  println("Even values only : " + listOfIntegers.filter((value: Int) => value % 2 == 0))

  println("Square of list: " + listOfIntegers.map((value: Int) => value * value))

  println("Less than three words only :" + listOfStrings.filter((value: String) => value.split(" ").length <= 3))
  println("Length of each line: " + listOfStrings.map((value: String) => value.length))

  println("concatenate two lists : " + (listOfIntegers ++ listOfIntegers))

  println("flatmap = "+ listOfStrings.flatMap((value: String) => {
    valuesToList(value.split(" "))
  }))

  // check for case classes functionality
  val cloneIntegers = createListintegers()
  println("Are they equal? " + (cloneIntegers == listOfIntegers))

  listOfIntegers.foreach(x => print(x + "-"))
  println() // to restore line break

  val toSort = List(2, List(3, List(1, List(0, List(-5, List(22, Empty))))))
  println("myTesting list : "+ toSort.printElements)
  val sortIncr = (x:Int,y:Int) => y - x
  val sortDesc = (x:Int,y:Int) => x - y
  println("Sortedlist incresing: "+ toSort.sort(sortDesc).printElements)
  println("Sortedlist descreasing: "+ toSort.sort(sortIncr).printElements)


  // TODO implement:
  // -- zipWith(otherList, funtion to execute for each element)
  // -- fold(start)(function) (even if i dont know why we should do it)
  // -- adding combinations with flatmap and maps, then using the same
  //    using for-comprehension

  // TODO implement collection
  // implement Maybe collection
  // implement try if needed?

  // TODO BONUS
  // Transform constructor to apply method??
  // implement fill, zeros and ones on our List
  // implement join("sep") on our List
  // implement Map collection

}
