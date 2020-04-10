package money

import money.Currency.Currency

class Account(var argent: Double, var currency: Currency) {
  require(currency != null)

  def this(n: Double) = {
    this(n, Currency.Euro)
  }

  // Adds money on current instance
  def addMoneyOnAccount(moreMoney: Double, moneyCurrency: Currency): Unit = {
    argent += moreMoney * Currency.exchangeRate(currency)(moneyCurrency)
  }

  // Adds Account on new Account
  def +(that: Account): Account = Account(argent + (Currency.exchangeRate(that.currency)(currency) * that.argent), currency)

  override def toString: String = argent + " " + currency.toString
}

object Account {

  var a1: Account = Account(10, Currency.Euro)
  var a2: Account = Account(12, Currency.Yen) + a1

  def main(args: Array[String]): Unit = {
    println("a1 account: " + a1.toString)
    println("a2 account with a1 account added on a2: " + a2.toString)

    a1.addMoneyOnAccount(12, Currency.Dollar)
    println("a1 account after adding money: " + a1.toString)
  }

  def apply(argent: Double, currency: Currency): Account = new Account(argent, currency)
}
