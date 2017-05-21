package com.scala.tutorial

/**
  * Created by kishore on 26/2/17.
  */
object PatternMatchTest extends App {

  def matchTest(x: Int): String = x match {
    case 1 => "One"
    case 2 => "Two"
    case _ => "many"
  }

  println(matchTest(1))

  def matchTest1(x: Any): Any = x match {
    case 1 => "one"
    case "two" => 2
    case y: Int => "scala.Int"
  }

  println(matchTest1("two"))

}
