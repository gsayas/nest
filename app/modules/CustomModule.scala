import com.google.inject.AbstractModule
import application.usecase.FindAffordableHomesUseCase
import application.usecase.impl.FindAffordableHomesUseCaseImpl
import domain.repository.HomeRepository
import infrastructure.repository.SlickHomeRepository

class CustomModule extends AbstractModule {
  override def configure(): Unit = {
    bind(classOf[FindAffordableHomesUseCase]).to(classOf[FindAffordableHomesUseCaseImpl])
    bind(classOf[HomeRepository]).to(classOf[SlickHomeRepository])
  }
}