package classes

abstract class AbstractList[+A] {
  def head: A

  def tail: AbstractList[A]

  def isEmpty: Boolean

  def add[B >: A](toBeAdded: B): AbstractList[B]

  def printElemnts: String

  override def toString: String = "[" + printElemnts + "]"

}
