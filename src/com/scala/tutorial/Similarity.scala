package com.scala.tutorial

/**
  * Created by kishore on 22/2/17.
  */
trait Similarity {

  def isSimilar(x: Any): Boolean

  def isNotSimilar(x: Any): Boolean = !isSimilar(x)

}
