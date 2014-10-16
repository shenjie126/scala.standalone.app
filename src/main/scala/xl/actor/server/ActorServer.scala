package xl.actor.server
import actors.Actor._
import actors._
import actors.remote.RemoteActor._
import actors.remote.Node

object ActorServer extends Application {
  
  actor {
    
    alive(3000)
    register('testServer, self)
    println("begin")
    loop {

        react {case msg =>
          println("server1 get: " + msg)
        }

      }
  }
  
  actor {
    val node = Node("127.0.0.1", 3000)
    val remoteActor = select(node, 'testServer)
    
    println("beign")
    remoteActor ! "hello"
    println("end")
  }
  

}

