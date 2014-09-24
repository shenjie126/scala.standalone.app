package tx.batesin.timeseries
import  breeze.stats.distributions._


object MathModel {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(117); 
	
	val a = new Bernoulli(0.4);System.out.println("""a  : breeze.stats.distributions.Bernoulli = """ + $show(a ));$skip(23); val res$0 = 
	a.probabilityOf(true);System.out.println("""res0: Double = """ + $show(res$0));$skip(10); val res$1 = 
	a.draw();System.out.println("""res1: Boolean = """ + $show(res$1));$skip(10); val res$2 = 
	a.draw();System.out.println("""res2: Boolean = """ + $show(res$2));$skip(43); 
	
	for (i <- 1 to 10){
		println(a.draw())
	};$skip(12); val res$3 = 

	a.mean;System.out.println("""res3: Double = """ + $show(res$3));$skip(14); val res$4 = 
	
	a.variance;System.out.println("""res4: Double = """ + $show(res$4));$skip(10); val res$5 = 
	
	a.mode;System.out.println("""res5: Double = """ + $show(res$5));$skip(13); val res$6 = 
	
	a.entropy;System.out.println("""res6: Double = """ + $show(res$6));$skip(60); val res$7 = 
	
	//Beta.Parameter
	Bernoulli.predictive((3.0,4.0)).draw();System.out.println("""res7: Boolean = """ + $show(res$7))}
	
	
}
