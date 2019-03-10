package classes

import traits.{Predicate, Transformer}

object Empty extends AbstractList {
  override def head: Nothing = ???

  override def tail: AbstractList[Nothing] = Empty

  override def isEmpty: Boolean = true

  override def add[B >: Nothing](toBeAdded: B): AbstractList[B] = new List[B](toBeAdded, Empty)

  override def printElements: String = ""

  override def filter(myPredicate: Predicate[Nothing]): AbstractList[Nothing] = Empty

  override def map[B](myTransformer: Transformer[Nothing, B]): AbstractList[B] = Empty

  def ++[B >: Nothing](otherList: AbstractList[B]): AbstractList[B] = otherList

  override def flatMap[B](myTransformer: Transformer[Nothing, AbstractList[B]]): AbstractList[B] = Empty

}
