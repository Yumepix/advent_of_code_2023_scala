package day_02
import scala.io.Source
import scala.util.matching.Regex

// java 17
object Main {


//  val path = "I:\\Scala_WP\\advent_of_code_2023_scala\\src\\main\\scala\\day_02\\"
  val file_input = "day_two_input"
//  val file_input = "test_input"
  //val file_input = path+"day_two_input"

  val list_of_letter_numbers = List(
    ("one" -> 1),
    ("two" -> 2),
    ("three" -> 3),
    ("four" -> 4),
    ("five" -> 5),
    ("six" -> 6),
    ("seven" -> 7),
    ("eight" -> 8),
    ("nine" -> 9)
  )

  def readFile(fichier: String): List[String] = {
    val source = Source.fromFile(fichier)
    val lignes = source.getLines()
    val listOfLines: List[String] = lignes.toList // transforme itérable en liste
    source.close()
    listOfLines
  }


  def getListOfLetterNumberIndex(line: String, letter_number: String, nb: String): List[(Int,String)] = {

    var listOfIndexL:List[(Int,String)] = List()
    var listOfIndexN:List[(Int,String)] = List()
    // si on trouve au moins une occurence du nombre
    if (line.indexOf(letter_number) > -1) {
      val regex = letter_number.r // transforme le string en regex
      val matchNumber = regex.findAllMatchIn(line) // trouve toutes les occurences
      // pour chaque occurrence renvoie l'index associé au nombre
      listOfIndexL = matchNumber.map(num => (num.start -> nb)).toList
    }

    if (line.indexOf(nb) > -1) {
      val regex = nb.r
      val matchNumber = regex.findAllMatchIn(line)
      listOfIndexN = matchNumber.map(num => (num.start -> nb)).toList
    }

    listOfIndexL ++ listOfIndexN

  }

  def getListOfIndexes(regex: Regex, ligne:String,letter_number: String, nb: String) = {
    val matchNumber = regex.findAllMatchIn(ligne) // trouve toutes les occurences
    // pour chaque occurrence renvoie l'index associé au nombre
    matchNumber.map(num => (num.start -> nb)).toList
  }


  def main(args: Array[String]): Unit =
  {


    val getListOfNumberIndexes = readFile(file_input).map { line =>

      // retourne la liste des (index, number) pour les lettres
      val allIndexes = list_of_letter_numbers.flatMap { letter_number =>
        getListOfLetterNumberIndex(line, letter_number._1,letter_number._2.toString)
      }

      val orderedList = allIndexes.sortBy(_._1)
      (orderedList.head._2 ++ orderedList.last._2).toInt

    }

    println(getListOfNumberIndexes.sum)
  }

// 55902
}
