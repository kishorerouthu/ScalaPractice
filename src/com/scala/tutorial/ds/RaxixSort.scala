package com.scala.tutorial.ds

/**
  * Created by kishore on 2/3/17.
  */
object RaxixSort {

  def main(args: Array[String]): Unit = {
    import scala.io.StdIn.readInt
    import scala.io.StdIn.readLine
    val n = readInt()
    var a = readLine.split(" ").map(_.toInt);
    radixSort(a, a.length)
  }

  def radixSort(a: Array[Int], n: Int): Unit = {
    val max = getMax(a, n)
    var exp = 1
    while( max/exp > 0) {
      countingSort(a, n, exp)
      println(a.mkString(" "))
      exp = exp * 10
    }
  }

  def countingSort(a: Array[Int], n: Int, exp: Int): Unit = {

     var count = new Array[Int](10)
     for (value <- a)
       count((value/exp) % 10) += 1

     for (i <- 1 until count.length)
       count(i) += count(i-1)

     var output = new Array[Int](n)
     for (i <- n-1 to 0 by -1) {
       output( count( (a(i)/exp) % 10) - 1) = a(i)
       count( (a(i)/exp) % 10) -= 1
     }

     for (i <- 0 until output.length)
       a(i) = output(i)
  }

  def getMax(a: Array[Int], n: Int): Int = {
     var max = Int.MinValue
     for (value <- a)
       max = if(value > max) value else max
     max
  }

}
