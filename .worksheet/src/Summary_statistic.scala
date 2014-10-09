import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.linalg.DenseVector
import org.apache.spark.mllib.stat.{MultivariateStatisticalSummary, Statistics}
import org.apache.spark.rdd._
object Summary_statistic {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(369); 
	val sc = new SparkContext();System.out.println("""sc  : org.apache.spark.SparkContext = """ + $show(sc ));$skip(101); 
	val observations: RDD[Vector] = sc.parallelize(List(Vectors.dense(Array(1.0,2.0,3.0,4.0,5.0,6.0))));System.out.println("""observations  : org.apache.spark.rdd.RDD[<error>] = """ + $show(observations ))}
	                                
}
