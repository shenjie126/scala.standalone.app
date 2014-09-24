package tx.batesin.timeseries

import org.scalatest._;
import org.scalatest.junit._;
import org.scalatest.prop._;
import org.junit.runner.RunWith
import tx.batesin.timeseries._
import java.math.BigDecimal
import breeze.linalg._

@RunWith(classOf[JUnitRunner])
class PriorDistributionsTest extends FunSuite {
  
  test("test r_row sample") {
    
    def loop(acc:DenseVector[Double],i:Int):DenseVector[Double] = {
      if (i > 100000) acc
      else
        loop(acc + PriorDistributions.draw_r(0.3, 10),i + 1)
    }
    val a = loop(DenseVector.zeros[Double](10),1)
    println(sum(a)/100000)
    
  }
  
  
  test("test sigma_row sample"){
    
    
    def loop(acc:Double,i:Int):Double = {
      if (i > 10000) acc
      else
        loop(acc + PriorDistributions.draw_sigma_r(0.01, 5),i + 1)
    }
    val a = loop(0,1)
    println(a/10000)
  } 
  import breeze.linalg._
  test("test gener gene_Covariance"){
    val x = DenseVector[Double](1.0,0.0,2.0,0.0,4.0,1.0,3.0,0.0,2.0,3.0)
    println(x)
    //println(PriorDistributions.gene_Covariance(x ,0.1 , 0.5))
    
  } 
  
  test("Double format"){
    val f = 111231.5585;
    val bg = new BigDecimal(f)
    val f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue()
    assert(f1 === 111231.56)
    
  }
  
  test("DenseVector non zero size"){
    val a = DenseVector.zeros[Int](3)
    val b = DenseVector.zeros[Int](5)
    a(1) = 1
    a(2) = 1

    var i = 0
    a.foreachValue(e => if(e != 0) {
      b(i) = e
      i = i + 1
    })
    val c = b(0 to i - 1 )
    
    assert(c.length === 2)
  }

}