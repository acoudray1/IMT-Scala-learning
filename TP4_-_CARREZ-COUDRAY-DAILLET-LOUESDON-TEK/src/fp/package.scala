import common._

package object fp {

  def eval(exp: Exp): Val = {
    check(exp)
    exp match {
      case IntLit(v) => v
      case BoolLit(v) => v
      case AExp1(op, e1) => op.toVal(eval(e1))
      case AExp2(op, e1, e2) => op.toVal(eval(e1), eval(e2))
      case LExp1(op, e1) => op.toVal(eval(e1))
      case LExp2(op, e1, e2) => op.toVal(eval(e1), eval(e2))
      case Compare(e1, e2) => eval(e1) == eval(e2)
    }
  }

  def toInfix(exp: Exp): String = exp match {
    case IntLit(v) => v.toString
    case BoolLit(v) => v.toString
    case AExp1(op, e1) => op.toInfix(toInfix(e1))
    case AExp2(op, e1, e2) => op.toInfix(toInfix(e1), toInfix(e2))
    case LExp1(op, e1) => op.toInfix(toInfix(e1))
    case LExp2(op, e1, e2) => op.toInfix(toInfix(e1), toInfix(e2))
    case Compare(e1, e2) => toInfix(e1) + "==" + toInfix(e2)
  }

  def check(exp: Exp): Type = exp match {
    case IntLit(_) => I
    case BoolLit(_) => B
    case AExp1(op, e1) => check(e1) match { case I => I }
    case AExp2(op, e1, e2) => check(e1) match {
      case I => check(e2) match
        { case I => I
        }
    }
    case LExp1(op, e1) => check(e1) match { case B => B }
    case LExp2(op, e1, e2) => check(e1) match {
      case B => check(e2) match
      { case B => B
      }
    }
    case Compare(e1,e2) => B
  }
}