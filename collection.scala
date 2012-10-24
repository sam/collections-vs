import scala.util.Random

def repeat(n: Int)(f: => Unit) {
  if (n > 0) { f; repeat(n-1)(f) }
}

val start = System.currentTimeMillis
repeat(100) {
  val alphabet = ('a' to 'z').toArray
  val letterList = (0 to 100000).map( _ => alphabet(Random.nextInt(26)) )
  val pick = letterList.distinct(Random.nextInt(26))
  val (before, after) = letterList.partition{ _ > pick }
}
println(System.currentTimeMillis - start)