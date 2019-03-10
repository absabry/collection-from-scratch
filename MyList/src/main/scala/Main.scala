import traits.{Predicate, Transformer}
import classes.{Empty, List, AbstractList}

object Main extends App {
 val listOfIntegers: List[Int] =
   new List[Int](0,
     new List[Int](1,
       new List[Int](2,
         new List[Int](3, Empty))))

  println("list of integers : " + listOfIntegers)

  val listOfStrings: List[String] =
    new List[String]("Hello world",
      new List[String]("that's awesome",
        new List[String]("Hello you, how are you? I'm " +
          "good how about you? I'm good thank you for asking",
          new List[String]("And that's the end of the list of strings", Empty))))

  println("list of strings : " + listOfStrings)

  println("Even values only : " + listOfIntegers.filter(new Predicate[Int] {
    override def test(value: Int): Boolean = value % 2 == 0
  }))

  println("Square of list: " + listOfIntegers.map(new Transformer[Int,Int] {
    override def transform(value: Int): Int = value * value
  }))

  println("List of strings: " + listOfStrings)
  println("Less than three words only :" + listOfStrings.filter(new Predicate[String] {
    override def test(value: String): Boolean = value.split(" ").length <= 3
  }))
  println("Length of each line: " + listOfStrings.map(new Transformer[String,Int] {
    override def transform(value: String): Int = value.length
  }))

  println("concatenate two lists : " + (listOfIntegers ++ listOfIntegers))

  println("flatmap = "+ listOfStrings.flatMap(new Transformer[String, AbstractList[String]]{
    def valuesToList(values : Array[String]): AbstractList[String] = {
      /**
        * convert an Array to List
        **/
      def utils(i:Int = 0, list: AbstractList[String] = Empty) : AbstractList[String]= {
        if (i == values.length -1) list ++ new List(values(i), Empty)
        else utils(i+1, list ++ new List(values(i), Empty))
      }
      utils()
    }

    override def transform(value: String): AbstractList[String] = {
      val arr :Array[String] = value.split(" ")
      valuesToList(arr)
    }
  }))


}
