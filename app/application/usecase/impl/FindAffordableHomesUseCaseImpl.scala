package application.usecase.impl

import javax.inject._
import play.api.libs.json.{Json, JsObject}
import application.usecase.FindAffordableHomesUseCase
import domain.repository.HomeRepository // Assuming the repository is in the domain.repository package
import scala.concurrent.Future
import domain.model.Home


@Singleton
class FindAffordableHomesUseCaseImpl @Inject()(homeRepository: HomeRepository) extends FindAffordableHomesUseCase {
  override def execute(): Future[Seq[Home]] = {
    // Directly return the Future[Seq[Home]] from the repository
    homeRepository.findAffordable(BigDecimal(100000))
  }
}