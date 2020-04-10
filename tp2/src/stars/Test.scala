package stars

object Test {
  import stars._

  var rey: Human = new Human("Rey")
  var c3po: Robot = new Robot("C3PO", 12)

  def main(args: Array[String]): Unit = {
    println("Result : Person(Rey, 0) ? " + rey.toString)
    rey.age = 24
    println("Result : Person(Rey, 24) ? " + rey.toString)
    rey.age = 14
    println("Result : Person(Rey, 14) ? " + rey.toString)

    println("Result : Person(C3PO, 12) ? " + c3po.toString)
    c3po.age = 3
    println("Result : Person(C3PO, 3) ? " + c3po.toString)
  }
}
