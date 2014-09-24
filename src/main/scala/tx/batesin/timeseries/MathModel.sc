package tx.batesin.timeseries
import  breeze.stats.distributions._


object MathModel {
	
	val a = new Bernoulli(0.4)                //> a  : breeze.stats.distributions.Bernoulli = Bernoulli(0.4)
	a.probabilityOf(true)                     //> res0: Double = 0.4
	a.draw()                                  //> res1: Boolean = false
	a.draw()                                  //> res2: Boolean = true
	
	for (i <- 1 to 10){
		println(a.draw())                 //> false
                                                  //| true
                                                  //| false
                                                  //| false
                                                  //| false
                                                  //| true
                                                  //| true
                                                  //| false
                                                  //| true
                                                  //| false
	}

	a.mean                                    //> res3: Double = 0.4
	
	a.variance                                //> res4: Double = 0.24
	
	a.mode                                    //> res5: Double = 0.0
	
	a.entropy                                 //> res6: Double = 0.6730116670092565
	
	//Beta.Parameter
	Bernoulli.predictive((3.0,4.0)).draw()    //> res7: Boolean = false
	
	
}