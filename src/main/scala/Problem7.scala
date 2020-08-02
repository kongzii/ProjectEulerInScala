import scala.math
import scala.util.control.Breaks._
import scala.collection.mutable.ArrayBuffer

object Problem7 extends App {
  val limit = 10001
  var foundPrimes = ArrayBuffer[Int](2)
  var n = 1

  do {
    n += 2
    var isPrime = true

    breakable {
      for (prime <- foundPrimes) {
        if (n % prime == 0) {
          isPrime = false
          break()
        }
      }
    }

    if (isPrime && foundPrimes.last + 1 < math.floor(math.sqrt(n))) {
      breakable {
        for (i <- foundPrimes.last + 1 until n) {
          if (n % i == 0) {
            isPrime = false
            break()
          }
        }
      }
    }

    if (isPrime) {
      foundPrimes += n
    }
  } while (foundPrimes.size != limit)

  println(foundPrimes.last)
}
