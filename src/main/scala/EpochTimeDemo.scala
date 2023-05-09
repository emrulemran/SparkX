package com.pack.org

import org.apache.spark.sql.SparkSession
object EpochTimeDemo {

  def main(args: Array[String]): Unit = {

    val configs = new ConfigurationFile()
    val conf = configs.sparkConfigs()
    val spark: SparkSession = SparkSession.builder().config(conf).enableHiveSupport().getOrCreate()
    
    spark.sql("""select from_unixtime(1581215812)""").show();
    
  }
  
}




Output:
+--------------------------------------------------------------+
|from_unixtime(CAST(1581215812 AS BIGINT), yyyy-MM-dd HH:mm:ss)|
+--------------------------------------------------------------+
|                                           2020-02-08 21:36:52|
+--------------------------------------------------------------+
