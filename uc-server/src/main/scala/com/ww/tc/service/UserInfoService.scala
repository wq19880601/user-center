package com.ww.tc.service

import javax.inject.Inject

import com.twitter.util.Future
import com.ww.tc.dao.UserInfoRepository
import com.ww.tc.domain.UserInfo
import com.ww.user.thriftscala.User

class UserInfoService @Inject()(val userInfoRepository: UserInfoRepository) {

  def queryList(): Future[Seq[User]] = {
    for {
      users <- userInfoRepository.queryList()
    } yield {
      for {
        user <- users
      } yield userCovnert2Dto(user)
    }
  }

  def getByUid(uid: String): Future[User] = {
    val value: Future[User] = userInfoRepository.getByUid(uid).map {
      case None => null
      case Some(userInfo) =>
        userCovnert2Dto(userInfo)
    }
    value
  }


  val userCovnert2Dto = (userInfo: UserInfo) => {
    User(id = userInfo.id, uid = userInfo.uid, nick = userInfo.nick, iconUrl = userInfo.iconUrl, uName = userInfo.uName, mobile = userInfo.mobile)
  }


}
