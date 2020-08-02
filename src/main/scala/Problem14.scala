import scala.collection.mutable.HashMap

object Problem14 extends App {
    val upperLimit = 1000000

    def next(n: BigInt) = if (n % 2 == 0) n / 2 else 3 * n + 1

    var (finalNumber, finalLength) = (BigInt(0), BigInt(0))
    var cache = HashMap[BigInt, BigInt]()

    for (n <- upperLimit / 2 until upperLimit) {
        var (result, length) = (BigInt(n), BigInt(1))

        while (result != 1) {
            if (cache.contains(result)) {
                length += cache(result)
                result = 1
            } else {
                result = next(result)
                length += 1
            }
        }

        cache(n) = length

        if (length > finalLength) {
            finalNumber = n
            finalLength = length
        }
    }

    println(finalNumber, finalLength)
    println(finalNumber == 837799)
}
