import com.google.inject.AbstractModule
import application.usecase.FindAffordableHomesUseCase
import application.usecase.impl.FindAffordableHomesUseCaseImpl

class CustomModule extends AbstractModule {
  override def configure(): Unit = {
    bind(classOf[FindAffordableHomesUseCase]).to(classOf[FindAffordableHomesUseCaseImpl])
  }
}