package rainfallS2

import scala.util.control.Breaks._

object Rainfall {

  private def rainfall(rainfalls: List[Integer]): Option[Double] = {
    if (rainfalls.isEmpty) None
    val l = rainfalls
      .takeWhile((rainfall) => rainfall != -999)
      .filter((rainfall) => rainfall >= 0)

    if (l.nonEmpty) Some(l.reduceOption[Integer](_ + _).get.toDouble / l.size)
    else None
  }

  private def test(rainfalls: List[Integer]) = try {
    println("====")
    println(rainfalls)
    println(rainfall(rainfalls))
  } catch {
    case ex: Exception =>
      System.err.println(ex.getClass + ": " + ex.getMessage)
  }

  def main(args: Array[String]) = {
    test(List.empty)
    test(List(0))
    test(List(-999))
    test(List(-1, -2))
    test(List(1, 2))
    test(List(1, -3, 2))
    test(List(1, 2, -3))
    test(List(1, -999, 2, -3))
  }
}
