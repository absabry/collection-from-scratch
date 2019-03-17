package traits
/*
Don't use this trait anymore after discovering lambda functions
 */

trait Transformer[-A,B] {
  def apply(value:A) : B
}
