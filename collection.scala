import scala.util.Random

def repeat(n: Int)(f: => Unit) {
  if (n > 0) { f; repeat(n-1)(f) }
}

val start = System.currentTimeMillis
repeat(100) {
  var letterList: List[Char] = List()
  val alphabet = ('a' to 'z').toArray
  repeat(100000){ letterList = alphabet(Random.nextInt(26)) :: letterList }
  val pick = letterList.distinct(Random.nextInt(26))
  val (before, after) = letterList.partition{ _ > pick }
}
println(System.currentTimeMillis - start)