package money

import money.Currency.Currency

class Account(var argent: Double, var currency: Currency) {
  require(currency != null)

  def this(n: Double) {
    this(n, Currency.Euro)
  }

  def +(moreMoney: Double, moneyCurrency: Currency) = {
    argent += moreMoney * Currency.exchangeRate(currency)(moneyCurrency)
  }

  override def toString: String = argent + " " + currency.toString
}

object Account {

  var a1 = Account(10, Currency.Euro)

  def main(args: Array[String]): Unit = {
    println(a1.toString)
    a1 + (12, Currency.Dollar)
    println(a1.toString)
  }

  def apply(argent: Double, currency: Currency): Account = new Account(argent, currency)
}
