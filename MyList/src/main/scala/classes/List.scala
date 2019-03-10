package classes

class List(head_val: Int, reminder_list: AbstractList) extends AbstractList {
  override def head: Int = head_val

  override def tail: AbstractList = reminder_list

  override def isEmpty: Boolean = false

  override def add(toBeAdded: Int): AbstractList = new List(toBeAdded, this)

  override def printElemnts: String = {
    if (reminder_list.isEmpty) head_val.toString
    else head_val.toString + " " + reminder_list.printElemnts
  }
}
