import scala.io.StdIn.readLine
import scala.math.BigInt

object Problem3 extends App {
  var div = 2
  var n = BigInt(readLine())
  var maxFactorial = BigInt(0)

  while (n != 0 && n != 1) {
    if (n % div != 0) {
      div += 1
    } else {
      maxFactorial = n
      n = n / div

      if (n == 1) {
        println(s"Largest prime factor: $maxFactorial")
      }
    }
  }
}
