package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.libs.json.{Json, Writes}

import domain.model.Home

import application.usecase.FindAffordableHomesUseCase

/** This controller creates an `Action` to handle HTTP requests to the
  * application's home page.
  */
@Singleton
class HomeController @Inject() (
    val controllerComponents: ControllerComponents,
    findAffordableHomesUseCase: FindAffordableHomesUseCase
) extends BaseController {

  implicit val homeWrites: Writes[Home] = Json.writes[Home]
  implicit val ec: scala.concurrent.ExecutionContext = scala.concurrent.ExecutionContext.global

  /** Create an Action to render an HTML page.
    *
    * The configuration in the `routes` file means that this method will be
    * called when the application receives a `GET` request with a path of `/`.
    */
  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

  def findAffordable(): Action[AnyContent] = Action.async {
    findAffordableHomesUseCase.execute().map { affordableHomes =>
      val homesJson = Json.toJson(affordableHomes)
      Ok(
        Json.obj(
          "status" -> "success",
          "message" -> "Here are the affordable homes.",
          "homes" -> homesJson
        )
      )
    }
  }

}
