package infrastructure.repository

import domain.model.Home
import domain.repository.HomeRepository
import slick.jdbc.PostgresProfile.api._
import scala.concurrent.Future
import slick.jdbc.JdbcBackend.Database
import javax.inject.Inject

class SlickHomeRepository @Inject()() extends HomeRepository {
  override def findAffordable(limit: BigDecimal): Future[Seq[Home]] = {
    // Implement query using Slick
    val mockHomes = Seq(
      Home(123, "Mock Home 1", BigDecimal(100000)),
      Home(456, "Mock Home 2", BigDecimal(150000)),
      Home(789, "Mock Home 3", BigDecimal(200000))
    )
    Future.successful(mockHomes)
  }
}