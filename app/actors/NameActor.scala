package actors

import javax.inject.{Inject, Named}

import actors.Messages.{ChangeName, SetName}
import akka.actor.{Actor, ActorRef}

import scala.concurrent.ExecutionContext
import scala.concurrent.duration._
import scala.util.Random

class NameActor @Inject()(@Named("hello") helloActor: ActorRef)(implicit ec: ExecutionContext) extends Actor {

  context.system.scheduler.schedule(0 seconds, 5 seconds, self, ChangeName)

  def receive = {
    case ChangeName => helloActor ! SetName(Random.nextString(5))
  }
}
