object traintTest {
  //println("Welcome to the Scala worksheet")
  
  class OrderClass(a: Int) extends Ordered[OrderClass] {
    def num = a
    def compare(that: OrderClass) = this.num - that.num
  }
  
  val a: OrderClass = new OrderClass(1)           //> a  : traintTest.OrderClass = traintTest$OrderClass@6686fe26
  val b: OrderClass = new OrderClass(2)           //> b  : traintTest.OrderClass = traintTest$OrderClass@53ebd75b
  a > b                                           //> res0: Boolean = false
  println("a")                                    //> a
  
  def expr(a: Any) = a match {
    case 0 => "zero"
    case a: String => "a string"
    case List(0, _, _) => "a list"
    case somethingElse => "not zero"
    case _ => "else"
  }                                               //> expr: (a: Any)String
  
  expr("sdf")                                     //> res1: String = a string
  
  
  val capital = Map("Japan" -> "Tokyo", "China" -> "Beijing")
                                                  //> capital  : scala.collection.immutable.Map[String,String] = Map(Japan -> Toky
                                                  //| o, China -> Beijing)
  
  def show(x: Option[String]) = x match {
    case Some(s) => s
    case None => "?"
  }                                               //> show: (x: Option[String])String
  
  show(capital get ("China"))                     //> res2: String = Beijing
  show(capital get ("America"))                   //> res3: String = ?
  
  val result = List(Some("apple"), None, Some("orange"))
                                                  //> result  : List[Option[String]] = List(Some(apple), None, Some(orange))
  for(Some(fruit) <- result){
    println(fruit)                                //> apple
                                                  //| orange
  }
  
  implicit def DoubleToInt(x: Double) = x.toInt   //> DoubleToInt: (x: Double)Int
  
  val c: Int = 3.5                                //> c  : Int = 3
  
  import scala.actors._
  object SillyActor extends Actor {
    def act() {
      for (i <- 1 to 5) {
        println(" I am acting " + i)
        Thread.sleep(1000)
      }
    }
  }
  

}