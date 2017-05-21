package com.scala.tutorial

/**
  * Created by kishore on 23/2/17.
  */
object Classes {

  def main(args: Array[String]): Unit = {

    val p1 = new Point(1, 2)
    println(p1)
    p1.move(10, 10)
    println(p1)

  }

}

class Point(var x: Int, var y: Int) {

  def move(xc: Int, yc: Int): Unit = {
      x = x + xc
      y = y + yc
  }

  override def toString: String = "(" + x + ", " + y + ")"

}
