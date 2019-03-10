package classes

object Empty extends AbstractList {
  override def head: Nothing = ???

  override def tail: AbstractList[Nothing] = Empty

  override def isEmpty: Boolean = true

  override def add[B >: Nothing](toBeAdded: B): AbstractList[B] = new List[B](toBeAdded, Empty)

  override def printElemnts: String = ""

}
