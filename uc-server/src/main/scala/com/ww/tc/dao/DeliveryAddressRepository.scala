package com.ww.tc.dao

import javax.inject.Inject

import com.twitter.util.Future
import com.ww.tc.db.TableSchema
import com.ww.tc.domain.DeliveryAddress
import com.ww.tc.finatra.QuillDatabaseModule.QuillDatabaseSource

class DeliveryAddressRepository @Inject()(val ctx: QuillDatabaseSource) extends TableSchema {

  import ctx._

  def descFirst(): Future[Option[DeliveryAddress]] = {

    val value: Future[Option[DeliveryAddress]] = ctx.run {
      quote {
        query[DeliveryAddress].sortBy(p => p.createTime)(Ord.desc)
      }.take(1)
    }.map(_.headOption)
    value
  }

  def ascFirst(): Future[Option[DeliveryAddress]] = {
    ctx.run {
      quote {
        query[DeliveryAddress].sortBy(p => p.createTime)(Ord.asc)
      }
    }.map(_.headOption)
  }

}
