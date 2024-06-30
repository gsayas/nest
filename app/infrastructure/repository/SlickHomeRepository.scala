package infrastructure.repository

import domain.model.Home
import domain.repository.HomeRepository
import slick.jdbc.PostgresProfile.api._
import scala.concurrent.Future
import slick.jdbc.JdbcBackend.Database
import javax.inject.Inject
import infrastructure.db.HomeTable

class SlickHomeRepository @Inject()(db: Database) extends HomeRepository {

    private val homes = TableQuery[HomeTable]
  override def findAffordable(limit: BigDecimal): Future[Seq[Home]] = {
   val query = homes.filter(_.price <= limit).result

    db.run(query)
  }
}