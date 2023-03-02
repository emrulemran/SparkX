import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.lit
import org.apache.spark.sql.functions._
object SparkSQL1 {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("a").master("local[*]").getOrCreate()

    val df = spark.read.format("csv").option("header", "true").load("data/movies.csv")
    val df1 = df.withColumn("Notes", lit("this is a comment"))

    df.printSchema()
// df1.show()
val dfs = df1.createTempView("data")

val output = spark.sql(""" SELECT * FROM data WHERE genres = 'Action' """);
    output.show()

  }
}

