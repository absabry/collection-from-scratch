package classes.Integers

object Empty extends AbstractList {
  override def head: Int = ???

  override def tail: AbstractList = Empty

  override def isEmpty: Boolean = true

  override def add(toBeAdded: Int): AbstractList = new List(toBeAdded, Empty)

  override def printElements: String = ""
}
