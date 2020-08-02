import scala.math._

object Problem6 extends App {
  val n = 100
  val totalSum = (n * (n + 1)) / 2
  val sumOfSquares = (1 to 100).map(pow(_, 2)).sum
  val squareOfTheSum = pow(totalSum, 2)
  println(squareOfTheSum - sumOfSquares)
}
