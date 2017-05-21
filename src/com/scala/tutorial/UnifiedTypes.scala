package com.scala.tutorial

/**
  * Created by kishore on 23/2/17.
  */
object UnifiedTypes extends App {

  val list: List[Any] = List(
    "a String",
    732, //an  integer
    'c',  //a character
    true, //a boolean value
    () => "an anonymous function returning a string"
  )

  list.foreach(element => println(element))

}
