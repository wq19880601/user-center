package com.ww.tc.service

import javax.inject.{Inject, Singleton}

import com.twitter.util.Future
import com.ww.tc.dao.DeliveryAddressRepository
import com.ww.tc.domain.DeliveryAddress

class DeliveryAddressService @Inject()(val deliveryAddressRepository: DeliveryAddressRepository) {


  def getDeliverInfo(): Future[(Option[DeliveryAddress], Option[DeliveryAddress])] = {
    val value = deliveryAddressRepository.ascFirst()

    val result: Future[(Option[DeliveryAddress], Option[DeliveryAddress])] = for {
      first <- deliveryAddressRepository.descFirst()
      last <- deliveryAddressRepository.ascFirst()
    } yield (first, last)
    result
  }

  def getFirst(): Future[Option[DeliveryAddress]] = {
    deliveryAddressRepository.ascFirst()
  }

}
