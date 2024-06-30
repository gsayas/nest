package application.usecase

import play.api.libs.json.JsObject

trait FindAffordableHomesUseCase {
  def execute(): JsObject // TODO: return a List[AffortableHomeViewModel]?
}
