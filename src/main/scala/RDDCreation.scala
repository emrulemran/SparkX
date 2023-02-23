import org.antlr.v4.runtime.atn.SemanticContext.AND
import org.apache.spark.sql.SparkSession

object RDDCreation {

  def main(args: Array[String]): Unit = {


    val spark = SparkSession.builder().appName("a").master("local[*]").getOrCreate()

    spark.sparkContext.setLogLevel("ERROR")

    // from a text file:
    var path: String = "data/TextData.txt"
    var textRDD = spark.sparkContext.textFile(path)
    textRDD.foreach(println)

    println("-------------------------------------------------------------------------")

    // by parallelizing a collection
    var cittList: List[String] = List("boston", "san jose", "miami", "oklahoma")

    var cityRDD = spark.sparkContext.parallelize(cittList)
    cityRDD.foreach(println)
    println("-------------------------------------------------------------------------")

    // by transforming an existing RDD:
    var numList: List[Double] = List(12, 45, 67, 89, 45, 45, 76, 34, 3, 76, 34, 35, 576, 74, 345, 79, 87, 14, 85)
    var numRDD = spark.sparkContext.parallelize(numList)
    var outputRDD = numRDD.map(x => x/5)
    outputRDD.foreach(println)
    println("-------------------------------------------------------------------------")


  }
}

