package ootrait

import common._

import scala.util.matching.Regex
import scala.util.parsing.combinator.RegexParsers

class Parser extends RegexParsers {
  val number: Regex = "0|[1-9]+".r
  def exp: Parser[ExpEI] =  "(" ~> "-" ~> exp <~ ")" ^^ (exp => new AExp1EI {
                                                                    override val e1: ExpEI = exp
                                                                    override val op: Op1[Int] = MINUS
                                                                  } ) |
                          "(" ~> "+" ~> exp ~ exp <~ ")" ^^ { case exp1 ~ exp2 => new AExp2EI {
                            override val e1: ExpEI = exp1
                            override val e2: ExpEI = exp2
                            override val op: Op2[Int] = PLUS
                          } } |
                          "(" ~> "*" ~> exp ~ exp <~ ")" ^^ { case exp1 ~ exp2 => new AExp2EI {
                            override val e1: ExpEI = exp1
                            override val e2: ExpEI = exp2
                            override val op: Op2[Int] = TIMES
                          }} |
                          number ^^ (n => new IntLitEI { override val v: Int = n.toInt })
}

