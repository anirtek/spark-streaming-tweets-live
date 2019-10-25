package com.anirtek

import org.apache.spark._
import org.apache.spark.streaming._
import org.apache.spark.streaming.StreamingContext._
import org.apache.spark.storage.StorageLevel

object RequestInfoLogStreamer {

  def main(args: Array[String]) {

val sparkSession = SparkSession
      .builder()
      .master("")
      .appName("Spark Application Pipeline")
      .getOrCreate()

    val conf = new SparkConf().setMaster("local[*]").setAppName("RequestInfoLogStreamer")
    val ssc = new StreamingContext(conf, Seconds(10))

    val lines = ssc.socketTextStream("127.0.0.1", 9999, StorageLevel.MEMORY_AND_DISK_SER) //DStream that will connect to host:port
    val words = lines.flatMap(_.split(" "))

    val pairs = words.map(word => (word, 1))
    val wordCount = pairs.reduceByKey(_ + _)

    wordCount.print()

    ssc.start()
    ssc.awaitTermination()
  }

}