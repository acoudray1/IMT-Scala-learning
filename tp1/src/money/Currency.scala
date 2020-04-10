package money

object Currency extends Enumeration {
  type Currency = Value
  val Euro: Currency.Value = Value("EUR")
  val Dollar: Currency.Value = Value("USD")
  val Yen: Currency.Value = Value("JPY")

  var locale: Currency = Currency.Euro

  val exchangeRate: Map[Currency, Map[Currency, Double]] = Map(
    Dollar -> Map(Euro -> 0.863187, Dollar -> 1, Yen -> 113.648),
    Euro -> Map(Euro -> 1, Dollar -> 1.15850, Yen -> 131.676),
    Yen -> Map(Euro -> 0.00759441, Dollar -> 0.00879910, Yen -> 1))

  def double2locale(d: Double): Account = Account(d, currency = locale)
}