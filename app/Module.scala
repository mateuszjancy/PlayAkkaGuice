import actors.{HelloActor, NameActor}
import com.google.inject.AbstractModule
import play.api.libs.concurrent.AkkaGuiceSupport

class Module extends AbstractModule with AkkaGuiceSupport {
  override def configure(): Unit = {
    bindActor[HelloActor]("hello")
    bindActor[NameActor]("name")
  }
}
