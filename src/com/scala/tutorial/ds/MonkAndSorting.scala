package com.scala.tutorial.ds

/**
  * Created by kishore on 3/3/17.
  */
object MonkAndSorting {

  def main(args: Array[String]): Unit = {
      import scala.io.StdIn._
      var n = readInt();
      var a = readLine().split(" ").map(_.toLong);
      radixSort(a, n)
  }

  def radixSort(a: Array[Long], n: Int): Unit = {
      val max = getMax(a, n);
      var exp: Long = 1;
      while (max / exp > 0) {
        countingSort(a, n, exp)
        println(a.mkString(" "))
        exp = exp * 100000;
      }
  }

  def countingSort(a: Array[Long], n: Int, exp: Long): Unit = {
      var count = new Array[Long](1000000);
      for (i <- 0 until a.length) {
        var rem: Int = ((a(i) / exp) % 100000).asInstanceOf[Int]
        count(rem) += 1
      }

      for (i <- 1 until count.length) {
        count(i) += count(i-1)
      }

      var output: Array[Long] = new Array[Long](n)
      for (i <- n-1 to 0 by -1) {
        var rem: Int = ((a(i) / exp) % 100000).asInstanceOf[Int]
         output((count(rem) -1 ).asInstanceOf[Int]) = a(i)
        count(rem) -= 1
      }

      for (i <- 0 until output.length)
        a(i) = output(i)
  }

  def getMax(a: Array[Long], n: Int): Long = {
    var max = Long.MinValue
    for (value <- a)
      max = if (value > max) value else max
    max
  }
}
