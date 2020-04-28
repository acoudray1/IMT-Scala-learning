package fp

import common.{Op1, Op2}

sealed trait Exp

case class IntLit(v: Int) extends Exp

case class BoolLit(v: Boolean) extends Exp

case class AExp1(op: Op1[Int], e1: Exp) extends Exp

case class AExp2(op: Op2[Int], e1: Exp, e2: Exp) extends Exp

case class LExp1(op: Op1[Boolean], e1: Exp) extends Exp

case class LExp2(op: Op2[Boolean], e1: Exp, e2: Exp) extends Exp

case class Compare(e1: Exp, e2: Exp) extends Exp