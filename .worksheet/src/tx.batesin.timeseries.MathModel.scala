package tx.batesin.timeseries
import  breeze.stats.distributions._
import breeze.numerics._

object MathModel {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(141); 
	
	val a = new Bernoulli(0.4);System.out.println("""a  : breeze.stats.distributions.Bernoulli = """ + $show(a ));$skip(23); val res$0 = 
	a.probabilityOf(true);System.out.println("""res0: Double = """ + $show(res$0));$skip(10); val res$1 = 
	a.draw();System.out.println("""res1: Boolean = """ + $show(res$1));$skip(10); val res$2 = 
	a.draw();System.out.println("""res2: Boolean = """ + $show(res$2));$skip(20); 
	println(a.entropy);$skip(40); val res$3 = 
	Bernoulli.sufficientStatisticFor(true);System.out.println("""res3: breeze.stats.distributions.Bernoulli.SufficientStatistic = """ + $show(res$3));$skip(85); val res$4 = 
  Bernoulli.likelihoodFunction(new Bernoulli.SufficientStatistic(4,10)).calculate(1);System.out.println("""res4: (Double, Double) = """ + $show(res$4));$skip(95); 
	
                                                  
	for (i <- 1 to 10){
		println(a.draw())
	};$skip(12); val res$5 = 

	a.mean;System.out.println("""res5: Double = """ + $show(res$5));$skip(14); val res$6 = 
	
	a.variance;System.out.println("""res6: Double = """ + $show(res$6));$skip(10); val res$7 = 
	
	a.mode;System.out.println("""res7: Double = """ + $show(res$7));$skip(13); val res$8 = 
	
	a.entropy;System.out.println("""res8: Double = """ + $show(res$8));$skip(60); val res$9 = 
	
	//Beta.Parameter
	Bernoulli.predictive((3.0,4.0)).draw();System.out.println("""res9: Boolean = """ + $show(res$9))}
	
	
}
