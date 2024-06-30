//TODO: which package should this be in?

import play.api.Environment
import play.api.Configuration
import slick.jdbc.PostgresProfile.api._
import com.google.inject.AbstractModule
import com.google.inject.Provides
import slick.jdbc.JdbcBackend.Database
import javax.inject.Singleton
import domain.repository.HomeRepository
import infrastructure.repository.SlickHomeRepository

class DatabaseModule(environment: Environment, configuration: Configuration) extends AbstractModule {
  private val dbUrl = configuration.get[String]("db.url")
  private val dbUser = configuration.get[String]("db.user")
  private val dbPassword = configuration.get[String]("db.password")
  private val dbDriver = configuration.get[String]("db.driver")

  @Provides
  @Singleton
  def provideSlickHomeRepository(): HomeRepository = {
    val db = Database.forURL(
      url = dbUrl,
      user = dbUser,
      password = dbPassword,
      driver = dbDriver
    )
    new SlickHomeRepository(db)
  }
}