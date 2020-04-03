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
  val greeter = new Greeter("Hello, ", "!")
  greeter.greet("Scala developer")
}

// Greeter class
class Greeter(prefix: String, suffix: String) {

  // void return type equivalent := Unit
  def greet(name: String): Unit = println(prefix + name + suffix)


}