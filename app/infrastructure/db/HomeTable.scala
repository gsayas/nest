package infrastructure.db

import domain.model.Home
import slick.jdbc.PostgresProfile.api._
import slick.lifted.{ProvenShape, Tag}

class HomeTable(tag: Tag) extends Table[Home](tag, "homes") {
  def id: Rep[Long] = column[Long]("id", O.PrimaryKey, O.AutoInc)
  def address: Rep[String] = column[String]("address")
  def price: Rep[BigDecimal] = column[BigDecimal]("price")

  // Define a default projection for the table
  override def * : ProvenShape[Home] = (id, address, price) <> (Home.tupled, Home.unapply)
}
