/**
 * Generated by Scrooge
 *   version: 18.2.0
 *   rev: 13c26e196ec2a399833771a335ae98afcc4d6b57
 *   built at: 20180205-165339
 */
package com.ww.user.thriftscala

import com.twitter.io.Buf
import com.twitter.scrooge.{
  HasThriftStructCodec3,
  LazyTProtocol,
  TFieldBlob,
  ThriftException,
  ThriftStruct,
  ThriftStructCodec3,
  ThriftStructFieldInfo,
  ThriftStructMetaData,
  ThriftUtil
}
import org.apache.thrift.protocol._
import org.apache.thrift.transport.{TMemoryBuffer, TTransport, TIOStreamTransport}
import java.io.ByteArrayInputStream
import java.nio.ByteBuffer
import java.util.Arrays
import java.util.concurrent.atomic.AtomicInteger
import scala.collection.immutable.{Map => immutable$Map}
import scala.collection.mutable.Builder
import scala.collection.mutable.{
  ArrayBuffer => mutable$ArrayBuffer, Buffer => mutable$Buffer,
  HashMap => mutable$HashMap, HashSet => mutable$HashSet}
import scala.collection.{Map, Set}


object UserQuery extends ThriftStructCodec3[UserQuery] {
  val NoPassthroughFields: immutable$Map[Short, TFieldBlob] = immutable$Map.empty[Short, TFieldBlob]
  val Struct = new TStruct("UserQuery")
  val UidField = new TField("uid", TType.STRING, 1)
  val UidFieldManifest = implicitly[Manifest[String]]
  val UNameField = new TField("uName", TType.STRING, 2)
  val UNameFieldManifest = implicitly[Manifest[String]]

  /**
   * Field information in declaration order.
   */
  lazy val fieldInfos: scala.List[ThriftStructFieldInfo] = scala.List[ThriftStructFieldInfo](
    new ThriftStructFieldInfo(
      UidField,
      false,
      false,
      UidFieldManifest,
      _root_.scala.None,
      _root_.scala.None,
      immutable$Map.empty[String, String],
      immutable$Map.empty[String, String],
      None
    ),
    new ThriftStructFieldInfo(
      UNameField,
      false,
      false,
      UNameFieldManifest,
      _root_.scala.None,
      _root_.scala.None,
      immutable$Map.empty[String, String],
      immutable$Map.empty[String, String],
      None
    )
  )

  lazy val structAnnotations: immutable$Map[String, String] =
    immutable$Map.empty[String, String]

  /**
   * Checks that all required fields are non-null.
   */
  def validate(_item: UserQuery): Unit = {
  }

  def withoutPassthroughFields(original: UserQuery): UserQuery =
    new Immutable(
      uid =
        {
          val field = original.uid
          field
        },
      uName =
        {
          val field = original.uName
          field
        }
    )

  override def encode(_item: UserQuery, _oproto: TProtocol): Unit = {
    _item.write(_oproto)
  }


  private[this] def lazyDecode(_iprot: LazyTProtocol): UserQuery = {

    var uidOffset: Int = -1
    var uNameOffset: Int = -1

    var _passthroughFields: Builder[(Short, TFieldBlob), immutable$Map[Short, TFieldBlob]] = null
    var _done = false
    val _start_offset = _iprot.offset

    _iprot.readStructBegin()
    while (!_done) {
      val _field = _iprot.readFieldBegin()
      if (_field.`type` == TType.STOP) {
        _done = true
      } else {
        _field.id match {
          case 1 =>
            _field.`type` match {
              case TType.STRING =>
                uidOffset = _iprot.offsetSkipString
    
              case _actualType =>
                val _expectedType = TType.STRING
                throw new TProtocolException(
                  "Received wrong type for field 'uid' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 2 =>
            _field.`type` match {
              case TType.STRING =>
                uNameOffset = _iprot.offsetSkipString
    
              case _actualType =>
                val _expectedType = TType.STRING
                throw new TProtocolException(
                  "Received wrong type for field 'uName' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case _ =>
            if (_passthroughFields == null)
              _passthroughFields = immutable$Map.newBuilder[Short, TFieldBlob]
            _passthroughFields += (_field.id -> TFieldBlob.read(_field, _iprot))
        }
        _iprot.readFieldEnd()
      }
    }
    _iprot.readStructEnd()

    new LazyImmutable(
      _iprot,
      _iprot.buffer,
      _start_offset,
      _iprot.offset,
      uidOffset,
      uNameOffset,
      if (_passthroughFields == null)
        NoPassthroughFields
      else
        _passthroughFields.result()
    )
  }

  override def decode(_iprot: TProtocol): UserQuery =
    _iprot match {
      case i: LazyTProtocol => lazyDecode(i)
      case i => eagerDecode(i)
    }

  private[thriftscala] def eagerDecode(_iprot: TProtocol): UserQuery = {
    var uid: String = null
    var uName: String = null
    var _passthroughFields: Builder[(Short, TFieldBlob), immutable$Map[Short, TFieldBlob]] = null
    var _done = false

    _iprot.readStructBegin()
    while (!_done) {
      val _field = _iprot.readFieldBegin()
      if (_field.`type` == TType.STOP) {
        _done = true
      } else {
        _field.id match {
          case 1 =>
            _field.`type` match {
              case TType.STRING =>
                uid = readUidValue(_iprot)
              case _actualType =>
                val _expectedType = TType.STRING
                throw new TProtocolException(
                  "Received wrong type for field 'uid' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 2 =>
            _field.`type` match {
              case TType.STRING =>
                uName = readUNameValue(_iprot)
              case _actualType =>
                val _expectedType = TType.STRING
                throw new TProtocolException(
                  "Received wrong type for field 'uName' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case _ =>
            if (_passthroughFields == null)
              _passthroughFields = immutable$Map.newBuilder[Short, TFieldBlob]
            _passthroughFields += (_field.id -> TFieldBlob.read(_field, _iprot))
        }
        _iprot.readFieldEnd()
      }
    }
    _iprot.readStructEnd()

    new Immutable(
      uid,
      uName,
      if (_passthroughFields == null)
        NoPassthroughFields
      else
        _passthroughFields.result()
    )
  }

  def apply(
    uid: String,
    uName: String
  ): UserQuery =
    new Immutable(
      uid,
      uName
    )

  def unapply(_item: UserQuery): _root_.scala.Option[_root_.scala.Tuple2[String, String]] = _root_.scala.Some(_item.toTuple)


  @inline private[thriftscala] def readUidValue(_iprot: TProtocol): String = {
    _iprot.readString()
  }

  @inline private def writeUidField(uid_item: String, _oprot: TProtocol): Unit = {
    _oprot.writeFieldBegin(UidField)
    writeUidValue(uid_item, _oprot)
    _oprot.writeFieldEnd()
  }

  @inline private def writeUidValue(uid_item: String, _oprot: TProtocol): Unit = {
    _oprot.writeString(uid_item)
  }

  @inline private[thriftscala] def readUNameValue(_iprot: TProtocol): String = {
    _iprot.readString()
  }

  @inline private def writeUNameField(uName_item: String, _oprot: TProtocol): Unit = {
    _oprot.writeFieldBegin(UNameField)
    writeUNameValue(uName_item, _oprot)
    _oprot.writeFieldEnd()
  }

  @inline private def writeUNameValue(uName_item: String, _oprot: TProtocol): Unit = {
    _oprot.writeString(uName_item)
  }


  object Immutable extends ThriftStructCodec3[UserQuery] {
    override def encode(_item: UserQuery, _oproto: TProtocol): Unit = { _item.write(_oproto) }
    override def decode(_iprot: TProtocol): UserQuery = UserQuery.decode(_iprot)
    override lazy val metaData: ThriftStructMetaData[UserQuery] = UserQuery.metaData
  }

  /**
   * The default read-only implementation of UserQuery.  You typically should not need to
   * directly reference this class; instead, use the UserQuery.apply method to construct
   * new instances.
   */
  class Immutable(
      val uid: String,
      val uName: String,
      override val _passthroughFields: immutable$Map[Short, TFieldBlob])
    extends UserQuery {
    def this(
      uid: String,
      uName: String
    ) = this(
      uid,
      uName,
      Map.empty
    )
  }

  /**
   * This is another Immutable, this however keeps strings as lazy values that are lazily decoded from the backing
   * array byte on read.
   */
  private[this] class LazyImmutable(
      _proto: LazyTProtocol,
      _buf: Array[Byte],
      _start_offset: Int,
      _end_offset: Int,
      uidOffset: Int,
      uNameOffset: Int,
      override val _passthroughFields: immutable$Map[Short, TFieldBlob])
    extends UserQuery {

    override def write(_oprot: TProtocol): Unit = {
      _oprot match {
        case i: LazyTProtocol => i.writeRaw(_buf, _start_offset, _end_offset - _start_offset)
        case _ => super.write(_oprot)
      }
    }

    lazy val uid: String =
      if (uidOffset == -1)
        null
      else {
        _proto.decodeString(_buf, uidOffset)
      }
    lazy val uName: String =
      if (uNameOffset == -1)
        null
      else {
        _proto.decodeString(_buf, uNameOffset)
      }

    /**
     * Override the super hash code to make it a lazy val rather than def.
     *
     * Calculating the hash code can be expensive, caching it where possible
     * can provide significant performance wins. (Key in a hash map for instance)
     * Usually not safe since the normal constructor will accept a mutable map or
     * set as an arg
     * Here however we control how the class is generated from serialized data.
     * With the class private and the contract that we throw away our mutable references
     * having the hash code lazy here is safe.
     */
    override lazy val hashCode = super.hashCode
  }

  /**
   * This Proxy trait allows you to extend the UserQuery trait with additional state or
   * behavior and implement the read-only methods from UserQuery using an underlying
   * instance.
   */
  trait Proxy extends UserQuery {
    protected def _underlying_UserQuery: UserQuery
    override def uid: String = _underlying_UserQuery.uid
    override def uName: String = _underlying_UserQuery.uName
    override def _passthroughFields = _underlying_UserQuery._passthroughFields
  }
}

/**
 * Prefer the companion object's [[com.ww.user.thriftscala.UserQuery.apply]]
 * for construction if you don't need to specify passthrough fields.
 */
trait UserQuery
  extends ThriftStruct
  with _root_.scala.Product2[String, String]
  with HasThriftStructCodec3[UserQuery]
  with java.io.Serializable
{
  import UserQuery._

  def uid: String
  def uName: String

  def _passthroughFields: immutable$Map[Short, TFieldBlob] = immutable$Map.empty

  def _1 = uid
  def _2 = uName

  def toTuple: _root_.scala.Tuple2[String, String] = {
    (
      uid,
      uName
    )
  }


  /**
   * Gets a field value encoded as a binary blob using TCompactProtocol.  If the specified field
   * is present in the passthrough map, that value is returned.  Otherwise, if the specified field
   * is known and not optional and set to None, then the field is serialized and returned.
   */
  def getFieldBlob(_fieldId: Short): _root_.scala.Option[TFieldBlob] = {
    lazy val _buff = new TMemoryBuffer(32)
    lazy val _oprot = new TCompactProtocol(_buff)
    _passthroughFields.get(_fieldId) match {
      case blob: _root_.scala.Some[TFieldBlob] => blob
      case _root_.scala.None => {
        val _fieldOpt: _root_.scala.Option[TField] =
          _fieldId match {
            case 1 =>
              if (uid ne null) {
                writeUidValue(uid, _oprot)
                _root_.scala.Some(UserQuery.UidField)
              } else {
                _root_.scala.None
              }
            case 2 =>
              if (uName ne null) {
                writeUNameValue(uName, _oprot)
                _root_.scala.Some(UserQuery.UNameField)
              } else {
                _root_.scala.None
              }
            case _ => _root_.scala.None
          }
        _fieldOpt match {
          case _root_.scala.Some(_field) =>
            _root_.scala.Some(TFieldBlob(_field, Buf.ByteArray.Owned(_buff.getArray())))
          case _root_.scala.None =>
            _root_.scala.None
        }
      }
    }
  }

  /**
   * Collects TCompactProtocol-encoded field values according to `getFieldBlob` into a map.
   */
  def getFieldBlobs(ids: TraversableOnce[Short]): immutable$Map[Short, TFieldBlob] =
    (ids flatMap { id => getFieldBlob(id) map { id -> _ } }).toMap

  /**
   * Sets a field using a TCompactProtocol-encoded binary blob.  If the field is a known
   * field, the blob is decoded and the field is set to the decoded value.  If the field
   * is unknown and passthrough fields are enabled, then the blob will be stored in
   * _passthroughFields.
   */
  def setField(_blob: TFieldBlob): UserQuery = {
    var uid: String = this.uid
    var uName: String = this.uName
    var _passthroughFields = this._passthroughFields
    _blob.id match {
      case 1 =>
        uid = readUidValue(_blob.read)
      case 2 =>
        uName = readUNameValue(_blob.read)
      case _ => _passthroughFields += (_blob.id -> _blob)
    }
    new Immutable(
      uid,
      uName,
      _passthroughFields
    )
  }

  /**
   * If the specified field is optional, it is set to None.  Otherwise, if the field is
   * known, it is reverted to its default value; if the field is unknown, it is removed
   * from the passthroughFields map, if present.
   */
  def unsetField(_fieldId: Short): UserQuery = {
    var uid: String = this.uid
    var uName: String = this.uName

    _fieldId match {
      case 1 =>
        uid = null
      case 2 =>
        uName = null
      case _ =>
    }
    new Immutable(
      uid,
      uName,
      _passthroughFields - _fieldId
    )
  }

  /**
   * If the specified field is optional, it is set to None.  Otherwise, if the field is
   * known, it is reverted to its default value; if the field is unknown, it is removed
   * from the passthroughFields map, if present.
   */
  def unsetUid: UserQuery = unsetField(1)

  def unsetUName: UserQuery = unsetField(2)


  override def write(_oprot: TProtocol): Unit = {
    UserQuery.validate(this)
    _oprot.writeStructBegin(Struct)
    if (uid ne null) writeUidField(uid, _oprot)
    if (uName ne null) writeUNameField(uName, _oprot)
    if (_passthroughFields.nonEmpty) {
      _passthroughFields.values.foreach { _.write(_oprot) }
    }
    _oprot.writeFieldStop()
    _oprot.writeStructEnd()
  }

  def copy(
    uid: String = this.uid,
    uName: String = this.uName,
    _passthroughFields: immutable$Map[Short, TFieldBlob] = this._passthroughFields
  ): UserQuery =
    new Immutable(
      uid,
      uName,
      _passthroughFields
    )

  override def canEqual(other: Any): Boolean = other.isInstanceOf[UserQuery]

  private def _equals(x: UserQuery, y: UserQuery): Boolean =
      x.productArity == y.productArity &&
      x.productIterator.sameElements(y.productIterator)

  override def equals(other: Any): Boolean =
    canEqual(other) &&
      _equals(this, other.asInstanceOf[UserQuery]) &&
      _passthroughFields == other.asInstanceOf[UserQuery]._passthroughFields

  override def hashCode: Int = _root_.scala.runtime.ScalaRunTime._hashCode(this)

  override def toString: String = _root_.scala.runtime.ScalaRunTime._toString(this)


  override def productArity: Int = 2

  override def productElement(n: Int): Any = n match {
    case 0 => this.uid
    case 1 => this.uName
    case _ => throw new IndexOutOfBoundsException(n.toString)
  }

  override def productPrefix: String = "UserQuery"

  def _codec: ThriftStructCodec3[UserQuery] = UserQuery
}

