package controllers

import javax.inject._

import actors.Messages.SayHello
import akka.actor._
import akka.pattern.ask
import akka.util.Timeout
import play.api.mvc._

import scala.concurrent.ExecutionContext
import scala.concurrent.duration._

@Singleton
class Application @Inject()(@Named("hello") helloActor: ActorRef)(implicit ec: ExecutionContext)
  extends Controller {

  implicit val timeout: Timeout = 5.seconds

  def a = Action.async {
    (helloActor ? SayHello).mapTo[String].map { message =>
      Ok(message)
    }
  }
}