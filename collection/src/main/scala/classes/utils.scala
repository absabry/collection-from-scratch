package classes

import scala.annotation.tailrec
import scala.util.Random

object utils {

  def createListintegers(): List[Int] = {
    new List[Int](0,
      new List[Int](1,
        new List[Int](2,
          new List[Int](3, Empty))))
  }

  def createListStrings(): List[String] = {
    new List[String]("Hello world",
      new List[String]("that's awesome",
        new List[String]("Hello you, how are you? I'm " +
          "good how about you? I'm good thank you for asking",
          new List[String]("And that's the end of the list of strings", Empty))))
  }

  /**
    * convert an Array to List
    **/
  def valuesToList(values: Array[String]): AbstractList[String] = {
    @tailrec
    def utils(i: Int = 0, list: AbstractList[String] = Empty): AbstractList[String] = {
      if (i == values.length - 1) list ++ List(values(i), Empty)
      else utils(i + 1, list ++ List(values(i), Empty))
    }

    utils()
  }

  /**
    * Create a List containing value N times
    */
  def fill[A](size: Int = 1, value: A): AbstractList[A] = {
    if (size == 0) Empty
    else List(value, fill(size - 1, value))
  }


  /**
    * Create a list with values from START to TO.
    *
    * @param start value to begin with
    * @param to    value to finish at
    * @return List[Int]
    */
  def createList(start: Int, to: Int): AbstractList[Int] = {
    if (start == to) List(start, Empty)
    else if (start > to) throw new RuntimeException("WARN: start value is greater than to value")
    else List(start, createList(start + 1, to))
  }


  /**
    * Create a list with chars from START to TO.
    *
    * @param start value to begin with
    * @param to    value to finish at
    * @return List[Int]
    */
  def createList(start: Char, to: Char): AbstractList[Char] = {

    // get the next letter if exists
    def nextLetter(letter: Char): Option[Char] = {
      val validChars = ('a' to 'y') ++ ('A' to 'Y')
      if (validChars contains letter)
        Some((letter + 1).toChar)
      else if (letter.isLower) Some('a') else Some('A') //  restore the suite
    }

    def utils(_start: Option[Char]): AbstractList[Char] = {
      if (_start.head == to) List(_start.head, Empty)
      else List(_start.head, utils(nextLetter(_start.head)))
    }

    if (start.isLower == to.isLower) utils(Some(start))
    else throw new RuntimeException("Start and To doesn't have " +
      "the same case. I don't know what to do...")
  }

  val r: Random.type = scala.util.Random

  def createRandomList(size: Int, limit: Int = 9999, lowerCase:Boolean=true): AbstractList[Int] = {
    if (size == 0) Empty
    else List(r.nextInt(limit), createRandomList(size - 1))
  }

  //r.nextPrintableChar

}
