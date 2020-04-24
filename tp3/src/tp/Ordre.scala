package tp

object Ordre {

  /*
  Question:
    lastOption est à utiliser dans le cas ou la liste est potentiellement vide ou non. Si liste vide, lastOption retourne None
    sinon lastOption retourne Some(lastValue).
   */

  def printRange(range: Range): Unit = range.foreach(print)

  def main(args: Array[String]): Unit = {
    // Partie 5 : Ordre supérieur
    printRange(1 to 10)
    
  }
}
