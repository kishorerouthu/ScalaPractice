package com.scala.tutorial

/**
  * Created by kishore on 24/2/17.
  */

class Decorator(left: String, right: String) {

  def layout[A](x: A) = left + x.toString + right

}

object HigherOrderFunction extends App {

  def apply(f: Int => String, v: Int) = f(v)
  val decorator = new Decorator("[", "]")
  println(apply(decorator.layout, 7))
}
