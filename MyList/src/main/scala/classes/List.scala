package classes

class List[+A](head_val: A, reminder_list: AbstractList[A]) extends AbstractList[A] {
  override def head: A = head_val

  override def tail: AbstractList[A] = reminder_list

  override def isEmpty: Boolean = false

  override def add[B >: A](toBeAdded: B): AbstractList[B] = new List(toBeAdded, this)

  override def printElemnts: String = {
    if (reminder_list.isEmpty) head_val.toString
    else head_val.toString + " " + reminder_list.printElemnts
  }
}
