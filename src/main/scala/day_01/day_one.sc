
import scala.io.Source

val path = "I:\\Scala_WP\\advent_of_code_2023_scala\\src\\main\\scala\\day_01\\"
//val file_input = path+"test_input"
val file_input = path+"day_one_input"


def readFile(fichier:String):List[String] = {
  val source = Source.fromFile(fichier)
  val lignes = source.getLines()
  val listOfLines:List[String] = lignes.toList // transforme itérable en liste
  source.close()
  listOfLines
}


val listOfNumbers = readFile(file_input).map { line =>
  val onlyDigits:String = line.filter(_.isDigit).mkString
  (onlyDigits.head.toString ++ onlyDigits.last.toString).toInt
}

listOfNumbers.sum

//val currentDirectory = new java.io.File(".").getAbsolutePath
//println("Répertoire de travail actuel : " + currentDirectory)
