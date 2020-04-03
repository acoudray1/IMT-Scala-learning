package Rational

class Rational(val n: Int, val d: Int) {
  def this(n: Int) {
    this(n, 1)
  }

  def getN: Int = n

  def setN(i: Int): Unit = {
  }

  def getD: Int = d

  def setD(i: Int): Unit = {
  }

  override def toString: String = n + "/" + d

  def add(that: Rational) = new Rational(n * that.getD + that.getN * d, d * that.getD)
}