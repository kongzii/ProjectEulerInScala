import scala.collection.mutable.ArrayBuffer

object Problem12 extends App {
  def factorize(n: Int): Option[ArrayBuffer[Int]] = {
    var div = 2
    var number = n
    var factors = ArrayBuffer[Int]()

    while (number != 0 && number != 1) {
      if (number % div != 0) {
        div += 1
      } else {
        factors += div
        number /= div

        if (number == 1) {
          return Some(factors)
        }
      }
    }

    None
  }

  def work(
      nDivisors: Int,
      triangleNumber: Int = 1,
      previousSum: Int = 0
  ): Tuple2[Int, Int] = {
    val currentSum = previousSum + triangleNumber

    factorize(currentSum) match {
      case None => work(nDivisors, triangleNumber + 1, currentSum)
      case Some(factors) => {
        // https://www.math.upenn.edu/~deturck/m170/wk2/numdivisors.html
        val divisors =
          factors.groupBy(identity).values.map(_.size + 1).reduce(_ * _)

        if (divisors > nDivisors)
          (triangleNumber, currentSum)
        else
          work(nDivisors, triangleNumber + 1, currentSum)
      }
    }
  }

  println(work(500))
}
