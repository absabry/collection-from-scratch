package classes

import traits.{Predicate, Transformer}

abstract class AbstractList[+A] {
  def head: A

  def tail: AbstractList[A]

  def isEmpty: Boolean

  def add[B >: A](toBeAdded: B): AbstractList[B]

  def printElements: String

  override def toString: String = "[" + printElements + "]"

  def filter(myPredicate: Predicate[A]): AbstractList[A]

  def map[B](myTransformer: Transformer[A, B]): AbstractList[B]

  def ++[B >: A](otherList: AbstractList[B]): AbstractList[B] // concatenation of two lists

  def flatMap[B](myTransformer: Transformer[A, AbstractList[B]]): AbstractList[B]

}
