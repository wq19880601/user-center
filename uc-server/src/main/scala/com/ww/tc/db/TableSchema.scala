package com.ww.tc.db

import com.ww.tc.domain.{DeliveryAddress, UserInfo}
import com.ww.tc.finatra.QuillDatabaseModule.QuillDatabaseSource

trait TableSchema {

  val ctx: QuillDatabaseSource

  import ctx._

  val deliveryAddressTable: ctx.Quoted[ctx.EntityQuery[DeliveryAddress]] = quote {
    querySchema[DeliveryAddress]("delivery_address")
  }

  val userInfoTable: ctx.Quoted[ctx.EntityQuery[UserInfo]] = quote {
    querySchema[UserInfo]("user_info")
  }

}
