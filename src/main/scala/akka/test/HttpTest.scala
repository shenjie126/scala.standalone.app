package akka.test

import akka.http.Http
import akka.io.IO
import akka.pattern.ask
import akka.stream.FlowMaterializer
import akka.stream.scaladsl.Flow
import akka.actor.ActorSystem
 
implicit val system = ActorSystem()
import system.dispatcher
implicit val materializer = FlowMaterializer()
implicit val askTimeout: Timeout = 500.millis
 
  
val bindingFuture = IO(Http) ? Http.Bind(interface = "localhost", port = 8080)
bindingFuture foreach {
  case Http.ServerBinding(localAddress, connectionStream) ⇒
    Flow(connectionStream).foreach({
      case Http.IncomingConnection(remoteAddress, requestProducer, responseConsumer) ⇒
        println("Accepted new connection from " + remoteAddress)
 
      // handle connection here
    })
}
