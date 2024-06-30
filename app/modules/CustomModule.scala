import com.google.inject.AbstractModule
import application.usecase.FindAffordableHomesUseCase
import application.usecase.impl.FindAffordableHomesUseCaseImpl
import com.google.inject.AbstractModule

class CustomModule extends AbstractModule {
  override def configure(): Unit = {
    bind(classOf[FindAffordableHomesUseCase]).to(classOf[FindAffordableHomesUseCaseImpl])
  }
  
}