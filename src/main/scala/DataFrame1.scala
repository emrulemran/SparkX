import org.apache.spark.SparkContext
import org.apache.spark.sql.SparkSession

object DataFrame1 {

  def main(args: Array[String]): Unit = {


    val spark = SparkSession.builder().appName("a").master("local[*]").getOrCreate()

    val df = spark.read.format("csv").load("data/movies.csv")
    df.show()

  }
}

