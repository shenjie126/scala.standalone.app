import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object SequenceReader {

  def main(args: Array[String]): Unit = {
    
    val dataFile = "/user/hive/warehouse/download_odl.db/sequence/part-r-00000";
    val conf = new SparkConf().setAppName("SequenceReader Application")
    val sc = new SparkContext(conf) 
    val data = sc.sequenceFile[Long,String](dataFile, 2).cache()
    
    println("-----------------------------")
//    data.map(line => line._2).flatMap(line => line.split("\\s+|\\t")).foreach(xs => println(xs))
    val num = data.count()
    println("num:" + num)
  }

}