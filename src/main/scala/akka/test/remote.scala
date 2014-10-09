package akka.test

import akka.actor.Actor
import akka.actor.ActorLogging
import akka.actor.ActorSystem

case class Greeting(who: String) extends Serializable
 
class GreetingActor extends Actor with ActorLogging {
  def receive = {
    case Greeting(who) ⇒ log.info("Hello " + who)
  }
}



object remote {
  val system = ActorSystem("MySystem")



}