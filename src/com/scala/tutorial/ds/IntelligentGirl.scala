package com.scala.tutorial.ds

/**
  * Created by kishore on 19/4/17.
  */
object IntelligentGirl {

  def main(args: Array[String]): Unit = {
    import scala.io.StdIn.readLine

    var count: Int = 0
    var result: List[Int] = List()
    for(data <- readLine().reverse.toList ) {
        count = if (data.toByte%2 == 0) count + 1 else  count
        result =  count :: result
    }
    println(result.mkString(" "));
  }

}
