import classes.Integers.Empty
import classes.Integers.List

object MainIntegers extends App {
  val l = Empty
  println(l)
  println(l.add(0).add(1)) // add two values

  val l_1 = new List(0,
    new List(1,
      new List(2,
        new List(3, Empty))))
  println(l_1)

}
