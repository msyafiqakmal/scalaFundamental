package com.atkme

object FunctionalProgramming extends App {
  //  Scala is OO
  class Person(name: String) {
    def apply(age: Int) = println(s"I have $age years")
  }

  val bob = new Person("bob")
  bob.apply(43)
  bob(43) // INVOKING bob as a function  === bob.apply(43)

  /* Scala runs on the JVM
  Functional Programming:
  - compose functions
  - pass functions as args
  - return functions as results

  Conclusion: FunctionX = Function1, FUnction2, .... FUnction22
  */

  val simpleIncrementer = new Function1[Int, Int] {
    override def apply(arg: Int): Int = arg + 1
  }
  simpleIncrementer.apply(23) //24
  simpleIncrementer(23) //simpleIncrementer.apply(23)
  // defined as a function!

  //  ALL SCALA FUNCTIONS ARE INSTANCES OF THESE FUNCTION_X TYPES

  val stringConcatenator = new Function2[String, String, String] {
    override def apply(arg1: String, arg2: String): String = arg1 + arg2
  }

  stringConcatenator("I Love", "Scala") // "I Love Scala"

  //  syntax sugars
  val doubler: Function1[Int, Int] = (x: Int) => 2 * x
  val doubler2: Int => Int = (x: Int) => 2 * x
  val doubler3 = (x: Int) => 2 * x
  doubler(4) // 8
  doubler2(4) // 8
  doubler3(4) //8

  /* Equivalent to much longer:
val doubler: Function1[Int:Int] = new function1[Int,Int]{
override def apply(x: Int) = 2 * x
}
* */

  //  higher-order functions: take functions as args/return functions as results
  val aMappedList = List(1, 2, 3).map(x => x + 1) //Higher order function - don't have mention the type. this anonymous function is passed as an argument to map method
  val aFlatMappedList = List(1, 2, 3).flatMap(x => List(x, 2 * x))
  val aAltFlatMappedList = List(1, 2, 3).flatMap { x =>
    List(x, 2 * x) // alternative
  }
  val aFilteredList = List(1, 2, 3, 4, 5, 6).filter(x => x <= 3) //take anonymous function and produce new list
  val aShorterFilteredList = List(1, 2, 3, 4, 5, 6).filter(_ <= 3) // equivant to x => x <= 3


  //  all pairs between the numbers 1,2,3 and the letters 'a','b','c'
  val allPairs = List(1, 2, 3).flatMap(number => List('a', 'b', 'c').map(letter => s"$number-$letter"))
  //  enable iteration via using map and flatmap.

  // for comprehensions
  val alternativePairs = for {
    number <- List(1, 2, 3)
    letter <- List('a', 'b', 'c')
  } yield s"$number -$letter"
  //  equivalent to the map/flatmap chain above

  /*Collections
  * */

  //  Lists
  val aList = List(1, 2, 3, 4, 5)
  val firstElement = aList.head
  val rest = aList.tail
  val aPrependedList = 0 :: aList // List(0,1,2,3,4,5)
  val anExtendedList = 0 +: aList :+ 6 // List(0,1,2,3,4,5,6)

  //  Sequences
  val aSequence: Seq[Int] = Seq(1, 2, 3) // Seq.apply(1,2,3) Seq is a trait with abstract type
  val accessedElement = aSequence(1) // the element at index 1: 2

  //  vectors: fast Seq Implementation
  val aVector = Vector(1, 2, 3, 4, 5)

  //  sets = no duplicates
  val aSet = Set(1, 2, 3, 4, 1, 2, 3) //Set(1,2,3,4)
  val setHas5 = aSet.contains(5) //false
  val anAddedSet = aSet + 5 //Set(1,2,3,4,5)
  val aRemovedSet = aSet - 3 //Set(1,2,4)

  //  ranges
  val aRange = 1 to 1000 //ficticious lsit
  val twoByTwo = aRange.map(x => 2 * x).toList //List(2,3,6,8....,2000)

  //  tuples = group of values under the same values
  val aTuple = ("Bon Jovi", "ROck", "1982")

  //  maps
  val aPhonebook: Map[String, Int] = Map(
    ("Daniel", 544222),
    "Jane" -> 32445 // ("Jane",32445)

  )
}
