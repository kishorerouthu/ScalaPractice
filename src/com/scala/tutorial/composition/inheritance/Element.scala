package com.scala.tutorial.composition.inheritance

/**
  * Created by kishore on 21/5/17.
  */
abstract class Element {

  def contents: Array[String]
  def height: Int = contents.length
  def width: Int = if(height == 0) 0 else contents(0).length

  def above(that: Element): Element = {
    val this1 = this widen that.width
    val that1 = that widen this.width
    Element.ele(this1.contents ++ that1.contents)
  }

  /*override def beside(that: Element): Element = {
      val contents = new Array[String](this.contents.length)
      for (i <- 0 until contents.length)
        contents(i) = this.contents(i) + that.contents(i)
      new ArrayElement(contents)
  }
*/
  //alternate definition of beside
  /*  Here, the two arrays this.contents and that.contents are transformed
    into an array of pairs (as Tuple2 s are called) using the zip operator. The
    zip method picks corresponding elements in its two arguments and forms
    an array of pairs. For instance, this expression:
      Array(1, 2, 3) zip Array("a", "b")
     will evaluate to:
      Array((1, "a"), (2, "b"))*/

  def beside(that: Element): Element = {
    val this1 = this heighten that.height
    val that1 = that heighten this.height
    Element.ele(for ((line1, line2) <- this1.contents zip that1.contents ) yield line1 + line2)
  }

  private def widen(w: Int): Element =
    if (w <= width) this
    else {
      val left = Element.ele(' ', (w-width) / 2, height)
      val right = Element.ele(' ', w - width - left.width, height)
      left beside this beside right
    }

  private def heighten(h: Int): Element =
    if (h <= height) this
    else {
      val top = Element.ele(' ', width, (h - height) / 2)
      val bot = Element.ele(' ', width, h - height - top.height)
      top above this above bot
    }

  override def toString: String = contents mkString "\n"

}

object Element {

    private class ArrayElement(override val contents: Array[String]) extends Element

    private class LineElement(line: String) extends Element {
      override def contents = Array(line)
      override def width = line.length
      override def height = 1
    }

    private class UniformElement(ch: Char, override val width: Int, override val height: Int) extends Element {
      private val line = ch.toString * width
      override def contents = Array.fill(height)(line)

    }

    def ele(contents: Array[String]): Element = new ArrayElement(contents)

    def ele(ch: Char, width: Int, height: Int): Element = new UniformElement(ch, width, height)

    def ele(line: String): Element = new LineElement(line)
}
