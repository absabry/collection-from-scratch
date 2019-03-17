package traits
/*
Don't use this trait anymore after discovering lambda functions
 */

trait Predicate[-T] {
  def apply(value:T): Boolean
}
