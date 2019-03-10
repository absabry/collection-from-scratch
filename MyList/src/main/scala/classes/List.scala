package classes

import traits.{Predicate, Transformer}

class List[+A](head_val: A, reminder_list: AbstractList[A]) extends AbstractList[A] {
  override def head: A = head_val

  override def tail: AbstractList[A] = reminder_list

  override def isEmpty: Boolean = false

  override def add[B >: A](toBeAdded: B): AbstractList[B] = new List(toBeAdded, this)

  override def printElements: String = {
    if (reminder_list.isEmpty) head_val.toString
    else head_val.toString + ", " + reminder_list.printElements
  }

  override def filter(myPredicate: Predicate[A]): AbstractList[A] = {
    if (myPredicate.test(head_val)) new List[A](head_val, reminder_list.filter(myPredicate))
    else reminder_list.filter(myPredicate)
  }

  override def map[B](myTransformer: Transformer[A, B]): AbstractList[B] = {
    new List[B](myTransformer.transform(head_val), reminder_list.map(myTransformer))
  }

  def ++[B >: A](otherList : AbstractList[B]): AbstractList[B] = {
    new List[B](head_val, otherList ++ reminder_list)
  }

  override def flatMap[B](myTransformer: Transformer[A,  AbstractList[B]]): AbstractList[B] = {
    myTransformer.transform(head_val) ++ reminder_list.flatMap(myTransformer)
  }

}
