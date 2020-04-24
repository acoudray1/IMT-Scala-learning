package tp

object Test {
  def decorate(left: String, s: String, right: String):String = left + s + right

  val decorateQ1 = (mot: String) => decorate("\"", mot, "\"") // typage à gauche

  val decorateQ2 = (mot => decorate("\"", mot, "\"")): String => String // typage à droite

  val decorateQ3 = decorate("\"", _, "\"") // typage partiel

  def main(args: Array[String]): Unit = {
    // Partie 1
    println(decorate("Hello", " ", "World!"))
    println(decorateQ1("Hello World!"))
    println(decorateQ2("Hello World!"))
    println(decorateQ3("Hello World!"))
  }
}
