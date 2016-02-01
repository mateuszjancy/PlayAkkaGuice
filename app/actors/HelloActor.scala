package actors

import actors.Messages.{SayHello, SetName}
import akka.actor.Actor

class HelloActor extends Actor {

  var name: String = "Init"

  def receive = {
    case SayHello =>
      sender() ! "Hello, " + name
    case SetName(n) => name = n
  }
}
