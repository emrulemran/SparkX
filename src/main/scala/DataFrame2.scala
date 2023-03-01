import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.lit

object DataFrame2 {

  def main(args: Array[String]): Unit = {


    val spark = SparkSession.builder().appName("a").master("local[*]").getOrCreate()

    val df = spark.read.format("csv").load("data/movies.csv")
    val df1 = df.withColumn("Notes", lit("this is a comment"))
    df1
      .show()

  }
}

