package tp

object Decorate {
  implicit val decoration: String = "\""
  implicit val decoration2: (String, String) = ("\"", "\"")

  def decorate(left: String, s: String, right: String):String = left + s + right

  val decorateQ1 = (mot: String) => decorate("\"", mot, "\"") // typage à gauche

  val decorateQ2: String => String = (mot => decorate("\"", mot, "\"")) // typage à droite

  val decorateQ3 = decorate("\"", _, "\"") // typage partiel

  def decorateC(mot: String)(implicit s: String) = decorate(s, mot, s)

  def decorateC2(s: String)(implicit d :(String, String)) = decorate(d._1, s, d._2)

  def main(args: Array[String]): Unit = {
    // Partie 2 : Méthodes et fonctions
    println("*** Partie 2 ***")
    println(decorate("Hello", " ", "World!"))
    println(decorateQ1("Hello World!"))
    println(decorateQ2("Hello World!"))
    println(decorateQ3("Hello World!"))

    // Partie 3 : Curry
    println("\n*** Partie 3 ***")
    println(decorateC("Hello World!")("\""))
    println(decorateC("Hello World!"))
    println(decorateC2("Hello World!")("\'", "\'"))
    println(decorateC2("Hello World!"))
  }
}
