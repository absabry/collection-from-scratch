package classes.Integers

abstract class AbstractList {
  def head: Int

  def tail: AbstractList

  def isEmpty: Boolean

  def add(toBeAdded: Int): AbstractList

  def printElements: String

  override def toString: String = "[" + printElements + "]"
}
