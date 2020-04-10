package stars

class Person(name: String) {

  protected var age_ = 0

  def age: Int = age_

  def age_(newAge: Int): Unit = age_ = newAge

  override def toString = s"stars.Person($name, $age_)"
}


trait Social {
  var bestFriend: Option[Person] = None
}


class Human(name: String) extends Person(name) {

  def incrementAge(): Unit = age_ += 1

  def age_=(newAge: Int): Unit = {
    if (newAge > age_) {
      age_ = newAge
    }
  }
}

class Robot(name: String, ageIni: Int) extends Person(name) {
  require(ageIni > 0)

  age_ = ageIni

  def age_=(newAge: Int): Unit = {
    if (newAge >= 0) {
      age_ = newAge
    }
  }
}

class SocialRobot(name: String, ageIni: Int) extends Robot(name, ageIni) with Social {

}