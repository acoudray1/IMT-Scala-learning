package Rational

class Rational(val n: Int, val d: Int) {
  def this(n: Int) {
    this(n, 1)
  }

  def getN = n

  def setN(i: Int) = {
  }

  def getD = d

  def setD(i: Int) = {
  }

  override def toString = n + "/" + d

  def add(that: Rational) = new Rational(n * that.getD + that.getN * d, d * that.getD)
}