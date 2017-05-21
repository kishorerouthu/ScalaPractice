
//def filesHere = (new java.io.File(".")).listFiles

//def fileLines(file: java.io.File) = scala.io.Source.fromFile(file).getLines().toList

/**
  *
  * If you prefer, you can use curly braces instead of parentheses to surround
  * the generators and filters. One advantage to using curly braces is that you can
  * leave off some of the semicolons that are needed when you use parentheses,
  * because as explained in Section 4.2, the Scala compiler will not infer semi-
  * colons while inside parentheses.
  */

/*def grep(pattern: String) = for {file <- filesHere
                                 if file.isFile
                                 if file.getName.endsWith(".scala")

                                 line <- fileLines(file)
                                 if line.trim.matches(pattern)
}  println (file + ": " + line)*/

  /*
  * Each time the body of the for expression executes it produces one value,
  * in this case simply file . When the for expression completes, the result
  * will include all of the yielded values contained in a single collection. The
  * type of the resulting collection is based on the kind of collections processed
  * in the iteration clauses. In this case the result is an Array[File] , because
  * filesHere is an array and the type of the yielded expression is File .
   */
/*def scalaFiles = for (file <- filesHere if file.getName.endsWith(".scala")) yield file

val forLineLengths = for { file <- filesHere
                           if file.isFile
                           if file.getName.endsWith(".scala")

                           line <- fileLines(file)
                           trimmed = line.trim
                           if trimmed.matches(".*for.*")
} yield trimmed.length


grep(".*gcd.*")*/

/*println("Scala Files \n **************")
for (scalaFile <- scalaFiles) println(scalaFile)*/

/*
println("Lengths \n ******************")
for (length <- forLineLengths) println(length)*/
