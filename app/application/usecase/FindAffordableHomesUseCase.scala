package application.usecase

import play.api.libs.json.JsObject
import scala.concurrent.Future
import domain.model.Home

trait FindAffordableHomesUseCase {
  def execute(): Future[Seq[Home]] // TODO: return a List[AffortableHomeViewModel]?
}
