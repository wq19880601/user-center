package com.ww

import com.google.inject.Stage
import com.twitter.finatra.thrift.EmbeddedThriftServer
import com.twitter.inject.server.FeatureTest
import com.twitter.util.Future
import com.ww.tc.Application
import com.ww.user.thriftscala.{UserQuery, UserService}

class UserCenterServiceTest extends FeatureTest {
  val server = new EmbeddedThriftServer(twitterServer = new Application, stage = Stage.PRODUCTION)


  val client = server.thriftClient[UserService[Future]](clientId = "haha")

  test("addnumber test") {
    val value = client.addNumbers(1, 2).value
    assert(value > 0)
  }

  test("query userlsit") {
    val query = UserQuery(uid = "aa", uName = "aa")
    val value = client.queryList(query)
    assert(value.value.nonEmpty)
  }

  test("get one") {
    val userInfo = client.getById("7193788d-b6c1-42ba-bd52-a611a2201977")
    assert(userInfo != null)
  }

}
