package money

class Factor(var f: Double) {
  def *(that: Account): Account = Account(that.argent * f, that.currency)
}

object Factor {
  def apply(d: Double): Factor = new Factor(d)
}