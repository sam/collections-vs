import scala.util.Random

val start = System.currentTimeMillis
(1 to 100).foreach { _ =>
  val alphabet = ('a' to 'z').toArray
  val letterList = (0 to 100000).map( _ => alphabet(Random.nextInt(26)) )
  val pick = letterList.distinct(Random.nextInt(26))
  val (before, after) = letterList.partition{ _ > pick }
}
println(System.currentTimeMillis - start)