package classes

abstract class AbstractList[+A] {
  def head: A

  def tail: AbstractList[A]

  def isEmpty: Boolean

  def add[B >: A](toBeAdded: B): AbstractList[B]

  def printElements: String

  override def toString: String = "[" + printElements + "]"

  def filter(myPredicate: A => Boolean): AbstractList[A]

  def map[B](myTransformer: A => B): AbstractList[B]

  def ++[B >: A](otherList: AbstractList[B]): AbstractList[B] // concatenation of two lists

  def flatMap[B](myTransformer: A => AbstractList[B]): AbstractList[B]

  def foreach(function: A => Unit): Unit = Unit

}
