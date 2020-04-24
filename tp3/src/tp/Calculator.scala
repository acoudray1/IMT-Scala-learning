package tp

object Calculator {
  def factorielle(n: BigInt): BigInt =
    if (n <= 1) 1 else n * factorielle(n-1)

  /*
    Récursivité terminale : on ne remonte pas la pile à la fin du calcul puisque la valeur finale est
    stockée dans le dernier appel à la fonction : accumulateur
   */
  def _factorielle2(n: BigInt, acc: BigInt): BigInt =
    if (n <= 1) acc else _factorielle2(n-1, n * acc)

  def factorielle2(n: BigInt): BigInt = _factorielle2(n, 1)

  // Récursivité terminale avec fonction auxiliaire imbriqué dans la déclaration
  def fact2(i: BigInt): BigInt = {
    def _fact2(n: BigInt, acc: BigInt): BigInt =  if(n <= 1) acc else _fact2(n-1, n * acc)
    _fact2(i, 1)
  }

  // Exception levée avec des trop grandes valeurs (ex: 10000)
  val factorielle3: BigInt => BigInt = (i: BigInt) => {
    lazy val _factorielle3: (BigInt, BigInt) => BigInt = (n: BigInt, acc: BigInt) =>
      if(n <= 1) acc else _factorielle3(n-1, n * acc)
    _factorielle3(i, 1)
  }
  /*
    Correction pour éviter de lever l'exception. Faire une fonction qui appelle une méthode imbriqué au lieu de 2 fonctions
    imbriqués car cela n'est pas traité pareil par le compilateur
   */
  lazy val fact3: BigInt => BigInt = {
    def _fact3(i: BigInt, acc: BigInt): BigInt = {
      if(i <=1) acc else _fact3(i-1, i*acc)
    }
    (n:BigInt) =>_fact3(n, 1)
  }

  def factorielleRev(n: Int): Int = if(n <= 1) 1 else (1 to n).reduce((x, y) => x * y)
  // alternative : def factorielleRev(n: Int): Int = if(n <= 1) 1 else (1 to n).product

  def main(args: Array[String]): Unit = {
    // Partie 4 : Récursion explicite
    println("*** Partie 4 ***")
    println("Result : 6 ? " + factorielle(3))
    println("Result : 1 ? " + factorielle(0))
    println("Result : 3,628,800 ? " + factorielle(10))

    println("Result : 6 ? " + factorielle2(3))
    println("Result : 1 ? " + factorielle2(0))
    println("Result : 3,628,800 ? " + factorielle2(10))

    println("Result : 158 chiffres ? " + factorielle2(100))

    println("Result : 6 ? " + factorielle3(3))
    println("Result : 1 ? " + factorielle3(0))
    println("Result : 3,628,800 ? " + factorielle3(10))

    // Partie 5.3 : Factorielle revisitée
    println("\n*** Partie 5 ***")
    println("Result : 6 ? " + factorielleRev(3))
    println("Result : 1 ? " + factorielleRev(0))
    println("Result : 3,628,800 ? " + factorielleRev(10))
  }
}
