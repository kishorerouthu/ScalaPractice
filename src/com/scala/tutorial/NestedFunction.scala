package com.scala.tutorial

/**
  * Created by kishore on 24/2/17.
  */
object NestedFunction extends App {

  def filter(xs: List[Int], threashold: Int) = {

      def process(ys: List[Int]): List[Int] = {
        if (ys.isEmpty) ys
        else if (ys.head < threashold) ys.head :: process(ys.tail)
        else process(ys.tail)
      }
      process(xs)
  }

  println(filter(List(1, 9, 2, 8, 3, 7, 4), 5))

}
