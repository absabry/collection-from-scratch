package classes

abstract class AbstractList[+A] {
  def head: A

  def tail: AbstractList[A]

  def isEmpty: Boolean

  def add[B >: A](toBeAdded: B): AbstractList[B]

  def printElements: String

  def count : Int

  def size : Int

  override def toString: String = "[" + printElements + "]"

  def filter(myPredicate: A => Boolean): AbstractList[A]

  def map[B](myTransformer: A => B): AbstractList[B]

  def ++[B >: A](otherList: AbstractList[B]): AbstractList[B] // concatenation of two lists

  def flatMap[B](myTransformer: A => AbstractList[B]): AbstractList[B]

  def foreach(function: A => Unit): Unit

  // sort(function from A to A that will compare)
  def sort(function: (A,A)=> Int) : AbstractList[A]

  //zipWith(otherList, funtion to execute for each element)
  def zipWith[B,R](other:AbstractList[B], function: (A,B)=>R): AbstractList[R]

}
