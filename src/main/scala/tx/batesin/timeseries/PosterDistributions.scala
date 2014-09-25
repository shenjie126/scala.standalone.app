package tx.batesin.timeseries


import breeze.linalg._
import breeze.numerics._
import breeze.optimize.DiffFunction
import math.{Pi,log1p}
import breeze.stats.distributions._
import org.apache.commons.math3.random.{MersenneTwister, RandomGenerator}

class PosterDistributions (y: DenseVector[Double],pi: Double,k: Int,x: DenseMatrix[Double],
		b: DenseVector[Double],k_n: Double,w: Double,v: Double,ss: Double
		){

  val r = PriorDistributions.draw_r(pi, k)
  val x_r = PriorDistributions.gen_matrix_r(r, x)
  val oumu_1r = PriorDistributions.gene_Oumu(x_r, k_n, w)
  val b_r = PriorDistributions.gen_vector_b(r, b)

  val r_nozero_size = {
	 var i = 0
     r.foreach(e => if(e != 0.0){
     i = i + 1
  	})
  	i
  }
  
  
  val v_1r = x_r.t * x_r + oumu_1r

  val beta_r = inv(v_1r)*(x_r.t*y + oumu_1r * b_r)
  val N = v + y.length
  val ss_r = ss + y.t * y + b_r.t * oumu_1r * b_r - beta_r.t * v_1r * beta_r 
  
  def draw_sigma_y = 1/PriorDistributions.draw_sigma_r(N, ss_r)
  
  def draw_r_y()=PosterDistributions.draw_r_y(r,oumu_1r,v_1r,ss_r,N)
  
  def draw_beta_y(): DenseVector[Double] = {

    val covariance = PriorDistributions.formatMatrix(inv(v_1r)*draw_sigma_y)
    val mutil_Gaussian_model = MultivariateGaussian(beta_r,covariance)(new RandBasis(new ThreadLocalRandomGenerator(new MersenneTwister(System.currentTimeMillis()))))
    mutil_Gaussian_model.draw()
  }
  
  def draw(): DenseVector[Double] = {
    val priorVector = DenseVector.zeros[Double](k + r_nozero_size + 1)
    priorVector(0) = draw_sigma_y
    priorVector(1 to k) := r
    priorVector(k + 1 to k + r_nozero_size) := draw_beta_y 
    priorVector
  }
  


}

object PosterDistributions{
  
  def draw_r_y(r: DenseVector[Double],oumu_1r: DenseMatrix[Double],v_1r: DenseMatrix[Double],ss_r:Double,N:Double): DenseVector[Double] = {
    r * math.sqrt(det(oumu_1r)) /math.sqrt(det(v_1r))/math.pow(ss_r, N/2 - 1)
  }
  
  
  
}


