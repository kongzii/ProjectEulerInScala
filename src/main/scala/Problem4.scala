object Problem4 extends App {
  def findLargestPalindrome(): Int = {
    var largest = 0

    for (i <- 999 to 100 by -1) {
      for (j <- i to 100 by -1) {
        val v = i * j
        val x = v.toString()

        if (x == x.reverse && v > largest) {
          largest = v
        }
      }
    }

    largest
  }

  println(findLargestPalindrome())
}
