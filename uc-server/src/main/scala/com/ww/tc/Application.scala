package com.ww.tc

import com.twitter.finagle.ThriftMux
import com.twitter.finagle.tunable.StandardTunableMap
import com.twitter.finatra.thrift.ThriftServer
import com.twitter.finatra.thrift.exceptions.FinatraThriftExceptionMapper
import com.twitter.finatra.thrift.filters._
import com.twitter.finatra.thrift.routing.ThriftRouter
import com.twitter.util.Duration
import com.twitter.util.TimeConversions._
import com.twitter.util.tunable.{Tunable, TunableMap}
import com.ww.tc.finatra.{FinatraTypeSafeConfigModule, QuillDatabaseModule}


object ApplicationMain extends Application

class Application extends ThriftServer {

  private[this] val serviceLabel = "user-center"

  override def modules = Seq(
    FinatraTypeSafeConfigModule, QuillDatabaseModule)


  override val name: String = serviceLabel


  override protected def defaultFinatraThriftPort: String = ":9998"


  override def defaultAdminPort: Int = 9090


  override protected def configureThrift(router: ThriftRouter): Unit = {
    router
      .filter[LoggingMDCFilter]
      .filter[TraceIdMDCFilter]
      .filter[ThriftMDCFilter]
      .filter[AccessLoggingFilter]
      .filter[StatsFilter]
      .filter[ExceptionMappingFilter]
      .exceptionMapper[FinatraThriftExceptionMapper]
      .add[UserCenterController]
  }

  override protected def configureThriftServer(server: ThriftMux.Server): ThriftMux.Server = {
    val startMap = StandardTunableMap("clientid")
    val requestTimeout = startMap(TunableMap.Key[Duration]("request.timeout"))
    server.withLabel(serviceLabel).withRequestTimeout(requestTimeout).withAdmissionControl.concurrencyLimit(10, 10000)
  }
}
