package com.scala.tutorial

/**
  * Created by kishore on 22/2/17.
  */
 class Point1(xc: Int, yc: Int) extends Similarity {

  var x: Int = xc;
  var y: Int = yc;

  def isSimilar(obj: Any) =
    obj.isInstanceOf[Point] && obj.asInstanceOf[Point].x == x


}

object TraitTest extends App {

  val p1 = new Point1(2, 3);
  val p2 = new Point1(2, 4);
  val p3 = new Point1(3, 3);
  val p4 = new Point1(2, 3);

  println(p1.isSimilar(p2))
  println(p1.isSimilar(p3))

  println(p1.isNotSimilar(p2))
  println(p1.isNotSimilar(p4))
  println(p1.isNotSimilar(p3))
}
