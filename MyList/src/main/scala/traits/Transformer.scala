package traits

trait Transformer[-A,B] {
  def transform(value:A) : B
}
