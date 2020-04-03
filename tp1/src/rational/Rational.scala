package rational

class Rational(val n: Int, val d: Int) {
  require (d != 0)
  def this(n: Int) {
    this(n, 1)
  }

  override def toString: String = n + "/" + d

  def +(that: Rational) = new Rational(n * that.d + that.n * d, d * that.d)

  def *(that: Rational) = new Rational(n * that.n, d * that.d)
}

object Rational {
  var r1: Rational = Rational(1) + Rational(1, 2)
  var r2: Rational = r1 * Rational(2, 2)

  def main(args: Array[String]): Unit = {
    System.out.println(r1)
    System.out.println(r2)
  }

  def apply(n: Int, d: Int) = new Rational(n, d)
  def apply(n: Int) = new Rational(n)
}