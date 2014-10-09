package akka.test

import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props
import akka.event.Logging
 
class HelloWorld extends Actor {
  val log = Logging(context.system, this)
  override def preStart(): Unit = {
    // create the greeter actor
    val greeter = context.actorOf(Props[Greeter], "greeter")
    // tell it to perform the greeting
    log.info("helloworld preStart")
    greeter ! Greeter.Greet
  }
 
  def receive = {
    // when the greeter is done, stop this actor and with it the application

    case Greeter.Done => {
      log.info("helloworld revceive")
      context.stop(self)
    }
  }
}

object Greeter {
  case object Greet
  case object Done
}
 
class Greeter extends Actor {
  def receive = {
    case Greeter.Greet =>
      println("Hello World!")
      sender ! Greeter.Done
  }
}

object start {
  
  def main(args: Array[String]){
      val system = ActorSystem("MySystem")
      val helloworld = system.actorOf(Props[HelloWorld], name = "greeter")
      helloworld !Greeter.Done
    
  }
}


