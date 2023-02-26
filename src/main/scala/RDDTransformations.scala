import org.apache.spark.sql.SparkSession

object RDDTransformations {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("transform").master("local[*]").getOrCreate()

    spark.sparkContext.setLogLevel("debug")

    // creating an RDD
    val RDD = spark.sparkContext.parallelize(List(1, 2, 3, 4, 3, 2, 4, 1, 43, 34, 3, 43, 12, 3))

    // filter example:
    // println(RDD.filter(x => x > 5).count())


    // map example:
    val mapRDD = RDD.map(x => x * 5)
    mapRDD.foreach(println)


  }

}
