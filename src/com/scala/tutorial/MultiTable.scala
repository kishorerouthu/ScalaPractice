
/**
  * Created by kishore on 20/4/17.
  */


//Returns row as sequence
/*def makeRowSeq(row: Int) =
for (col <- 1 to 10) yield {
  val prod =  (row * col).toString
  val padding = " " * (4 - prod.length)
  padding + prod
}*/

//Returns row as a string
/*def makeRow(row: Int) = makeRowSeq(row).mkString*/

//Returns table as string with one row per line
/*def multiTable = {
  val tableSeq = for (row <- 1 to 10) yield makeRow(row)
  println(tableSeq.mkString("\n"))
}*/

/*multiTable*/

