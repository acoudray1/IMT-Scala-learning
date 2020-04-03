package Hello

object Hello extends App {
  println("Hello World!")

  // Variable
  val x: Int = 2 + 4
  println(x)

  // Functions
  val multiply = (x: Int, y: Int) => x * y
  val z: Double = multiply(x, 3)
  println(z)

  // Methods
  def add(x: Int, y: Int) : Int = x + y
  println(add(x, 4))

  def addThenMultiply(x: Int, y: Int)(multiplier: Int): Int = (x + y) * multiplier
  println(addThenMultiply(1, 2)(3))

  def name: String = System.getProperty("user.name")
  println("Hello, " + name + "!")

  def getSquareString(input: Double): String = {
    val square = input * input
    square.toString
  }
  println(getSquareString(2.5))

  // Classes
  // Instanciated with the "new" keyword
  val greeter = new Greeter("Hello, ", "!")
  greeter.greet("Scala developer")

  // Case classes
  // Can be instanciated withoit the "new" keyword
  // Instances of case classes are Immutable
  // Instances of case classes are compared by value, not by reference
  val point = Point(1, 2)
  val anotherPoint = Point(1, 2)
  val yetAnotherPoint = Point(2, 2)

  if (point == anotherPoint) {
    println(point + " and " + anotherPoint + " are the same.")
  } else {
    println(point + " and " + anotherPoint + " are different.")
  }

  // Objects single instances of their own definitions (singleton)
  // You can access an object by referring to its name
  val newId: Int = IdFactory.create()
  println(newId) // 1
  val newerId: Int = IdFactory.create()
  println(newerId) // 2

  // Traits
}

// Greeter class
class Greeter(prefix: String, suffix: String) {

  // void return type equivalent := Unit
  def greet(name: String): Unit = println(prefix + name + suffix)
}

// Point case class
case class Point(x: Int, y: Int)

// Object IdFactory
object IdFactory {
  private var counter = 0
  def create(): Int = {
    counter += 1
    counter
  }
}

// Greet Trait
trait Greeter2 {
  def greet(name: String): Unit
}

trait Greeter3 {
  def greet(name: String): Unit =
    println("Hello, " + name + "!")
}