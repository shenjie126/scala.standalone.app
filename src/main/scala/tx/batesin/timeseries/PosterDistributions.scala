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

  def r = PriorDistributions.draw_r(pi, k)
  def x_r = PriorDistributions.gen_oumu_r(r,x) 
  def oumu_1 = PriorDistributions.gene_Oumu(x, k_n, w)
  def b_r = PriorDistributions.gen_vector_b(r, b)

  def r_nozero_size = {
	 var i = 0
     r.foreach(e => if(e != 0.0){
     i = i + 1
  	})
  	i
  }
  
  
  def v_1r = x_r.t * x_r + oumu_1
  def beta_r = inv(v_1r)*(x_r.t*y + oumu_1 * b)
  def N = v + y.length
  def ss_r = ss + y.t * y + b.t * oumu_1 * b - beta_r.t * v_1r * beta_r 
  
  def draw_sigma_y = 1/PriorDistributions.draw_sigma_r(N, ss_r)
  
  
  def draw_r_y(): DenseVector[Double] = {
    r * math.sqrt(det(oumu_1)) /math.sqrt(det(v_1r))/math.pow(ss_r, N/2 - 1)
  }
  
  
  def draw_beta_y(): DenseVector[Double] = {
    val mutil_Gaussian_model = MultivariateGaussian(beta_r,inv(v_1r)*draw_sigma_y)(new RandBasis(new ThreadLocalRandomGenerator(new MersenneTwister(System.currentTimeMillis()))))
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