package com.scala.tutorial

/**
  * Created by kishore on 24/2/17.
  */
object AnonymousFunction {

  val plusOne = (x: Int) => x + 1

  def main(args: Array[String]): Unit = {
    println(plusOne(2))
    //args.foreach()
  }

}
