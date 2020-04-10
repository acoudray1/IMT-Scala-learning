package stars

object Test {
  var rey: Human = new Human("Rey")
  var c3po: Robot = new Robot("C3PO", 12)
  var r2d2: SocialRobot = new  SocialRobot("R2D2", 10)
  var bb8: SocialRobot = new SocialRobot("BB8", 3)

  def main(args: Array[String]): Unit = {
    println("Result : Person(Rey, 0) ? " + rey.toString)
    rey.age = 24
    println("Result : Person(Rey, 24) ? " + rey.toString)
    rey.age = 14
    println("Result : Person(Rey, 24) ? " + rey.toString)

    println("Result : Person(C3PO, 12) ? " + c3po.toString)
    c3po.age = 3
    println("Result : Person(C3PO, 3) ? " + c3po.toString)

    println("Result : SocialRobot(R2D2, 10, None) ? " + r2d2.bfToString)
    println("Result : SocialRobot(BB8, 3, None) ? " + bb8.bfToString)
    r2d2.bestFriend = Some(bb8)
    println("Result : Some(SocialRobot(BB8, 3)) ? " + r2d2.bestFriend)
    println("Result : None ? " + bb8.bestFriend)
    r2d2.mutualBestFriend(bb8)
    println("Result : Some(SocialRobot(BB8, 3)) ? " + r2d2.bestFriend)
    println("Result : Some(SocialRobot(R2D2, 3)) ? " + bb8.bestFriend)
  }
}
