package application.usecase.impl

import javax.inject._
import play.api.libs.json.{Json, JsObject}
import application.usecase.FindAffordableHomesUseCase
import domain.repository.HomeRepository
import scala.concurrent.Future
import domain.model.Home


@Singleton
class FindAffordableHomesUseCaseImpl @Inject()(homeRepository: HomeRepository) extends FindAffordableHomesUseCase {
  override def execute(): Future[Seq[Home]] = {
    homeRepository.findAffordable(BigDecimal(1000000000))
  }
}