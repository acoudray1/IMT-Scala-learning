package rational

import money.Account
import money.Currency

object Test {
  import Currency._

  // part > 4
  var r1: Rational = new Rational(1) + new Rational(1, 2)
  var r2: Rational = r1 * new Rational(2, 2)

  // part 5
  val a:Account = Currency.double2Locale(22.5)

  def main(args: Array[String]): Unit = {
    // part > 4
    println("Result : Rational(3/2) ? " + r1)
    println("Result : Rational(6/4) ? " + r2)

    // part 5
    println("Result : Account(22.5, Currency.Euro) ? " + a)
    // -> implicit declaration of new Account
    val b:Account = 22.5
    println("Result : Account(35.0, Currency.Euro) ? " + (b + 12.5))
    println("Result : Account(35.0, Currency.Euro) ? " + (12.5 + b))
  }
}