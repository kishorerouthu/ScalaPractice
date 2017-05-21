package com.scala.tutorial

/**
  * Created by kishore on 28/2/17.
  */
class Singlerton(val x:Int, val y:Int) {

}

object Singlerton {
  import math.Ordering

  implicit def iprod: Ordering[Singlerton] =
    Ordering.by(ip => (ip.x, ip.y))
}
