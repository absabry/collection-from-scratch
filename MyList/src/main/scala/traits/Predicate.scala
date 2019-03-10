package traits

trait Predicate[-T] {
  def test(value:T): Boolean
}
