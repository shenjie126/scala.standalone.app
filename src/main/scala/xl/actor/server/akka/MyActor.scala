package xl.actor.server.akka
import akka.actor.Actor
import akka.actor.Props
import akka.event.Logging
import akka.actor.Props
import akka.actor.ActorSystem


object MyActor {
  
  class MyActor(arg: String) extends Actor {
    val log = Logging(context.system, this)
    def receive = {
      case "test" => log.info("test :" + arg)
      case _ => log.info("unkown")
    }
  }
  
  
  def main(args: Array[String]) = {
    import system.dispatcher
    //val prop = Props[MyActor]
    val prop = Props(classOf[MyActor], "arg11")
    val system = ActorSystem("mySystem")
    // 全局的 actor ，如果用content.actorOf 则是自actor
    val myActor = system.actorOf(prop, "myfactor")
    myActor ! "test"
    myActor ! "test1"
    
  }

}