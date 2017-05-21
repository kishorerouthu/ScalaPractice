package com.scala.tutorial.composition.inheritance

/**
  * Created by kishore on 21/5/17.
  */
object Layout {

  def main(args: Array[String]): Unit = {
    val ele1: Element = Element.ele(Array("1", "2", "3"))
    val ele2: Element = Element.ele(Array("a", "b", "c"))

    val result: Element = ele1.above(ele2);
    println(result.toString)
  }

}
