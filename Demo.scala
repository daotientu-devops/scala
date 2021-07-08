import java.io._;
import scala.io.Source;
import Run._;
import Array._;
import scala.util.matching.Regex

trait Equal {
  def isEqual(x: Any): Boolean

  def isNotEqual(x: Any): Boolean = !isEqual(x)
}

trait Printable extends Any {
  def print(): Unit = println(this)
}

class Wrapper(val underlying: Int) extends AnyVal with Printable

// Class
class Point(val xc: Int, val yc: Int) {
  var x: Int = xc
  var y: Int = yc

  def move(dx: Int, dy: Int) {
    x = x + dx
    y = y + dy
    println("Point x location: " + x);
    println("Point y location: " + y);
  }

  def isEqual(obj: Any) = obj.isInstanceOf[Point] && obj.asInstanceOf[Point].x == y
}

// Extending class
class Location(override val xc: Int, override val yc: Int, val zc: Int) extends Point(xc, yc) {
  var z: Int = zc

  def move(dx: Int, dy: Int, dz: Int) {
    x = x + dx
    y = y + dy
    z = z + dz
    println("Point x location: " + x);
    println("Point y location: " + y);
    println("Point z location: " + z);
  }
}

// Object
object Demo {
  def main(args: Array[String]) {
    val pt = new Location(10, 20, 15);
    //Move to a new location
    pt.move(10, 10, 5);
    4 times println("hello")
    val point = new Point(10, 20);
    printPoint

    def printPoint {
      println("Point x location: " + point.x);
      println("Point y location: " + point.y);
    }

    var x = 30;
    var y = 20;
    if (x < 20) {
      println("This is if statement");
    } else {
      println("This is else statement");
    }
    if (x == 10) {
      println("Value of X is 10");
    } else if (x == 20) {
      println("Value of X is 20");
    } else if (x == 30) {
      println("Value of X is 30");
    } else {
      println("This is else statement");
    }
    if (x == 30) {
      if (y == 10) {
        println("X=30 and Y=10");
      }
    }
    var a = 10;
    // An infinite loop
    //while (true) {
    //println("Value of a: " + a);
    //}
    // Function
    println("Returned value: " + addInt(5, 7));
    // Print closure
    println("Multiple(1) value = " + multiplier(1))
    println("Multiple(2) value = " + multiplier(2))
    var greeting: String = "Hello, world";
    println(greeting)
    var palindrome = "Dot saw I was Tod";
    var len = palindrome.length();
    println("String length is: " + len);
    // Concatenating strings
    var str1 = "Dot saw I was ";
    var str2 = "Tod";
    println("Dot" + str1 + str2);
    // Creating format strings
    var floatVar = 12.456
    var intVar = 2000
    var stringVar = "Hello Scala!"
    var fs = printf("The value of the float variable is " + "%f, while the value of the integer " + "variable is %d, and the string " + "is %s", floatVar, intVar, stringVar);
    println(fs)
    // the 's' string interpolator
    var name = "James"
    println(s"Hello,$name")
    println(s"1+1=${1 + 1}")
    // The 'f' interpolator allows to create a formatted string, similar to printf in C language
    val height = 1.9d;
    println(f"$name%s is $height%1.1f meters tall")
    // 'raw' interpolator
    println(s"Result = \n a \n b")
    // Array
    // Processing arrays
    var myList = Array(1.0, 2.9, 3.4, 3.5)
    //Print all the array elements
    for (x <- myList) {
      println(x)
    }
    //Summing all elements
    var total = 0.0;
    for (i <- 0 to (myList.length - 1)) {
      total += myList(i);
    }
    //Finding the largest element
    var max = myList(0);
    for (i <- 1 to (myList.length - 1)) {
      if (myList(i) > max) max = myList(i);
    }
    println("Max is " + max)
    // Multi-dimensional arrays
    var myMatrix = ofDim[Int](3, 3)
    // Build a matrix
    for (i <- 0 to 2) {
      for (j <- 0 to 2) {
        myMatrix(i)(j) = i
      }
    }
    // Print two dimensional array
    for (i <- 0 to 2) {
      for (j <- 0 to 2) {
        print(" " + myMatrix(i)(j));
      }
      println();
    }
    // Concatenate arrays
    var myList1 = Array(1.9, 2.9, 3.4, 3.5)
    var myList2 = Array(8.9, 7.9, 0.4, 1.5)
    var myList3 = concat(myList1, myList2)
    // Print all the array elements
    for (x <- myList3) {
      println(x)
    }
    // Create array with range
    var myList4 = range(10, 20, 2)
    var myList5 = range(10, 20)
    // Print all the array elements
    for (x <- myList4) {
      print(" " + x)
    }
    println()
    for (x <- myList5) {
      print(" " + x)
    }
    // Trait
    val p1 = new Point(2, 3)
    val p2 = new Point(2, 4)
    val p3 = new Point(3, 3)
    println()
    println(p1.isEqual(p2));
    println(p1.isEqual(p3));
    println(p1.isEqual(2));
    val w = new Wrapper(3)
    w.print() // actually requires instantiating a Wrapper instance
    println(matchTest(3))
    println(matchTest("two"))
    println(matchTest("test"))
    println(matchTest(1))
    val alice = new Person("Alice", 25)
    val bob = new Person("Bob", 32)
    val charlie = new Person("Charlie", 32)
    for (person <- List(alice, bob, charlie)) {
      person match {
        case Person("Alice", 25) => println("Hi Alice!")
        case Person("Bob", 32) => println("Hi Bob!")
        case Person(name, age) => println("Age: " + age + " year, name: " + name + "?")
      }
    }
    // Regular expression
    val pattern = "scalable".r;
    val str = "Scala is scalable and cool"
    println(pattern findFirstIn str)
    val pattern1 = new Regex("(S|s)cala")
    val str3 = "Scala is scalable and cool";
    println((pattern1 findAllIn str3).mkString(","))
    val pattern2 = "(S|s)cala".r;
    val str4 = "Scala is scalable and cool";
    println(pattern2 replaceFirstIn(str4, "Java"))
    val pattern3 = new Regex("abl[ae]\\d+")
    val str5 = "ablaw is able1 and cool"
    println((pattern3 findAllIn str5).mkString(","))
    // Exception Handling
    try {
      val f = new FileReader("input.txt")
    } catch {
      case ex: FileNotFoundException => {
        println("Missing file exception")
      }
      case ex: IOException => {
        println("IO Exception")
      }
    } finally {
      println("Exiting finally...")
    }
    println("Apply method: " + apply("Zara", "gmail.com"))
    println("Unapply method: " + unapply("Zara@gmail.com"))
    println("Unapply method: " + unapply("Zara Ali"))
      // I/O file
      val writer = new PrintWriter(new File("test.txt"))
      writer.write("Hello Scala")
      writer.close()
      // Reading file content
      print("Following is the content read: ")
        Source.fromFile("test.txt").foreach{
            print
        }
  }

  // The injection method (optional)
  def apply(user: String, domain: String) = {
    user + "@" + domain
  }

  // The extraction method (mandatory)
  def unapply(str: String): Option[(String, String)] = {
    val parts = str split "@"
    if (parts.length == 2) {
      Some(parts(0), parts(1))
    } else {
      None
    }
  }

  // Pattern matching
  def matchTest(x: Any): Any = x match {
    case 1 => "one"
    case "two" => 2
    case y: Int => "scala.Int"
    case _ => "many"
  }

  case class Person(name: String, age: Int)

  def addInt(a: Int, b: Int): Int = {
    var sum: Int = 0;
    sum = a + b;
    return sum;
  }

  // Closure
  /**
   * A closure is a function, whose return value depends on the value of one or more variables declared outside this function
   */
  var factor = 3
  val multiplier = (i: Int) => i * factor
}