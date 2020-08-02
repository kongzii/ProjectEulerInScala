import scala.math

object Problem10 extends App {
  def getP(
      sequence: Array[Int],
      index: Int,
      size: Int,
      limit: Int
  ): Option[Int] = {
    if (index > size) {
      return None
    }

    if (sequence(index) > math.sqrt(limit)) {
      return None
    }

    if (!marks(index)) {
      return Some(sequence(index))
    }

    getP(sequence, index + 1, size, limit)
  }

  def filterPrimes(
      sequence: Array[Int],
      marks: Array[Boolean],
      limit: Int,
      lastP: Int = 1
  ): Array[Int] = {
    getP(sequence, lastP - 1, marks.size, limit) match {
      case None => (sequence, marks).zipped.filter((n, m) => !m)._1
      case Some(p) => {
        for (index <- (2 * p - 2) until limit - 1 by p) marks(index) = true
        filterPrimes(sequence, marks, limit, p)
      }
    }
  }

  val limit = 2000000
  var sequence = (2 to limit).toArray
  var marks = Array.fill(limit - 1)(false)

  val primes = filterPrimes(sequence, marks, limit)

  println(primes.view.map(BigInt(_)).reduce(_ + _))
  println(primes.view.map(BigInt(_)).reduce(_ + _) == BigInt("142913828922"))
}
