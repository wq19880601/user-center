package com.ww.tc

import javax.inject.Inject

import com.twitter.finagle.Service
import com.twitter.finatra.thrift.Controller
import com.twitter.util.Future
import com.ww.tc.service.{DeliveryAddressService, UserInfoService}
import com.ww.user.thriftscala.UserService.{AddNumbers, AddStrings, GetById, Increment, QueryList}
import com.ww.user.thriftscala.{User, UserService}

class UserCenterController @Inject()(val userInfoService: UserInfoService, val deliveryAddressService: DeliveryAddressService)
  extends Controller with UserService.ServicePerEndpoint {

  override def increment: Service[Increment.Args, Int] = handle(Increment) { args: Increment.Args =>
    val value = deliveryAddressService.getFirst()

    value.map {
      case None => 0
      case Some(dd) => dd.id
    }
  }

  override def addNumbers: Service[AddNumbers.Args, Int] = handle(AddNumbers) { args: AddNumbers.Args =>
    val value = deliveryAddressService.getDeliverInfo()
    val result: Future[Int] = value.map {
      case (Some(a), Some(b)) => a.id + b.id
      case _ => 0
    }
    result
  }

  override def addStrings: Service[AddStrings.Args, String] = handle(AddStrings) { args: AddStrings.Args =>
    val value = deliveryAddressService.getDeliverInfo()
    val result: Future[String] = value.map {
      case (Some(a), Some(b)) => (a.id + b.id).toString
      case _ => "0"
    }
    result
  }

  override def queryList: Service[QueryList.Args, Seq[User]] = handle(QueryList) { args: QueryList.Args =>
    val value = userInfoService.queryList()
    value
  }

  override def getById: Service[GetById.Args, User] = handle(GetById) { args: GetById.Args =>
    val value = userInfoService.getByUid(args.uid)
    value
  }
}
