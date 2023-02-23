import org.apache.spark.sql.SparkSession

object RDDCreation {

  def main(args: Array[String]): Unit = {


    val spark = SparkSession.builder().appName("a").master("local[*]").getOrCreate()

    // from a text file:
    var path: String = "///TextData.txt"
    var textRDD = spark.sparkContext.textFile("path")
    textRDD.foreach(println)



  }
}

