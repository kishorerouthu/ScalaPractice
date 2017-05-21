package com.scala.tutorial

/**
  * Created by kishore on 19/4/17.
  */

object MatchDemo {

  def main(args: Array[String]): Unit = {
      val firstArg = if (args.length > 0) args(0) else ""

      firstArg match {
        case "salt" => println("pepper")
        case "chips" => println("salsa")
          println("salsa2")
        case "eggs" => println("bacon")
        case _ => println("hun?")
      }

    val friend = firstArg match {
      case "salt" => "pepper"
      case "chips" => "salsa"
      case "eggs" => "bacon"
      case _ => "hun?"
    }

    println(friend)
  }

}
