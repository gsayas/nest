package domain.repository
import scala.concurrent.Future
import domain.model.Home

trait HomeRepository {
  def findAffordable(limit: BigDecimal): Future[Seq[Home]]
}