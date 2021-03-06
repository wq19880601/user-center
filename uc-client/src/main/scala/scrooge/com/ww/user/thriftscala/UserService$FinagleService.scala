/**
 * Generated by Scrooge
 *   version: 18.2.0
 *   rev: 13c26e196ec2a399833771a335ae98afcc4d6b57
 *   built at: 20180205-165339
 */
package com.ww.user.thriftscala

import com.twitter.finagle.{
  service => ctfs,
  Filter => finagle$Filter,
  Service => finagle$Service,
  thrift => _,
  _
}
import com.twitter.finagle.stats.{Counter, NullStatsReceiver, StatsReceiver}
import com.twitter.finagle.thrift.RichServerParam
import com.twitter.io.Buf
import com.twitter.scrooge._
import com.twitter.util.{Future, Return, Throw, Throwables}
import java.nio.ByteBuffer
import java.util.Arrays
import org.apache.thrift.protocol._
import org.apache.thrift.TApplicationException
import org.apache.thrift.transport.TMemoryInputTransport
import scala.collection.mutable.{
  ArrayBuffer => mutable$ArrayBuffer, HashMap => mutable$HashMap}
import scala.collection.{Map, Set}

import scala.language.higherKinds


@javax.annotation.Generated(value = Array("com.twitter.scrooge.Compiler"))
class UserService$FinagleService(
  iface: UserService[Future],
  serverParam: RichServerParam
) extends com.twitter.finagle.Service[Array[Byte], Array[Byte]] {
  import UserService._

  @deprecated("Use com.twitter.finagle.thrift.RichServerParam", "2017-08-16")
  def this(
    iface: UserService[Future],
    protocolFactory: TProtocolFactory,
    stats: StatsReceiver = NullStatsReceiver,
    maxThriftBufferSize: Int = Thrift.param.maxThriftBufferSize,
    serviceName: String = "UserService"
  ) = this(iface, RichServerParam(protocolFactory, serviceName, maxThriftBufferSize, stats))

  @deprecated("Use com.twitter.finagle.thrift.RichServerParam", "2017-08-16")
  def this(
    iface: UserService[Future],
    protocolFactory: TProtocolFactory,
    stats: StatsReceiver,
    maxThriftBufferSize: Int
  ) = this(iface, protocolFactory, stats, maxThriftBufferSize, "UserService")

  @deprecated("Use com.twitter.finagle.thrift.RichServerParam", "2017-08-16")
  def this(
    iface: UserService[Future],
    protocolFactory: TProtocolFactory
  ) = this(iface, protocolFactory, NullStatsReceiver, Thrift.param.maxThriftBufferSize)

  def serviceName: String = serverParam.serviceName
  private[this] def responseClassifier: ctfs.ResponseClassifier = serverParam.responseClassifier
  private[this] def stats: StatsReceiver = serverParam.serverStats

  private[this] def protocolFactory: TProtocolFactory = serverParam.protocolFactory
  private[this] def maxReusableBufferSize: Int = serverParam.maxThriftBufferSize

  private[this] val tlReusableBuffer = TReusableBuffer(maxThriftBufferSize = maxReusableBufferSize)

  protected val serviceMap = new mutable$HashMap[String, finagle$Service[(TProtocol, Int), Array[Byte]]]()

  protected def addService(name: String, service: finagle$Service[(TProtocol, Int), Array[Byte]]): Unit = {
    serviceMap(name) = service
  }

  final protected def exception(name: String, seqid: Int, code: Int, message: String): Buf = {
    val x = new TApplicationException(code, message)
    val memoryBuffer = tlReusableBuffer.get()
    try {
      val oprot = protocolFactory.getProtocol(memoryBuffer)

      oprot.writeMessageBegin(new TMessage(name, TMessageType.EXCEPTION, seqid))
      x.write(oprot)
      oprot.writeMessageEnd()
      oprot.getTransport().flush()

      // make a copy of the array of bytes to construct a new buffer because memoryBuffer is reusable
      Buf.ByteArray.Shared(memoryBuffer.getArray(), 0, memoryBuffer.length())
    } finally {
      tlReusableBuffer.reset()
    }
  }

  final protected def reply(name: String, seqid: Int, result: ThriftStruct): Buf = {
    val memoryBuffer = tlReusableBuffer.get()
    try {
      val oprot = protocolFactory.getProtocol(memoryBuffer)

      oprot.writeMessageBegin(new TMessage(name, TMessageType.REPLY, seqid))
      result.write(oprot)
      oprot.writeMessageEnd()
      oprot.getTransport().flush()

      // make a copy of the array of bytes to construct a new buffer because memoryBuffer is reusable
      Buf.ByteArray.Shared(memoryBuffer.getArray(), 0, memoryBuffer.length())
    } finally {
      tlReusableBuffer.reset()
    }
  }

  final def apply(request: Array[Byte]): Future[Array[Byte]] = {
    val inputTransport = new TMemoryInputTransport(request)
    val iprot = protocolFactory.getProtocol(inputTransport)

    try {
      val msg = iprot.readMessageBegin()
      val service = serviceMap.get(msg.name)
      service match {
        case _root_.scala.Some(svc) =>
          svc(iprot, msg.seqid)
        case _ =>
          TProtocolUtil.skip(iprot, TType.STRUCT)
          Future.value(Buf.ByteArray.Owned.extract(
            exception(msg.name, msg.seqid, TApplicationException.UNKNOWN_METHOD,
              "Invalid method name: '" + msg.name + "'")))
      }
    } catch {
      case e: Exception => Future.exception(e)
    }
  }

  private object ThriftMethodStats {
    def apply(stats: StatsReceiver): ThriftMethodStats =
      ThriftMethodStats(
        stats.counter("requests"),
        stats.counter("success"),
        stats.counter("failures"),
        stats.scope("failures")
      )
  }

  private case class ThriftMethodStats(
    requestsCounter: Counter,
    successCounter: Counter,
    failuresCounter: Counter,
    failuresScope: StatsReceiver
  )

  private def missingResult(name: String): TApplicationException = {
    new TApplicationException(
      TApplicationException.MISSING_RESULT,
      name + " failed: unknown result"
    )
  }

  private def setServiceName(ex: Throwable): Throwable =
    if (this.serviceName == "") ex
    else {
      ex match {
        case se: SourcedException =>
          se.serviceName = this.serviceName
          se
        case _ => ex
      }
    }

  private def recordResponse(reqRep: ctfs.ReqRep, methodStats: ThriftMethodStats): Unit = {
    val responseClass = responseClassifier.applyOrElse(reqRep, ctfs.ResponseClassifier.Default)
    responseClass match {
      case ctfs.ResponseClass.Successful(_) =>
        methodStats.successCounter.incr()
      case ctfs.ResponseClass.Failed(_) =>
        methodStats.failuresCounter.incr()
        reqRep.response match {
          case Throw(ex) =>
            methodStats.failuresScope.counter(Throwables.mkString(ex): _*).incr()
          case _ =>
        }
    }
  }

  final protected def perMethodStatsFilter(
    method: ThriftMethod
  ): finagle$Filter[(TProtocol, Int), Array[Byte], (TProtocol, Int), RichResponse[method.Args, method.Result]] = {
    val methodStats = ThriftMethodStats((if (serviceName != "") stats.scope(serviceName) else stats).scope(method.name))
    new finagle$Filter[(TProtocol, Int), Array[Byte], (TProtocol, Int), RichResponse[method.Args, method.Result]] {
      def apply(
        req: (TProtocol, Int),
        service: finagle$Service[(TProtocol, Int), RichResponse[method.Args, method.Result]]
      ): Future[Array[Byte]] = {
        methodStats.requestsCounter.incr()
        service(req).transform {
          case Return(value) =>
            value match {
              case SuccessfulResponse(req, _, result) =>
                recordResponse(ctfs.ReqRep(req, _root_.com.twitter.util.Return(result.successField.get)), methodStats)
              case ProtocolExceptionResponse(req, _, exp) =>
                recordResponse(ctfs.ReqRep(req, _root_.com.twitter.util.Throw(exp)), methodStats)
              case ThriftExceptionResponse(req, _, ex) =>
                val rep = ex match {
                  case exp: ThriftException => setServiceName(exp)
                  case _ => missingResult(serviceName)
                }
                recordResponse(ctfs.ReqRep(req, _root_.com.twitter.util.Throw(rep)), methodStats)
            }
            Future.value(Buf.ByteArray.Owned.extract(value.response))
          case t @ Throw(_) =>
            recordResponse(ctfs.ReqRep(req, t), methodStats)
            Future.const(t.cast[Array[Byte]])
        }
      }
    }
  }
  // ---- end boilerplate.

  addService("increment", {
    val statsFilter: finagle$Filter[(TProtocol, Int), Array[Byte], (TProtocol, Int), RichResponse[Increment.Args, Increment.Result]] = perMethodStatsFilter(Increment)
  
    val methodService = new finagle$Service[Increment.Args, Increment.SuccessType] {
      def apply(args: Increment.Args): Future[Increment.SuccessType] = {
        if (_root_.com.twitter.finagle.tracing.Trace.isActivelyTracing) {
          _root_.com.twitter.finagle.tracing.Trace.recordRpc("increment")
        }
        iface.increment(args.a)
      }
    }
  
    val protocolExnFilter = new SimpleFilter[(TProtocol, Int), RichResponse[Increment.Args, Increment.Result]] {
      def apply(
        request: (TProtocol, Int),
        service: finagle$Service[(TProtocol, Int), RichResponse[Increment.Args, Increment.Result]]
      ): Future[RichResponse[Increment.Args, Increment.Result]] = {
        val iprot = request._1
        val seqid = request._2
        val res = service(request)
        res.transform {
          case _root_.com.twitter.util.Throw(e: TProtocolException) =>
            iprot.readMessageEnd()
            Future.value(
              ProtocolExceptionResponse(
                null,
                exception("increment", seqid, TApplicationException.PROTOCOL_ERROR, e.getMessage),
                new TApplicationException(TApplicationException.PROTOCOL_ERROR, e.getMessage)))
          case _ =>
            res
        }
      }
    }
  
    val serdeFilter = new finagle$Filter[(TProtocol, Int), RichResponse[Increment.Args, Increment.Result], Increment.Args, Increment.SuccessType] {
      def apply(
        request: (TProtocol, Int),
        service: finagle$Service[Increment.Args, Increment.SuccessType]
      ): Future[RichResponse[Increment.Args, Increment.Result]] = {
        val iprot = request._1
        val seqid = request._2
        val args = Increment.Args.decode(iprot)
        iprot.readMessageEnd()
        val res = service(args)
        res.transform {
          case _root_.com.twitter.util.Return(value) =>
            val methodResult = Increment.Result(success = Some(value))
            Future.value(
              SuccessfulResponse(
                args,
                reply("increment", seqid, methodResult),
                methodResult))
          case t @ _root_.com.twitter.util.Throw(_) =>
            Future.const(t.cast[RichResponse[Increment.Args, Increment.Result]])
        }
      }
    }
  
    statsFilter.andThen(protocolExnFilter).andThen(serdeFilter).andThen(methodService)
  })
  addService("addNumbers", {
    val statsFilter: finagle$Filter[(TProtocol, Int), Array[Byte], (TProtocol, Int), RichResponse[AddNumbers.Args, AddNumbers.Result]] = perMethodStatsFilter(AddNumbers)
  
    val methodService = new finagle$Service[AddNumbers.Args, AddNumbers.SuccessType] {
      def apply(args: AddNumbers.Args): Future[AddNumbers.SuccessType] = {
        if (_root_.com.twitter.finagle.tracing.Trace.isActivelyTracing) {
          _root_.com.twitter.finagle.tracing.Trace.recordRpc("addNumbers")
        }
        iface.addNumbers(args.a, args.b)
      }
    }
  
    val protocolExnFilter = new SimpleFilter[(TProtocol, Int), RichResponse[AddNumbers.Args, AddNumbers.Result]] {
      def apply(
        request: (TProtocol, Int),
        service: finagle$Service[(TProtocol, Int), RichResponse[AddNumbers.Args, AddNumbers.Result]]
      ): Future[RichResponse[AddNumbers.Args, AddNumbers.Result]] = {
        val iprot = request._1
        val seqid = request._2
        val res = service(request)
        res.transform {
          case _root_.com.twitter.util.Throw(e: TProtocolException) =>
            iprot.readMessageEnd()
            Future.value(
              ProtocolExceptionResponse(
                null,
                exception("addNumbers", seqid, TApplicationException.PROTOCOL_ERROR, e.getMessage),
                new TApplicationException(TApplicationException.PROTOCOL_ERROR, e.getMessage)))
          case _ =>
            res
        }
      }
    }
  
    val serdeFilter = new finagle$Filter[(TProtocol, Int), RichResponse[AddNumbers.Args, AddNumbers.Result], AddNumbers.Args, AddNumbers.SuccessType] {
      def apply(
        request: (TProtocol, Int),
        service: finagle$Service[AddNumbers.Args, AddNumbers.SuccessType]
      ): Future[RichResponse[AddNumbers.Args, AddNumbers.Result]] = {
        val iprot = request._1
        val seqid = request._2
        val args = AddNumbers.Args.decode(iprot)
        iprot.readMessageEnd()
        val res = service(args)
        res.transform {
          case _root_.com.twitter.util.Return(value) =>
            val methodResult = AddNumbers.Result(success = Some(value))
            Future.value(
              SuccessfulResponse(
                args,
                reply("addNumbers", seqid, methodResult),
                methodResult))
          case t @ _root_.com.twitter.util.Throw(_) =>
            Future.const(t.cast[RichResponse[AddNumbers.Args, AddNumbers.Result]])
        }
      }
    }
  
    statsFilter.andThen(protocolExnFilter).andThen(serdeFilter).andThen(methodService)
  })
  addService("addStrings", {
    val statsFilter: finagle$Filter[(TProtocol, Int), Array[Byte], (TProtocol, Int), RichResponse[AddStrings.Args, AddStrings.Result]] = perMethodStatsFilter(AddStrings)
  
    val methodService = new finagle$Service[AddStrings.Args, AddStrings.SuccessType] {
      def apply(args: AddStrings.Args): Future[AddStrings.SuccessType] = {
        if (_root_.com.twitter.finagle.tracing.Trace.isActivelyTracing) {
          _root_.com.twitter.finagle.tracing.Trace.recordRpc("addStrings")
        }
        iface.addStrings(args.a, args.b)
      }
    }
  
    val protocolExnFilter = new SimpleFilter[(TProtocol, Int), RichResponse[AddStrings.Args, AddStrings.Result]] {
      def apply(
        request: (TProtocol, Int),
        service: finagle$Service[(TProtocol, Int), RichResponse[AddStrings.Args, AddStrings.Result]]
      ): Future[RichResponse[AddStrings.Args, AddStrings.Result]] = {
        val iprot = request._1
        val seqid = request._2
        val res = service(request)
        res.transform {
          case _root_.com.twitter.util.Throw(e: TProtocolException) =>
            iprot.readMessageEnd()
            Future.value(
              ProtocolExceptionResponse(
                null,
                exception("addStrings", seqid, TApplicationException.PROTOCOL_ERROR, e.getMessage),
                new TApplicationException(TApplicationException.PROTOCOL_ERROR, e.getMessage)))
          case _ =>
            res
        }
      }
    }
  
    val serdeFilter = new finagle$Filter[(TProtocol, Int), RichResponse[AddStrings.Args, AddStrings.Result], AddStrings.Args, AddStrings.SuccessType] {
      def apply(
        request: (TProtocol, Int),
        service: finagle$Service[AddStrings.Args, AddStrings.SuccessType]
      ): Future[RichResponse[AddStrings.Args, AddStrings.Result]] = {
        val iprot = request._1
        val seqid = request._2
        val args = AddStrings.Args.decode(iprot)
        iprot.readMessageEnd()
        val res = service(args)
        res.transform {
          case _root_.com.twitter.util.Return(value) =>
            val methodResult = AddStrings.Result(success = Some(value))
            Future.value(
              SuccessfulResponse(
                args,
                reply("addStrings", seqid, methodResult),
                methodResult))
          case t @ _root_.com.twitter.util.Throw(_) =>
            Future.const(t.cast[RichResponse[AddStrings.Args, AddStrings.Result]])
        }
      }
    }
  
    statsFilter.andThen(protocolExnFilter).andThen(serdeFilter).andThen(methodService)
  })
  addService("queryList", {
    val statsFilter: finagle$Filter[(TProtocol, Int), Array[Byte], (TProtocol, Int), RichResponse[QueryList.Args, QueryList.Result]] = perMethodStatsFilter(QueryList)
  
    val methodService = new finagle$Service[QueryList.Args, QueryList.SuccessType] {
      def apply(args: QueryList.Args): Future[QueryList.SuccessType] = {
        if (_root_.com.twitter.finagle.tracing.Trace.isActivelyTracing) {
          _root_.com.twitter.finagle.tracing.Trace.recordRpc("queryList")
        }
        iface.queryList(args.userQuery)
      }
    }
  
    val protocolExnFilter = new SimpleFilter[(TProtocol, Int), RichResponse[QueryList.Args, QueryList.Result]] {
      def apply(
        request: (TProtocol, Int),
        service: finagle$Service[(TProtocol, Int), RichResponse[QueryList.Args, QueryList.Result]]
      ): Future[RichResponse[QueryList.Args, QueryList.Result]] = {
        val iprot = request._1
        val seqid = request._2
        val res = service(request)
        res.transform {
          case _root_.com.twitter.util.Throw(e: TProtocolException) =>
            iprot.readMessageEnd()
            Future.value(
              ProtocolExceptionResponse(
                null,
                exception("queryList", seqid, TApplicationException.PROTOCOL_ERROR, e.getMessage),
                new TApplicationException(TApplicationException.PROTOCOL_ERROR, e.getMessage)))
          case _ =>
            res
        }
      }
    }
  
    val serdeFilter = new finagle$Filter[(TProtocol, Int), RichResponse[QueryList.Args, QueryList.Result], QueryList.Args, QueryList.SuccessType] {
      def apply(
        request: (TProtocol, Int),
        service: finagle$Service[QueryList.Args, QueryList.SuccessType]
      ): Future[RichResponse[QueryList.Args, QueryList.Result]] = {
        val iprot = request._1
        val seqid = request._2
        val args = QueryList.Args.decode(iprot)
        iprot.readMessageEnd()
        val res = service(args)
        res.transform {
          case _root_.com.twitter.util.Return(value) =>
            val methodResult = QueryList.Result(success = Some(value))
            Future.value(
              SuccessfulResponse(
                args,
                reply("queryList", seqid, methodResult),
                methodResult))
          case t @ _root_.com.twitter.util.Throw(_) =>
            Future.const(t.cast[RichResponse[QueryList.Args, QueryList.Result]])
        }
      }
    }
  
    statsFilter.andThen(protocolExnFilter).andThen(serdeFilter).andThen(methodService)
  })
  addService("getById", {
    val statsFilter: finagle$Filter[(TProtocol, Int), Array[Byte], (TProtocol, Int), RichResponse[GetById.Args, GetById.Result]] = perMethodStatsFilter(GetById)
  
    val methodService = new finagle$Service[GetById.Args, GetById.SuccessType] {
      def apply(args: GetById.Args): Future[GetById.SuccessType] = {
        if (_root_.com.twitter.finagle.tracing.Trace.isActivelyTracing) {
          _root_.com.twitter.finagle.tracing.Trace.recordRpc("getById")
        }
        iface.getById(args.uid)
      }
    }
  
    val protocolExnFilter = new SimpleFilter[(TProtocol, Int), RichResponse[GetById.Args, GetById.Result]] {
      def apply(
        request: (TProtocol, Int),
        service: finagle$Service[(TProtocol, Int), RichResponse[GetById.Args, GetById.Result]]
      ): Future[RichResponse[GetById.Args, GetById.Result]] = {
        val iprot = request._1
        val seqid = request._2
        val res = service(request)
        res.transform {
          case _root_.com.twitter.util.Throw(e: TProtocolException) =>
            iprot.readMessageEnd()
            Future.value(
              ProtocolExceptionResponse(
                null,
                exception("getById", seqid, TApplicationException.PROTOCOL_ERROR, e.getMessage),
                new TApplicationException(TApplicationException.PROTOCOL_ERROR, e.getMessage)))
          case _ =>
            res
        }
      }
    }
  
    val serdeFilter = new finagle$Filter[(TProtocol, Int), RichResponse[GetById.Args, GetById.Result], GetById.Args, GetById.SuccessType] {
      def apply(
        request: (TProtocol, Int),
        service: finagle$Service[GetById.Args, GetById.SuccessType]
      ): Future[RichResponse[GetById.Args, GetById.Result]] = {
        val iprot = request._1
        val seqid = request._2
        val args = GetById.Args.decode(iprot)
        iprot.readMessageEnd()
        val res = service(args)
        res.transform {
          case _root_.com.twitter.util.Return(value) =>
            val methodResult = GetById.Result(success = Some(value))
            Future.value(
              SuccessfulResponse(
                args,
                reply("getById", seqid, methodResult),
                methodResult))
          case t @ _root_.com.twitter.util.Throw(_) =>
            Future.const(t.cast[RichResponse[GetById.Args, GetById.Result]])
        }
      }
    }
  
    statsFilter.andThen(protocolExnFilter).andThen(serdeFilter).andThen(methodService)
  })
}
