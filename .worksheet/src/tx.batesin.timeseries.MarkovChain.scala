package tx.batesin.timeseries
import breeze.stats.distributions._

object MarkovChain {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(117); 

	val a = new Gamma(0.05,1.0);System.out.println("""a  : breeze.stats.distributions.Gamma = """ + $show(a ));$skip(10); val res$0 = 
	a.pdf(2);System.out.println("""res0: Double = """ + $show(res$0));$skip(10); val res$1 = 
	a.draw();System.out.println("""res1: Double = """ + $show(res$1));$skip(21); 
	val mean = 2.834312;System.out.println("""mean  : Double = """ + $show(mean ));$skip(31); 
    val meanOfLogs = -0.689661;System.out.println("""meanOfLogs  : Double = """ + $show(meanOfLogs ));$skip(19); 
    val n=5.000000;System.out.println("""n  : Double = """ + $show(n ));$skip(60); 
    val ss = Gamma.SufficientStatistic(n, meanOfLogs, mean);System.out.println("""ss  : breeze.stats.distributions.Gamma.SufficientStatistic = """ + $show(ss ));$skip(35); 
    val (k, theta) = Gamma.mle(ss);System.out.println("""k  : Double = """ + $show(k ));System.out.println("""theta  : Double = """ + $show(theta ))}
}
