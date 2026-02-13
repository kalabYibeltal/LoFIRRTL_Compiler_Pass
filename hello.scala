//> using scala 3.8.1
package com.rockthejvm

object Playground extends App {
    println("Hello, World!")
    // define a value
    val meaningOfLife: Int = 42 // const in meaningOfLife = 42 no reasining
    val aBoolean = false
    // no need to specify type, its optional most of the time
    // Int, Boolean , Char, Double , Float, String
    val aString= "I love Scala not"
    val aComposedString = "I" + "am" 
    val anInterpolatedString =  "the vale is $variable"

    // expressions = structers that can be reduced to a value
    val anExpressions = 2 + 3
    // unlike other programs we think of values in scala instead of instructions

    // if is an expression
    val ifExpression = if (meaningOfLife > 43) 56 else 999, // in others it is ternery operators
    val chainofExpressions = 
        if (meaningOfLife > 23) 56
        else if (meaningOfLife < 0) - 2
        else 0
    // code blocks are also expressions
    val aCodeBlock = {
        //defnitions
        val aLocalValue = 67

        // last expresion is value of the code block 
        aLovalValue + 3 
    }

    // functions
    def myFunction(x: Int, y:string): String = y + "" + x
    def myFunction(x: Int, y:string): String = {
        y + x
    }

    def factorial(n: Int): Int = 
        if (n <=1) 1
        else n * factorial(n-1)
    // no loops or iteration or variables
    // the Unit type = no meaning value == "void"
    // type of SIDE EFFECTS = not neccessary for calculation
    def unitReturtning(): Unit = {
        println("sdf")
    }

    val theUnit = ()


}

object ObjectOrientation extends App {

    // class and instance
    class Animal
        val age: Int = 0
        def eat() = println()
    val anAnimal  = new Animal

    // inheritance
    class Dog(name:String) extends Animal {}
    val aDog = new Dog("bob")

    // constructor arguments are not fields, unless val is putted before the constructor argument
    // aDog.name is not allowed

    // subtype polymorhism
    val aDeclaredAnimal: Animal = new Dog("hatchi")

    aDeclaredAnimal.eat() // the most derived method will be called

    // abstract class
    abstract class WalkingAnimal {
        val hasLegs = true
        def walk(): Unit
        // all areby default public unles private or protected 
        // private only class, protected includes decendants
    }

    // interface = ultimate abstract type
    trait Crnivore {
        def eat(animal: Animal): Unit
    }
    trait Philosopher {
        def ?!(thought: String): Unit
        // valid method name, often used in asynchronous programming, but not recommended for general use
    }
    // single class inheretance multi-traint "mixing"
    //  class Crocodile extends Animal with carniover with ...
    aCroc.eat(aDog)
    aCroc eat aDog // only for methods with single parameter, infix notation    

    val anaotherBasicMath = 1.+ (2) // infix notation also works with operators, but not recommended for general use


    // singelton Object
    object MySingleton {
        val mySpecialValue = 53278
        def mySpecialMethod(): Int = 5327
        def apply(x: Int): Int = x + 1
    }
    object Animal { // companion object can access private fields and methods of the class
        def canLiveInWater: Boolean = false
    }

    // exceptions
    try {
        // code that might throw an exception
    } catch {
        case e: ExceptionType => // handle exception
    } finally {
        // code that will always execute, even if an exception is thrown
    } 
    // generics
    abstract class MyList[T] {
        def head: T
        def tail: MyList[T]
    }
    val aList: List[Int] = List(1,2,3) // List is a generic class provided by the Scala standard library
    val first =  aList.head
    val rest = aList.tail
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



    class Person(name: String, age: Int) {
         def apply(age: Int): Unit = println(s"I have aged $age years")
    }

    // FunctionX
    val anIncrementer: Function1[Int, Int] = new Function1[Int, Int] {
    override def apply(x: Int): Int = x + 1
    // functionX 1 - 22
    // higher order functions: take functions as parameters or return functions as results
    // give me exapmle of .map .filter .flatMap
    val aMappedList = List(1,2,3).map(x => x + 1) // List(2,3,4)
    val aFilteredList = List(1,2,3).filter(x => x % 2 == 0) // List(2)
    val aFlatMappedList = List(1,2,3).flatMap(x => List(x, x * 10)) // List(1,10,2,20,3,30)
    // for-comprehensions
    val aForComprehension = for {
        x <- List(1,2,3)
        y <- List("a", "b", "c")
    }yield s"$x-$y" // List("1-a", "1-b", "1-c", "2-a", "2-b", "2-c", "3-a", "3-b", "3-c")
    //equivalent to
    val allPairs  = List(1,2,3).flatMap(x => List("a", "b", "c").map(y => s"$x-$y"))
    //List vs sequences vs vectors vs sets 
    val aSequence: Seq[Int] = Seq(1,2,3) // ordered, indexed, immutable
    val aVector: Vector[Int] = Vector(1,2,3) // immutable, indexed, good for large collections
    val aSet: Set[Int] = Set(1,2,3) // unordered, no duplicates
    // map
    val aMap: Map[String, Int] = Map("one" -> 1, "two" -> 2, "three" -> 3) // key-value pairs
    val Amap: Map[Int, String] = Map((1, "one"), (2, "two"), (3, "three")) // alternative syntax
    // pattern matching
    val anOption: Option[Int] = Some(42) // can also be None
    val anOptionMatch = anOption match {
        case Some(value) => s"The value is $value"
        case None => "No value"
    }
    // pattern matching without Option
    val x: Int = 2
    val xMatch = x match {
        case 1 => "one"
        case 2 => "two"
        case 3 => "three"
        case _ => "other" // wildcard pattern
    }

    // monads: Option, Try, Future
    val aTry: Try[Int] = Try(42 / 0) // will be Failure(java.lang.ArithmeticException: / by zero)
    val aTryMatch = aTry match {    
        case Success(value) => s"The value is $value"
        case Failure(exception) => s"An error occurred: ${exception.getMessage}"
    }

    // implicits codes are crazy
    // type encrichment

 }
