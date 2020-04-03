package Rational

object Test {
  var r1: Rational = new Rational(1) + (new Rational(1, 2))
  var r2: Rational = r1 * (new Rational(2, 2))

  def main(args: Array[String]): Unit = {
    System.out.println(r1)
    System.out.println(r2)
  }
}