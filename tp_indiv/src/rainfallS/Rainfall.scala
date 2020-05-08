package rainfallS

import scala.util.control.Breaks._

object Rainfall {

  private def rainfall(rainfalls: List[Int]): Option[Double] = {
    if (rainfalls.isEmpty) None
    var sum = 0
    var n = 0
    breakable {
      for (rainfall <- rainfalls) {
        if (rainfall == -999) break
        if (rainfall >= 0) {
          n += 1
          sum += rainfall
        }
      }
    }
    println("sum: " + sum)
    if (n != 0) Some(sum.toDouble / n)
    else None
  }

  private def test(rainfalls: List[Int]) = try {
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
