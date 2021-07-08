class Student() {
  var id: Int = 0
  var age: Int = 0

  def studentDetails(i: Int, a: Int): Unit = {
    id = i
    age = a
    println("Student Id is: " + id);
    println("Student Age is: " + age);
  }
}

object HelloWorld {
  /* This is my first java program
  * This will print 'Hello World' as the output
   */
  def main(args: Array[String]) {
    println("Hello, World!"); // prints Hello World
    var stu = new Student();
    stu.studentDetails(10, 8);
    var myVar: Int = 10;
    val myVal: String = "Hello Scala with datatype declaration.";
    var myVar1 = 20;
    val myVal1 = "Hello Scala new without datatype declaration.";
    println(myVar);
    println(myVal);
    println(myVar1);
    println(myVal1);
  }
}