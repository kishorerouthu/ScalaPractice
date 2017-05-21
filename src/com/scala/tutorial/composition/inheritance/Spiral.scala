package com.scala.tutorial.composition.inheritance

/**
  * Created by kishore on 21/5/17.
  */
object Spiral {
    import Element.ele

    val space = ele(" ")
    val corner = ele("+")

    def spiral(nEdges: Int, direction: Int): Element = {
      if (nEdges == 1)
        corner
      else {
        val sp = spiral(nEdges - 1, (direction + 3) % 4)
        def verticalBar = ele('|', 1, sp.height)
        def horizontalBar = ele('-', sp.width, 1)
        if (direction == 0)
          (corner beside horizontalBar) above (sp beside space)
        else if (direction == 1)
          (sp above space) beside (corner above verticalBar)
        else if (direction == 2)
          (space beside sp) above (horizontalBar beside corner)
        else
          (verticalBar above corner) beside (space above sp)
      }
    }

  def main(args: Array[String]): Unit = {
    println(spiral(11, 0))
  }

}
