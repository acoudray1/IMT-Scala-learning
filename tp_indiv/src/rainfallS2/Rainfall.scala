package rainfallS2

object Rainfall {

  private def rainfall(rainfalls: List[Int]): Option[Double] = {
    if (rainfalls.isEmpty) None
    val l = rainfalls
      .takeWhile((rainfall) => rainfall != -999)
      .filter((rainfall) => rainfall >= 0)
    val n = l.size
    val sum = l.reduceOption[Int](_ + _)

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
