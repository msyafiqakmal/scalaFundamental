package com.atkme

object ObjectOrientation extends App {
  //exteds APp java equivalent: public static void main(String[] args)

  //   class and instance
  class Animal {
    //  define fields
    val age: Int = 0

    def eat() = println("im eating")
  }

  val anAnimal = new Animal

  //  inheritance
  //provided constructor argument  in class dogname
  class Dog(val name: String) extends Animal

  val aDog = new Dog("Lassie")

  //  Constructor argument is NOT fields: need to put a val before the constructor argument

  aDog.name

  //  Subtype polymorphism
  val aDeclaredAnimal: Animal = new Dog("Hachi")
  aDeclaredAnimal.eat() // the most derived method will be called at runtime

  //  abstract class
  abstract class WalkingAnimal {
    val hasLegs = true // by default public (no public access modifier), can restruct by using private or protected
    //  private class and decendant have access  def walk(): Unit
  }

  //  interface = ultimate abstract type
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait Philosopher {
    def ?!(thought: String): Unit //valid method name ?! use extensively in Akka
  }

  //  Single-class inheritance, multi-trait mixing
  class Crocodile extends Animal with Carnivore {
    override def eat(animal: Animal): Unit = println("Im eating you")

    def ?!(thought: String): Unit = println(s"I was thinking $thought")
  }


  val aCroc = new Crocodile
  aCroc.eat(aDog)
  aCroc eat aDog // infix notation = object method argument, only available for method with one argument.
  aCroc ?! "What is we could fly?"

  //   operators in Scala are actually methods
  val basicMath = 1 + 2
  val anotherBasicMath = 1.+(2) //equivalent

  //  anonymous Class
  val dinosaur = new Carnivore {
    override def eat(animal: Animal): Unit = println("I am a dinosaur so I can eat pretty much anything")
  }

  /*
What you tell the compiler:
Class Carnivor_Anonymouse_345555 extends carnivor{
override def eat(animal: Animal): Unit = println("I am a dinosaur so I can eat pretty much anything")
}

val dinosaur = new Carnivore_Anonymous _35728
*/

  //  Singleton object
  object MySingleton {
    val mySpecialValue = 53201

    def mySpecialMethod(): Int = 53227

    def apply(x: Int): Int = x + 1
  }

  MySingleton.mySpecialMethod()
  MySingleton.apply(65)
  MySingleton(65) // equivalent to MySingleton.apply(65) allow this to invoke like function

  object Animal { //Companions = companion object when have similar name to class or name
    // companions can access each other private fields/methods
    // Singleton Animals and instances of animal are different things
    val canLiveIndefinitely = false
  }

  val animalsCanLiveForever = Animal.canLiveIndefinitely // "Static" fields/method




  /*
  Case Classes = lighjtweight data structures with some boilerplate
  ~sensible equals and hash code
  ~ serialization
  - companion with apply
  - Pattern matching
  * */

  case class Person(name: String, age: Int)

  //  maty be constructed wiutghout new
  val bob = Person("Bob", 54) // Person.apply("Bob, 54)

  //  exceptions
  try {
    //    code that can throw
    val x: String = null
    x.length
  } catch { // in java catch{exception e}
    case e: Exception => "Some faulty error Message"
  } finally {
    //    execute sxome code nomater what
  }

  //generics
  abstract class MyList[T] {
    def head: T

    def tail: MyList[T]
  }

  //  Using a generic with a concrete type
  val aList: List[Int] = List(1, 2, 3)
  val first = aList.head
  val rest = aList.tail

  val aStringList = List("hello", "Scala")
  val firstString = aStringList.head //String

  //  Point 1: operate with Immutable value/objects
  //  any modification to an object must return Another Object
  /*
  Benefits:
  1) Works miracles in multithreaded and distributed environment
  2) Helps making sense of the code ("reasoning about)
  * */
  val reversedList = aList.reverse //return a New List

  //  Point #2: Scala is closest to the OO ideal
}
