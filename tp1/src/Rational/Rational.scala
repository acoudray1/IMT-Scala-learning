package Rational

class Rational(val n: Int, val d: Int) {
  require (d != 0)
  def this(n: Int) {
    this(n, 1)
  }

  override def toString: String = n + "/" + d

  def add(that: Rational) = new Rational(n * that.d + that.n * d, d * that.d)
}