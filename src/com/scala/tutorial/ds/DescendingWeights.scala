package com.scala.tutorial.ds

/**
  * Created by kishore on 12/3/17.
  * You have been given an array A of size N and an integer K.
  * This array consists of N integers ranging from 1 to 10^7.
  * Each element in this array is said to have a Special Weight.
  * The special weight of an element a[i] is a[i]%K.
  *
  * You now need to sort this array in Non-Increasing order of the weight of each element,
  * i.e the element with the highest weight should appear first,
  * then the element with the second highest weight and so on.
  * In case two elements have the same weight, the one with the lower value should appear in the output first.
  *
  * Input Format:
  *
  * The first line consists of two space separated integers N and K.
  * The next line consists of N space separated integers denoting the elements of array A.
  *
  * Output Format:
  *
  * Print N space separated integers denoting the elements of the array in the order in which they are required.
  *
  * Constraints:
  * 1≤N≤105
  * 1≤A[i]≤107

  * Note:
  * You need to print the value of each element and not their weight.

  * SAMPLE INPUT
  * 5 2
  * 1 2 3 4 5

  * SAMPLE OUTPUT
  * 1 3 5 2 4
  */
object DescendingWeights {

  import scala.io.StdIn.readLine

  def formatBucket(bc: List[Int]) : String = {
      bc.sorted.mkString(" ") + " "
  }

  def main(args: Array[String]): Unit = {
      val meta = readLine().split(" ").map(_.toInt)
      val n = meta(0)
      val k = meta(1)

      val a = readLine().split(" ").map(_.toInt)
      val b = new Array[List[Int]](k)

      var j = 0;
      for (i <- 0 to n-1) {
        j = a(i) % k
        if (b(j) == null)
          b(j) = Nil
        b(j) = a(i) :: b(j)
      }

      b.reverse.foreach(bc => print(formatBucket(bc)))
  }
}
