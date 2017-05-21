
object FindLongLines {

  def main(args: Array[String]): Unit = {
     val width = args(0).toInt
     for (filename <- args.drop(1))
       LongLines.processFile(filename, width)
  }

}

object LongLines {

  import scala.io.Source;

  def processFile(filename: String, width: Int): Unit = {

    def processLine(line: String): Unit = {
      if (line.length > width)
        println(filename + ": " + line)
    }

    for (line <- Source.fromFile(filename).getLines())
      processLine(filename)
  }


}
