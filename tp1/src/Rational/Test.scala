package Rational

object Test {
  var r1 = new Rational(1).add(new Rational(1, 2))

  def main(args: Array[String]) = {
    System.out.println(r1)
    r1.setD(0)
    System.out.println(r1)
  }
}