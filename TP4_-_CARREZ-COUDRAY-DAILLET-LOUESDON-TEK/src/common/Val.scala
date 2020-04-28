package common

sealed trait Val
case class IntV(i: Int) extends Val
case class BoolV(b: Boolean) extends Val

// 4.1 : Les conversions sont ici
object Val {

  implicit def intToVal(i: Int): IntV = IntV(i)

  implicit def valToInt(v: Val): Int = v match {
    case v: IntV => v.i
  }

  implicit def boolToVal(b: Boolean): BoolV = BoolV(b)

  implicit def valToBool(v: Val): Boolean = v match {
    case v: BoolV => v.b
  }

}