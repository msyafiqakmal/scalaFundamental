package com.atkme

object Basics extends App {
  // Defining a value
  val meaningOfLife: Int = 42

  //  Int, Boolean, Char, DOuble, FLoat, String
  val aBoolean = false

  val aString = "I love Scala"
  val aComposedString = "I" + " " + "love" + "Scala"
  val anInterpolatedString = s"The meaning of life is $meaningOfLife"

  //  expression : structures that can be reduced to a value
  val anExpression = 2 + 3

  //  if-expression
  val ifExpression = if (meaningOfLife > 43) 56 else 999
  val chainedIfExpression =
    if (meaningOfLife < 43) 56
    else if (meaningOfLife > 0) -2
    else if (meaningOfLife > 999) 78
    else 0

  //  COde blocks
  val aCodeBlock = {
    //    definitions
    val aLocalValue = 67
    //    value of the entire block
    aLocalValue + 3
  }

  //  define a function
  def myfunction1(x: Int, y: String): String = y + " " + x

  def myfunction(x: Int, y: String): String = {
    y + " " + x
  }

  //recursive function
  def factorial(n: Int): Int =
    if (n <= 1) 1
    else n * factorial(n - 1)

  /*
  * factorial(5) = 5 * factorial(4) = 5 * 24 = 120
  * factorial(4) = 4 * factorial(3) = 4 * 6
  * factorial(3) = 3 * factorial(2) = 3 * 2
  * factorial(2) = 2 * factorial(1) = 2 * 1
  * factorial(1) = 1
  * */

  //  In scala we dont use loops or iteration, we use RECURSION!

  //  THe unit type = no meaningful value === "void"
  //  type of SIDE EFFECTS showing something on screen or passing to socket.
  println("I love Scala")

  def myUNitReturningFUnction(): Unit = {
    println("I dont love returning Unit")
  }

  val theUnit = println()
}
