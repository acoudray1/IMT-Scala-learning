package Money

object Currency extends Enumeration {
  type Currency = Value
  val Euro = Value("EUR")
  val Dollar = Value("USD")
  val Yen = Value("JPY")

  val exchangeRate = Map(
    Dollar -> Map(Euro -> 0.863187, Dollar -> 1, Yen -> 113.648),
    Euro -> Map(Euro -> 1, Dollar -> 1.15850, Yen -> 131.676),
    Yen -> Map(Euro -> 0.00759441, Dollar -> 0.00879910, Yen -> 1))
}