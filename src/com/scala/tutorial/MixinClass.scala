package com.scala.tutorial

/**
  * Created by kishore on 23/2/17.
  */

abstract class AbsIterator {

  type T
  def hasNext: Boolean
  def next: T

}

trait RichIterator extends AbsIterator {

  def foreach(f: T => Unit) = { while (hasNext) f(next) }

}

class StringIterator(s: String) extends AbsIterator {

  type T = Char
  private var i = 0
  override def hasNext = i < s.length
  override def next = {
    var ch = s.charAt(i)
    i += 1
    ch
  }
}

object MixinClass {

    def main(arrgs : Array[String]): Unit = {

      class Iter extends StringIterator("kishore") with RichIterator{}

      var iter = new Iter
      iter foreach println
    }
}
