package tx.batesin.timeseries
import  breeze.stats.distributions._
import breeze.numerics._

object MathModel {
	
	val a = new Bernoulli(0.4)                //> a  : breeze.stats.distributions.Bernoulli = Bernoulli(0.4)
	a.probabilityOf(true)                     //> res0: Double = 0.4
	a.draw()                                  //> res1: Boolean = true
	a.draw()                                  //> res2: Boolean = false
	println(a.entropy)                        //> 0.6730116670092565
	Bernoulli.sufficientStatisticFor(true)    //> res3: breeze.stats.distributions.Bernoulli.SufficientStatistic = SufficientS
                                                  //| tatistic(1.0,1.0)
  Bernoulli.likelihoodFunction(new Bernoulli.SufficientStatistic(4,10)).calculate(1)
                                                  //> res4: (Double, Double) = (Infinity,Infinity)
	
                                                  
	for (i <- 1 to 10){
		println(a.draw())                 //> true
                                                  //| false
                                                  //| true
                                                  //| false
                                                  //| true
                                                  //| true
                                                  //| true
                                                  //| false
                                                  //| true
                                                  //| true
	}

	a.mean                                    //> res5: Double = 0.4
	
	a.variance                                //> res6: Double = 0.24
	
	a.mode                                    //> res7: Double = 0.0
	
	a.entropy                                 //> res8: Double = 0.6730116670092565
	
	//Beta.Parameter
	Bernoulli.predictive((3.0,4.0)).draw()    //> res9: Boolean = true
	
	
}