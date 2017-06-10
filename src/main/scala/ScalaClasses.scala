object ScalaClasses {

  def main(args: Array[String]) {

    val monkey = new UsefulAnimal(2, true)
    //    println(monkey.property1)
    //    println(monkey.walk(3))
    //    println(monkey.sing)

    val fish = new UsefulAnimal(0, false)

    //    println(fish.property1)
    //    println(fish.walk(4))
    //    println(fish.sing)

    val gojira = new Kaiju(2, true)

    gojira.totalSteps = 3

    println(gojira.sing)

    println(gojira.walk(10))

    val kingGhidorah = new KingGhidorah(2, 3)

    println(kingGhidorah.walk(7))

    println(kingGhidorah.sing)

    println(kingGhidorah.totalSteps)

    val mothra = new Mothra

    mothra.walk(5)

    println(mothra.totalSteps)



   println( new Horse("Bucephalus"))

  }

  abstract class DomesticAnimal(name: String, numLegs: Int, breathesAir: Boolean)
    extends UsefulAnimal(numLegs, breathesAir) {
    val favoriteFood: String

    def eat(n: Int): String

    override def toString =
      s"I am an animal called $name that likes to eat $favoriteFood like this: ${eat(3)}"
  }

  class Horse(name: String) extends DomesticAnimal(name, 4, true) {
    val favoriteFood: String = "oats"

    def eat(n: Int) = "Munch " * n + "!"
  }


  class UsefulAnimal(numLegs: Int, breathesAir: Boolean) {
    val property1 = s"I have $numLegs legs"

    def walk(n: Int): String = (if (numLegs == 0) "slither "
    else if (numLegs == 1) "hop "
    else if (numLegs == 2) "stomp "
    else if (numLegs == 4) "gallop "
    else "crawl ") * n

    def sing = if (breathesAir) "La di da!" else "You must be joking!"
  }

  class Kaiju(numLegs: Int, breathesAir: Boolean) extends UsefulAnimal(numLegs, breathesAir) {
    var totalSteps = 0
    println("Total steps are " + totalSteps)

    override def walk(steps: Int): String = {
      totalSteps = steps + totalSteps
      println("Total steps : " + totalSteps)
      "stomp " * totalSteps
    }

    override def sing = "Roaarr!"

  }

  class KingGhidorah(numLegs: Int, numHeads: Int) extends Kaiju(numLegs, true)

  class Mothra extends Kaiju(6, true)



}
