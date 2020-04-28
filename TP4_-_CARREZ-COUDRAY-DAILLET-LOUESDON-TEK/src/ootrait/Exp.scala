package ootrait

import common._

// Base

trait Exp

trait IntLit extends Exp { val v: Int }

trait AExp1 extends Exp

trait AExp2 extends Exp

// Partie Eval

trait ExpE extends Exp { def eval: Val }

trait AExp1E extends AExp1 with ExpE {
  val e1: ExpE
  val op: Op1[Int]
  def eval: Val = op.toVal(e1.eval)
}

trait AExp2E extends AExp2 with ExpE {
  val e1, e2: ExpE
  val op: Op2[Int]
  def eval: Val = op.toVal(e1.eval, e2.eval)
}

// Partie Infixe

trait ExpI extends Exp { def toInfix: String }

trait AExp1I extends AExp1 with ExpI {
  val e1: ExpI
  val op: Op1[Int]
  def toInfix: String = op.toInfix(e1.toInfix)
}

trait AExp2I extends AExp2 with ExpI {
  val e1, e2: ExpI
  val op: Op2[Int]
  def toInfix: String = op.toInfix(e1.toInfix, e2.toInfix)
}

// Partie EI

trait ExpEI extends ExpE with ExpI

trait IntLitEI extends ExpEI with IntLit {
  val v: Int

  override def toInfix: String = v.toString
  override def eval: Val = v
}

trait AExp1EI extends ExpEI with AExp1E with AExp1I {
  val e1: ExpEI
  val op: Op1[Int]
}

trait AExp2EI extends ExpEI with AExp2E with AExp2I {
  val e1, e2: ExpEI
  val op: Op2[Int]
}