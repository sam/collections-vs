package benchmarks

import annotation.tailrec
import com.google.caliper.Param

import scala.util.Random

class Benchmark extends SimpleScalaBenchmark {

  import java.util.UUID
  import scala.collection.mutable.MutableList

  @Param(Array("10000", "100"))
  val length: Int = 0

  val alphabet = ('a' to 'z').toArray

  def timePartition(reps:Int) = repeat(reps) {
    val letterList = (0 to 100000).map( _ => alphabet(Random.nextInt(26)) )
    val pick = letterList.distinct(Random.nextInt(26))
    val (before, after) = letterList.partition{ _ > pick }
    before // Return a value so the work isn't optimized away...
  }

}