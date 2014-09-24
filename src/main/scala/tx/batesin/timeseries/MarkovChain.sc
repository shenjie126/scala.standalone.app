package tx.batesin.timeseries
import breeze.stats.distributions._

object MarkovChain {

	val a = new Gamma(0.05,1.0)               //> a  : breeze.stats.distributions.Gamma = Gamma(0.05,1.0)
	a.pdf(2)                                  //> res0: Double = 0.0035980292190093224
	a.draw()                                  //> res1: Double = 1.4693615385489364E-9
	val mean = 2.834312                       //> mean  : Double = 2.834312
    val meanOfLogs = -0.689661                    //> meanOfLogs  : Double = -0.689661
    val n=5.000000                                //> n  : Double = 5.0
    val ss = Gamma.SufficientStatistic(n, meanOfLogs, mean)
                                                  //> ss  : breeze.stats.distributions.Gamma.SufficientStatistic = SufficientStati
                                                  //| stic(5.0,-0.689661,2.834312)
    val (k, theta) = Gamma.mle(ss)                //> k  : Double = 0.3827611632142166
                                                  //| theta  : Double = 7.404910091188498
}