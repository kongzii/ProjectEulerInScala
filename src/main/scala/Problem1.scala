object Problem1 extends App {
  val numbers =
    for (
      i <- 1 until 1000
      if i % 3 == 0 || i % 5 == 0
    ) yield i
  val solution = numbers.sum
  println(solution)
}
