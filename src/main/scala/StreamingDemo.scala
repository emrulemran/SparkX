import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{StructField, StructType}
import org.apache.spark.sql.types.StringType
import org.apache.spark.sql.functions._



object StreamingDemo {

  def main(args: Array[String]): Unit = {


    val spark = SparkSession.builder().appName("a").master("local[*]").getOrCreate()


    spark.sparkContext.setLogLevel("ERROR");

    import spark.implicits._
    val simpleSchema = StructType(Array(
      StructField("id", StringType, true),
      StructField("name", StringType, true)
    ))

    val df = spark.readStream
      .format("csv")
      .schema(simpleSchema)
      .option("checkPointLocation", "file:///C:/Users/Emran/Desktop/datain/data")
      .load("file:///C:/Users/Emran/Desktop/datain/data")


val finalDf = df.writeStream
  .format("console")
  .start()
  .awaitTermination()
  }
}

