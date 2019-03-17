package classes

case class List[+A](head_val: A, reminder_list: AbstractList[A]) extends AbstractList[A] {
  override def head: A = head_val

  override def tail: AbstractList[A] = reminder_list

  override def isEmpty: Boolean = false

  override def add[B >: A](toBeAdded: B): AbstractList[B] = new List(toBeAdded, this)

  override def printElements: String = {
    if (reminder_list.isEmpty) head_val.toString
    else head_val.toString + ", " + reminder_list.printElements
  }

  override def filter(myPredicate: A => Boolean): AbstractList[A] = {
    if (myPredicate(head_val)) new List[A](head_val, reminder_list.filter(myPredicate))
    else reminder_list.filter(myPredicate)
  }

  override def map[B](myTransformer: A => B ): AbstractList[B] = {
    new List[B](myTransformer(head_val), reminder_list.map(myTransformer))
  }

  override def ++[B >: A](otherList : AbstractList[B]): AbstractList[B] = {
    new List[B](head_val, otherList ++ reminder_list)
  }

  override def flatMap[B](myTransformer: A => AbstractList[B] ): AbstractList[B] = {
    myTransformer(head_val) ++ reminder_list.flatMap(myTransformer)
  }

  override def foreach(function: A => Unit): Unit = {
    function(head)
    tail.foreach(function)
  }


}
