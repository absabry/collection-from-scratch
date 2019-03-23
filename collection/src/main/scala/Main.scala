
import classes.utils._
import classes.{Empty, List}

object Main extends App {



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

  println("count of list (tailrec way): "+ toSort.count)
  println("size of list (not a tailrec way)   : "+ toSort.count)

  val newList = List(1, List(2, List(3, List(4,Empty))))
  println(s"zipping this two lists  $newList - $listOfStrings : ")
  println(newList.zipWith(listOfStrings, (x:Int,y:String) => x + "-" + y))

  println(fill(10,0)) // create a list of 10 zeros
  println(fill(10,10)) // create a list of 10 tens
  val helloworlds = fill(100,"Hello World")
  println(helloworlds)
  println(helloworlds.size)


  // print all combinations between two lists
  val numbers = List[Int](1,
     List[Int](2,
       List[Int](3,
         List[Int](4,
          Empty))))
  val chars = List[Char]('a',
    List[Char]('b',
      List[Char]('c',
        List[Char]('d',
          Empty))))

  val colors = List[String]("black",
    List[String]("white",
      Empty))

  // "iterating"
  val combinations = numbers.filter(_ % 2 == 0)
    .map(n => chars.filter(_ >= 'c')
      .map(c => colors
        .map(color => s"$c$n-$color")))
  println(combinations)

  // for-comprehensions
  // used to make "iterating" part easier
  // and more comprehensive
  val forCombinations = for {
    n <- numbers.filter(_ % 2 == 0)
    c <- chars.filter(_ >='c')
    color <- colors
  } yield s"$c$n-$color"
  println(forCombinations)

  //val listTest: List[String] = createRndList(10)
  println("List from 1 to 100: " + createList(1,100))
  println("List with 10 random values: " + createRandomList(10))
  println("List with 5 random values: " + createRandomList(5))
  println("List from a to z: " + createList('a','z'))
  println("List from A to D: " + createList('A','D'))
  println("List from X to C: " + createList('X','C'))

  // implement join("sep") on our List

}
