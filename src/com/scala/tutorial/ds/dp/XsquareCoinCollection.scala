package com.scala.tutorial.ds.dp

/**
  * Created by kishore on 28/4/17.
  *
  * Xsquare loves to play with the coins very much. Today , he has N stacks of coins .
  * Each stack of coins has some non zero height Hi equal to the number of coins on that stack
  * ( considering all the coins are identical and each coin has a height of 1 unit ) .
  *
  * In one move, Xsquare can select any number of consecutive stacks of coins such that the height of each selected stack of coins Hi ≤ K .
  * Once such a sequence of stacks is chosen , Xsquare can collect any number of coins from the chosen sequence of stacks .
  *
  * Xsquare wonders what is the maximum number of coins that he can collect this way ?
  *
  * INPUT
  *
  * First line of input contains a single integer T denoting the number of test cases .
  * First line of each test case contains two space separated integers N and K where N being the number of stacks of coins.
  * Second line of each test case contains N space separated integers denoting the number of coins Hi on each stack .
  *
  * OUTPUT
  * For each test case , Print the maximum number of coins Xsquare can collect following the above gaming strategy.
  *
  * CONSTRAINTS
  * 1 ≤ T ≤ 105
  * 1 ≤ N ≤ 105
  * 1 ≤ K ≤ 109
  * 1 ≤ Hi ≤ 109
  *
  * Note :
  *
  * sum of N over all the test case will not exceed 106.
  *
  * SAMPLE INPUT
  * 2
  * 8 1
  * 3 2 2 3 1 1 1 3
  *
  * 8 2
  * 3 2 2 3 1 1 1 3
  *
  * SAMPLE OUTPUT
  * 3
  * 4
  *
  * Explanation
  * Test 1 : N = 8 , K = 1 3 2 2 3 1 1 1 3 We can collect coins from stacks numbered 5 , 6 and 7 .
  * Test 2 : N = 8 , K = 2 3 2 2 3 1 1 1 3 We can collect coins from stacks numbered 2 and 3 .
  * Algorithm :
  *
  * findMaxCoins(a[], n, k) {
  *
  * sum1 = 0
  * sum2 = 0
  * for (i from 0 to n) {
  * if (a[i] <= k)
  * sum2 += a[i]
  * else {
  * sum1 = max (sum1, sum2)
  * sum2 = 0
  * }
  * }
  *
  * return max(sum1, sum2);
  * }
  *
  * Example :
  * 8 2
  * 3 2 2 3 1 1 1 3
  *
  * n=8
  * k=2
  * sum1=0
  * sum2=0
  *
  * i=0 sum2=0 sum1=0
  * i=1 sum2=2 sum1=0
  * i=2 sum2=4 sum1=0
  * i=3 sum2=0 sum1=4
  * i=4 sum2=1 sum1=4
  * i=5 sum2=2 sum1=4
  * i=6 sum2=3 sum1=4
  * i=7 sum2=0 sum1=4
  */

object XsquareCoinCollection {

  def main(args: Array[String]): Unit = {
    import scala.io.StdIn._

    val t = readInt()
    for (i <-1 to t) {
      val input = readLine().split(" ")
      val k = input(1).toLong
      var a = readLine().split(" ").map(_.toLong)
      val result = findMaxCoins(a, k)
      println(result)
    }
  }

  def findMaxCoins(a: Array[Long], k: Long): Long = {
      var sum1 :Long = 0
      var sum2 :Long = 0
      for (ai <- a) {
        if (ai <= k) {
          sum2 += ai
        } else {
          sum1 = Math.max(sum1, sum2)
          sum2 = 0
        }
      }
    Math.max(sum1, sum2)
  }

}
