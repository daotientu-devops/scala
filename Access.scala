class Outer {

  class Inner {
    def f() {
      println("f")
    }

    class InnerMost {
      f()
    }

  }

  (new Inner).f()
}