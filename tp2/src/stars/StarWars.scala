package stars

class Person(name: String) {

  protected var age_ = 0

  def age: Int = age_

  def age_=(newAge: Int): Unit = age_ = newAge

  override def toString = s"Person($name, $age_)"
}


class Human(name: String) extends Person(name) {

  def incrementAge(): Unit = age_ += 1

  override def age_=(newAge: Int): Unit = {
    if (newAge > age_) {
      age_ = newAge
    }
  }
}


class Robot(name: String, ageIni: Int) extends Person(name) {
  require(ageIni > 0)

  age_ = ageIni

  override def age_=(newAge: Int): Unit = {
    if (newAge >= 0) {
      age_ = newAge
    }
  }
}


trait Social {
  var bestFriend: Option[Person] = None
}


class SocialRobot(name: String, ageIni: Int) extends Robot(name, ageIni) with Social {

  def mutualBestFriend(robot: SocialRobot): Unit = {
    this.bestFriend = Some(robot)
    robot.bestFriend = Some(this)
  }

  override def toString = s"SocialRobot($name, $age)"

  def bfToString = s"SocialRobot($name, $age, $bestFriend)"
}