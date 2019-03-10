package classes

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


}
