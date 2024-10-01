package scalafunctions

import org.apache.spark.sql.{ SparkSession, functions }
import org.apache.spark.sql.functions.udf
import org.apache.spark.sql.functions.col
import org.apache.spark.sql.types.StringType
object TestUDF {
  def main(args: Array[String]): Unit = {
    var spark = SparkSession.builder().appName("udfdemo").master("local[*]").getOrCreate()
    var df = spark.read
      .option("inferSchema", true)
      .option("header", true)
      .csv("D://Data Science//sample data//PoliceData.csv")
    df.show()

    val shortCat = udf((category: String) => category.substring(0, 4))
    spark.udf.register("cat", shortCat)
    
    println(shortCat.getClass)
    
    val resultDF = df.withColumn("shortCated", shortCat(df("Category")))
    resultDF.show()
  }
}
