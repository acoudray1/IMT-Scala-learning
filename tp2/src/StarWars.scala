class Person(name: String) {

  protected var age_ = 0

  override def toString: String = name + " " + age_
}


class Human(name: String) extends Person(name) {

  def age: Int = age_

  def incrementAge(): Unit = age_ += 1

  def age_(newAge: Int): Unit = {
    if (newAge > age_) {
      age_ = newAge
    }
  }
}

class Robot(name: String, age: Int) extends Person(name) {

}