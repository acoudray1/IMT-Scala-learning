package tp

object Ordre {

  /*
  Question:
    lastOption est à utiliser dans le cas ou la liste est potentiellement vide ou non. Si liste vide, lastOption retourne None
    sinon lastOption retourne Some(lastValue).
   */

  def printRange(range: Range): Unit = range.foreach(print)

  def values(f: (Int) => Int, low: Int, high: Int) = (low to high).zip((low to high).map(f))

  def largest(f: (Int) => Int, inputs: Seq[Int]) = inputs.map(f).max

  def largestAt(f: (Int) => Int, inputs: Seq[Int]) = values(f, inputs.min, inputs.max).maxBy(_._2)._1

  def adjustToPair(f: (Int, Int) => Int) = (x, y) => ((x, y))

  def main(args: Array[String]): Unit = {
    // Partie 5 : Ordre supérieur
    printRange(1 to 10)
    println("\nResult : Vector((-2,4), (-1,1), (0,0), (1,1), (2,4)) ? " + values(x => x * x, -2, 2))
    println("Result : 25 ? " + largest(x => 10 * x - x * x, 1 to 10))
    println("Result : 5 ? " + largestAt(x => 10 * x - x * x, 1 to 10))
    println("Result : 42 ? " + adjustToPair(_ * _)((6, 7)))
  }
}
