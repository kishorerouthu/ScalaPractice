package com.scala.tutorial.ds

/**
  * Created by kishore on 13/3/17.
  */
object PromNight {

  import scala.io.StdIn.readInt
  import scala.io.StdIn.readLine
  import scala.util.Sorting.quickSort

  def main(args: Array[String]): Unit = {
      val t = readInt
      for(i <- 0 to t-1) {
          var meta = readLine.split(" ").map(_.toInt)
          var m = meta(0)
          var n = meta(1)

          val b = readLine.split(" ").map(_.toInt)
          val g = readLine.split(" ").map(_.toInt)

          var result = "";

          if (m > n) {
            result = "NO"
          } else {
            quickSort(b)
            quickSort(g)
            var k = 0;
            var l = 0;
            var found = 0;
            while (k < m && l < n) {
              if (b(k) > g(l)) {
                  k += 1
                  l += 1
                  found += 1
              } else {
                 l += 1
              }
            }
            result = if (found == m) "YES" else "NO"
          }

          println(result)
      }

  }

}
