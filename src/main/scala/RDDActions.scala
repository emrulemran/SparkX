import org.apache.spark.sql.SparkSession

object RDDActions {
  def main(args: Array[String]): Unit = {


    val spark = SparkSession.builder().appName("transform").master("local").getOrCreate()

    val sc = spark.sparkContext
    sc.setLogLevel("debug")

    // creating an RDD
    val RDD = sc.parallelize(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13), 100)


    println("Item count: " + RDD.count())



    println("Number of partitions: " + RDD.getNumPartitions)

    println("Number of partitions after coalesce: " + RDD.repartition(200).getNumPartitions)






  }

}
