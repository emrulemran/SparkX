import org.apache.spark.{SparkConf, SparkContext}

object My {
  def main(args: Array[String]): Unit = {
    println(100)
    val conf = new SparkConf().
      setMaster("local[*]").
      setAppName("Get revenue per order")

    val sc = new SparkContext(conf)

    val rdd = sc.parallelize(List(1,2,3))
    rdd.foreach(println)
    println(sc.version)



  }
}
