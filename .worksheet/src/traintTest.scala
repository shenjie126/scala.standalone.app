object traintTest {
  //println("Welcome to the Scala worksheet")
  
  class OrderClass(a: Int) extends Ordered[OrderClass] {
    def num = a
    def compare(that: OrderClass) = this.num - that.num
  };import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(244); 
  
  val a: OrderClass = new OrderClass(1);System.out.println("""a  : traintTest.OrderClass = """ + $show(a ));$skip(40); 
  val b: OrderClass = new OrderClass(2);System.out.println("""b  : traintTest.OrderClass = """ + $show(b ));$skip(8); val res$0 = 
  a > b;System.out.println("""res0: Boolean = """ + $show(res$0));$skip(15); 
  println("a");$skip(185); 
  
  def expr(a: Any) = a match {
    case 0 => "zero"
    case a: String => "a string"
    case List(0, _, _) => "a list"
    case somethingElse => "not zero"
    case _ => "else"
  };System.out.println("""expr: (a: Any)String""");$skip(17); val res$1 = 
  
  expr("sdf");System.out.println("""res1: String = """ + $show(res$1));$skip(68); 
  
  
  val capital = Map("Japan" -> "Tokyo", "China" -> "Beijing");System.out.println("""capital  : scala.collection.immutable.Map[String,String] = """ + $show(capital ));$skip(92); 
  
  def show(x: Option[String]) = x match {
    case Some(s) => s
    case None => "?"
  };System.out.println("""show: (x: Option[String])String""");$skip(33); val res$2 = 
  
  show(capital get ("China"));System.out.println("""res2: String = """ + $show(res$2));$skip(32); val res$3 = 
  show(capital get ("America"));System.out.println("""res3: String = """ + $show(res$3));$skip(60); 
  
  val result = List(Some("apple"), None, Some("orange"));System.out.println("""result  : List[Option[String]] = """ + $show(result ));$skip(49); 
  for(Some(fruit) <- result){
    println(fruit)
  };$skip(55); 
  
  implicit def DoubleToInt(x: Double) = x.toInt;System.out.println("""DoubleToInt: (x: Double)Int""");$skip(22); 
  
  val c: Int = 3.5
  
  import scala.actors._
  object SillyActor extends Actor {
    def act() {
      for (i <- 1 to 5) {
        println(" I am acting " + i)
        Thread.sleep(1000)
      }
    }
  };System.out.println("""c  : Int = """ + $show(c ));$skip(211); val res$4 = 
  
  SillyActor.start();System.out.println("""res4: scala.actors.Actor = """ + $show(res$4))}
  
}
