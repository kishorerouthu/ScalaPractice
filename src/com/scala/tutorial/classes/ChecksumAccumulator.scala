package com.scala.tutorial.classes

/**
  * Created by kishore on 15/3/17.
  */
class ChecksumAccumulator  {

  private var sum = 0

  def add(b: Byte) =  sum += b
  def checkSum = ~(sum & 0xFF) + 1

}

object ChecksumAccumulator {
    import scala.collection.mutable.Map

    private val cache = Map[String, Int]()

    def cacluate(s: String): Int = {

        if (cache.contains(s))
          cache(s)
        else {
            val acc = new ChecksumAccumulator

            for (c <- s)
              acc.add(c.toByte)

            val cs = acc.checkSum
            cache += (s -> cs)
            cs
        }
    }
}

object Test {
  def main(args: Array[String]): Unit = {
    for (arg <- args)
      println(arg + " : " + ChecksumAccumulator.cacluate(arg))
  }
}
