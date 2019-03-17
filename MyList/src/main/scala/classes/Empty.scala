package classes


case object Empty extends AbstractList {
  override def head: Nothing = ???

  override def tail: AbstractList[Nothing] = Empty

  override def isEmpty: Boolean = true

  override def add[B >: Nothing](toBeAdded: B): AbstractList[B] = new List[B](toBeAdded, Empty)

  override def printElements: String = ""

  override def filter(myPredicate: Nothing => Boolean): AbstractList[Nothing] = Empty

  override def map[B](myTransformer: Nothing => B ): AbstractList[B] = Empty

  override def ++[B >: Nothing](otherList: AbstractList[B]): AbstractList[B] = otherList

  override def flatMap[B](myTransformer: Nothing => AbstractList[B] ): AbstractList[B] = Empty

  override def foreach(function: Nothing => Unit) : Unit = ()
}
