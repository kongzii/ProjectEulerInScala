import math._

object Problem9 extends App {
  def square(x: Int) = pow(x, 2)

  var c = 1
  var nResults = 0

  while (nResults == 0) {
    for (b <- c - 1 to 1 by -1) {
      for (a <- b - 1 to 1 by -1) {
        if (square(a) + square(b) == square(c) && a + b + c == 1000) {
          nResults += 1
          println(a, b, c)
          println(Array(a, b, c).product)
        }
      }
    }

    c += 1
  }
}
