package rainfallP

import scala.collection.parallel.CollectionConverters._

object Rainfall extends App {
  def rainfall(rainfalls: List[Int]): Option[Double] = {
    val optSum = rainfalls.par
      .takeWhile((rainfall) => rainfall != -999)
      .filter((rainfall) => rainfall >= 0)

    val n = optSum.size
    val sum = optSum.reduceOption[Int](_ + _)

    if (n != 0) Some(sum.get.toDouble / n)
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

  // apply tests
  test(List.empty)
  test(List(0))
  test(List(-999))
  test(List(-1, -2))
  test(List(1, 2))
  test(List(1, -3, 2))
  test(List(1, 2, -3))
  test(List(1, -999, 2, -3))

}