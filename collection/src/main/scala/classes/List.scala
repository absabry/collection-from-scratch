package classes

import scala.annotation.tailrec


case class List[+A](head_val: A, reminder_list: AbstractList[A]) extends AbstractList[A] {
  override def head: A = head_val

  override def tail: AbstractList[A] = reminder_list

  override def isEmpty: Boolean = false

  override def add[B >: A](toBeAdded: B): AbstractList[B] = List(toBeAdded, this)

  override def count : Int = {
    @tailrec
    def utils(result:Int = 0, list:AbstractList[A] = this): Int =
      if (list.isEmpty) result  else utils(result+1, list.tail)
    utils()
  }

  override def size : Int = {
    1 + tail.size
  }

  override def printElements: String = {
    if (reminder_list.isEmpty) head_val.toString
    else head_val.toString + ", " + reminder_list.printElements
  }

  override def filter(myPredicate: A => Boolean): AbstractList[A] = {
    if (myPredicate(head_val)) List[A](head_val, reminder_list.filter(myPredicate))
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

  override def sort(function: (A,A) => Int): AbstractList[A] = {

    def putElementInSortedList(toBeComapredTo: A, sortedTail:AbstractList[A]): AbstractList[A] ={
      if (sortedTail.isEmpty)
        List(toBeComapredTo, Empty)
      else if (function(toBeComapredTo, sortedTail.head)>0)
        List(toBeComapredTo, sortedTail)
      else
        List(sortedTail.head, putElementInSortedList(toBeComapredTo,sortedTail.tail))
    }

    putElementInSortedList(head,tail.sort(function))
  }

  def zipWith[B,R](other:AbstractList[B], function: (A,B)=>R): AbstractList[R] = {
    if (other.count != count)
      throw new RuntimeException("This two lists aren't the same size, I don't know what do you want from me...")
    else
      List(function(head,other.head), tail.zipWith(other.tail, function))
  }

}
