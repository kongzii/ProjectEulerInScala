object Problem2 extends App {
  var solution = 2
  var (prevPrevValue, prevValue, newValue) = (1, 2, 0)

  while (newValue < 4000000) {
    newValue = prevPrevValue + prevValue

    if (newValue % 2 == 0) {
      solution += newValue
    }

    prevPrevValue = prevValue
    prevValue = newValue
  }

  println(solution)
}
