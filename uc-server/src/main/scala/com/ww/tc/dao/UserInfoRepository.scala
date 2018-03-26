package com.ww.tc.dao

import javax.inject.{Inject, Singleton}

import com.twitter.util.Future
import com.ww.tc.db.TableSchema
import com.ww.tc.domain.UserInfo
import com.ww.tc.finatra.QuillDatabaseModule.QuillDatabaseSource

class UserInfoRepository @Inject()(val ctx: QuillDatabaseSource) extends TableSchema {

  import ctx._


  def queryList(): Future[Seq[UserInfo]] = {
    ctx.run {
      query[UserInfo]
    }
  }

  def getByUid(uid: String): Future[Option[UserInfo]] = {
    ctx.run {
      query[UserInfo].filter(_.uid == lift(uid))
    }.map(_.headOption)
  }

}
