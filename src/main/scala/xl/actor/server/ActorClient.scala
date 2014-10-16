package xl.actor.server
import actors.Actor, actors.remote.Node, actors.remote.RemoteActor._ 

object ActorClient extends Application {

  Actor.actor {
    val node = Node("127.0.0.1", 3033)
    val remoteActor = select(node, 'testServer)
    
    println("beign")
    remoteActor ! "hello"
    println("end")
  }
}