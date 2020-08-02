import scala.util.control.Breaks._

object Problem5 extends App {
  var n: BigInt = 0
  var success = false
  val dividers = (1 to 20).toArray.map(BigInt(_))

  while (!success) {
    n += 20
    success = true

    breakable {
      for (divider <- dividers) {
        if (n % divider != 0) {
          success = false
          break
        }
      }
    }
  }

  println(n)
}
