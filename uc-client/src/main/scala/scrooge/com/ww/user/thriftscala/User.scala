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


object User extends ThriftStructCodec3[User] {
  val NoPassthroughFields: immutable$Map[Short, TFieldBlob] = immutable$Map.empty[Short, TFieldBlob]
  val Struct = new TStruct("User")
  val IdField = new TField("id", TType.I32, 1)
  val IdFieldManifest = implicitly[Manifest[Int]]
  val UidField = new TField("uid", TType.STRING, 2)
  val UidFieldManifest = implicitly[Manifest[String]]
  val NickField = new TField("nick", TType.STRING, 3)
  val NickFieldManifest = implicitly[Manifest[String]]
  val IconUrlField = new TField("iconUrl", TType.STRING, 4)
  val IconUrlFieldManifest = implicitly[Manifest[String]]
  val UNameField = new TField("uName", TType.STRING, 5)
  val UNameFieldManifest = implicitly[Manifest[String]]
  val MobileField = new TField("mobile", TType.I64, 6)
  val MobileFieldManifest = implicitly[Manifest[Long]]

  /**
   * Field information in declaration order.
   */
  lazy val fieldInfos: scala.List[ThriftStructFieldInfo] = scala.List[ThriftStructFieldInfo](
    new ThriftStructFieldInfo(
      IdField,
      false,
      false,
      IdFieldManifest,
      _root_.scala.None,
      _root_.scala.None,
      immutable$Map.empty[String, String],
      immutable$Map.empty[String, String],
      None
    ),
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
      NickField,
      true,
      false,
      NickFieldManifest,
      _root_.scala.None,
      _root_.scala.None,
      immutable$Map.empty[String, String],
      immutable$Map.empty[String, String],
      None
    ),
    new ThriftStructFieldInfo(
      IconUrlField,
      true,
      false,
      IconUrlFieldManifest,
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
    ),
    new ThriftStructFieldInfo(
      MobileField,
      true,
      false,
      MobileFieldManifest,
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
  def validate(_item: User): Unit = {
  }

  def withoutPassthroughFields(original: User): User =
    new Immutable(
      id =
        {
          val field = original.id
          field
        },
      uid =
        {
          val field = original.uid
          field
        },
      nick =
        {
          val field = original.nick
          field.map { field =>
            field
          }
        },
      iconUrl =
        {
          val field = original.iconUrl
          field.map { field =>
            field
          }
        },
      uName =
        {
          val field = original.uName
          field
        },
      mobile =
        {
          val field = original.mobile
          field.map { field =>
            field
          }
        }
    )

  override def encode(_item: User, _oproto: TProtocol): Unit = {
    _item.write(_oproto)
  }


  private[this] def lazyDecode(_iprot: LazyTProtocol): User = {

    var id: Int = 0
    var uidOffset: Int = -1
    var nickOffset: Int = -1
    var iconUrlOffset: Int = -1
    var uNameOffset: Int = -1
    var mobileOffset: Int = -1

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
              case TType.I32 =>
    
                id = readIdValue(_iprot)
              case _actualType =>
                val _expectedType = TType.I32
                throw new TProtocolException(
                  "Received wrong type for field 'id' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 2 =>
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
          case 3 =>
            _field.`type` match {
              case TType.STRING =>
                nickOffset = _iprot.offsetSkipString
    
              case _actualType =>
                val _expectedType = TType.STRING
                throw new TProtocolException(
                  "Received wrong type for field 'nick' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 4 =>
            _field.`type` match {
              case TType.STRING =>
                iconUrlOffset = _iprot.offsetSkipString
    
              case _actualType =>
                val _expectedType = TType.STRING
                throw new TProtocolException(
                  "Received wrong type for field 'iconUrl' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 5 =>
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
          case 6 =>
            _field.`type` match {
              case TType.I64 =>
                mobileOffset = _iprot.offsetSkipI64
    
              case _actualType =>
                val _expectedType = TType.I64
                throw new TProtocolException(
                  "Received wrong type for field 'mobile' (expected=%s, actual=%s).".format(
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
      id,
      uidOffset,
      nickOffset,
      iconUrlOffset,
      uNameOffset,
      mobileOffset,
      if (_passthroughFields == null)
        NoPassthroughFields
      else
        _passthroughFields.result()
    )
  }

  override def decode(_iprot: TProtocol): User =
    _iprot match {
      case i: LazyTProtocol => lazyDecode(i)
      case i => eagerDecode(i)
    }

  private[thriftscala] def eagerDecode(_iprot: TProtocol): User = {
    var id: Int = 0
    var uid: String = null
    var nick: _root_.scala.Option[String] = _root_.scala.None
    var iconUrl: _root_.scala.Option[String] = _root_.scala.None
    var uName: String = null
    var mobile: _root_.scala.Option[Long] = _root_.scala.None
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
              case TType.I32 =>
                id = readIdValue(_iprot)
              case _actualType =>
                val _expectedType = TType.I32
                throw new TProtocolException(
                  "Received wrong type for field 'id' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 2 =>
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
          case 3 =>
            _field.`type` match {
              case TType.STRING =>
                nick = _root_.scala.Some(readNickValue(_iprot))
              case _actualType =>
                val _expectedType = TType.STRING
                throw new TProtocolException(
                  "Received wrong type for field 'nick' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 4 =>
            _field.`type` match {
              case TType.STRING =>
                iconUrl = _root_.scala.Some(readIconUrlValue(_iprot))
              case _actualType =>
                val _expectedType = TType.STRING
                throw new TProtocolException(
                  "Received wrong type for field 'iconUrl' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 5 =>
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
          case 6 =>
            _field.`type` match {
              case TType.I64 =>
                mobile = _root_.scala.Some(readMobileValue(_iprot))
              case _actualType =>
                val _expectedType = TType.I64
                throw new TProtocolException(
                  "Received wrong type for field 'mobile' (expected=%s, actual=%s).".format(
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
      id,
      uid,
      nick,
      iconUrl,
      uName,
      mobile,
      if (_passthroughFields == null)
        NoPassthroughFields
      else
        _passthroughFields.result()
    )
  }

  def apply(
    id: Int,
    uid: String,
    nick: _root_.scala.Option[String] = _root_.scala.None,
    iconUrl: _root_.scala.Option[String] = _root_.scala.None,
    uName: String,
    mobile: _root_.scala.Option[Long] = _root_.scala.None
  ): User =
    new Immutable(
      id,
      uid,
      nick,
      iconUrl,
      uName,
      mobile
    )

  def unapply(_item: User): _root_.scala.Option[_root_.scala.Tuple6[Int, String, Option[String], Option[String], String, Option[Long]]] = _root_.scala.Some(_item.toTuple)


  @inline private[thriftscala] def readIdValue(_iprot: TProtocol): Int = {
    _iprot.readI32()
  }

  @inline private def writeIdField(id_item: Int, _oprot: TProtocol): Unit = {
    _oprot.writeFieldBegin(IdField)
    writeIdValue(id_item, _oprot)
    _oprot.writeFieldEnd()
  }

  @inline private def writeIdValue(id_item: Int, _oprot: TProtocol): Unit = {
    _oprot.writeI32(id_item)
  }

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

  @inline private[thriftscala] def readNickValue(_iprot: TProtocol): String = {
    _iprot.readString()
  }

  @inline private def writeNickField(nick_item: String, _oprot: TProtocol): Unit = {
    _oprot.writeFieldBegin(NickField)
    writeNickValue(nick_item, _oprot)
    _oprot.writeFieldEnd()
  }

  @inline private def writeNickValue(nick_item: String, _oprot: TProtocol): Unit = {
    _oprot.writeString(nick_item)
  }

  @inline private[thriftscala] def readIconUrlValue(_iprot: TProtocol): String = {
    _iprot.readString()
  }

  @inline private def writeIconUrlField(iconUrl_item: String, _oprot: TProtocol): Unit = {
    _oprot.writeFieldBegin(IconUrlField)
    writeIconUrlValue(iconUrl_item, _oprot)
    _oprot.writeFieldEnd()
  }

  @inline private def writeIconUrlValue(iconUrl_item: String, _oprot: TProtocol): Unit = {
    _oprot.writeString(iconUrl_item)
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

  @inline private[thriftscala] def readMobileValue(_iprot: TProtocol): Long = {
    _iprot.readI64()
  }

  @inline private def writeMobileField(mobile_item: Long, _oprot: TProtocol): Unit = {
    _oprot.writeFieldBegin(MobileField)
    writeMobileValue(mobile_item, _oprot)
    _oprot.writeFieldEnd()
  }

  @inline private def writeMobileValue(mobile_item: Long, _oprot: TProtocol): Unit = {
    _oprot.writeI64(mobile_item)
  }


  object Immutable extends ThriftStructCodec3[User] {
    override def encode(_item: User, _oproto: TProtocol): Unit = { _item.write(_oproto) }
    override def decode(_iprot: TProtocol): User = User.decode(_iprot)
    override lazy val metaData: ThriftStructMetaData[User] = User.metaData
  }

  /**
   * The default read-only implementation of User.  You typically should not need to
   * directly reference this class; instead, use the User.apply method to construct
   * new instances.
   */
  class Immutable(
      val id: Int,
      val uid: String,
      val nick: _root_.scala.Option[String],
      val iconUrl: _root_.scala.Option[String],
      val uName: String,
      val mobile: _root_.scala.Option[Long],
      override val _passthroughFields: immutable$Map[Short, TFieldBlob])
    extends User {
    def this(
      id: Int,
      uid: String,
      nick: _root_.scala.Option[String] = _root_.scala.None,
      iconUrl: _root_.scala.Option[String] = _root_.scala.None,
      uName: String,
      mobile: _root_.scala.Option[Long] = _root_.scala.None
    ) = this(
      id,
      uid,
      nick,
      iconUrl,
      uName,
      mobile,
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
      val id: Int,
      uidOffset: Int,
      nickOffset: Int,
      iconUrlOffset: Int,
      uNameOffset: Int,
      mobileOffset: Int,
      override val _passthroughFields: immutable$Map[Short, TFieldBlob])
    extends User {

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
    lazy val nick: _root_.scala.Option[String] =
      if (nickOffset == -1)
        None
      else {
        Some(_proto.decodeString(_buf, nickOffset))
      }
    lazy val iconUrl: _root_.scala.Option[String] =
      if (iconUrlOffset == -1)
        None
      else {
        Some(_proto.decodeString(_buf, iconUrlOffset))
      }
    lazy val uName: String =
      if (uNameOffset == -1)
        null
      else {
        _proto.decodeString(_buf, uNameOffset)
      }
    lazy val mobile: _root_.scala.Option[Long] =
      if (mobileOffset == -1)
        None
      else {
        Some(_proto.decodeI64(_buf, mobileOffset))
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
   * This Proxy trait allows you to extend the User trait with additional state or
   * behavior and implement the read-only methods from User using an underlying
   * instance.
   */
  trait Proxy extends User {
    protected def _underlying_User: User
    override def id: Int = _underlying_User.id
    override def uid: String = _underlying_User.uid
    override def nick: _root_.scala.Option[String] = _underlying_User.nick
    override def iconUrl: _root_.scala.Option[String] = _underlying_User.iconUrl
    override def uName: String = _underlying_User.uName
    override def mobile: _root_.scala.Option[Long] = _underlying_User.mobile
    override def _passthroughFields = _underlying_User._passthroughFields
  }
}

/**
 * Prefer the companion object's [[com.ww.user.thriftscala.User.apply]]
 * for construction if you don't need to specify passthrough fields.
 */
trait User
  extends ThriftStruct
  with _root_.scala.Product6[Int, String, Option[String], Option[String], String, Option[Long]]
  with HasThriftStructCodec3[User]
  with java.io.Serializable
{
  import User._

  def id: Int
  def uid: String
  def nick: _root_.scala.Option[String]
  def iconUrl: _root_.scala.Option[String]
  def uName: String
  def mobile: _root_.scala.Option[Long]

  def _passthroughFields: immutable$Map[Short, TFieldBlob] = immutable$Map.empty

  def _1 = id
  def _2 = uid
  def _3 = nick
  def _4 = iconUrl
  def _5 = uName
  def _6 = mobile

  def toTuple: _root_.scala.Tuple6[Int, String, Option[String], Option[String], String, Option[Long]] = {
    (
      id,
      uid,
      nick,
      iconUrl,
      uName,
      mobile
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
              if (true) {
                writeIdValue(id, _oprot)
                _root_.scala.Some(User.IdField)
              } else {
                _root_.scala.None
              }
            case 2 =>
              if (uid ne null) {
                writeUidValue(uid, _oprot)
                _root_.scala.Some(User.UidField)
              } else {
                _root_.scala.None
              }
            case 3 =>
              if (nick.isDefined) {
                writeNickValue(nick.get, _oprot)
                _root_.scala.Some(User.NickField)
              } else {
                _root_.scala.None
              }
            case 4 =>
              if (iconUrl.isDefined) {
                writeIconUrlValue(iconUrl.get, _oprot)
                _root_.scala.Some(User.IconUrlField)
              } else {
                _root_.scala.None
              }
            case 5 =>
              if (uName ne null) {
                writeUNameValue(uName, _oprot)
                _root_.scala.Some(User.UNameField)
              } else {
                _root_.scala.None
              }
            case 6 =>
              if (mobile.isDefined) {
                writeMobileValue(mobile.get, _oprot)
                _root_.scala.Some(User.MobileField)
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
  def setField(_blob: TFieldBlob): User = {
    var id: Int = this.id
    var uid: String = this.uid
    var nick: _root_.scala.Option[String] = this.nick
    var iconUrl: _root_.scala.Option[String] = this.iconUrl
    var uName: String = this.uName
    var mobile: _root_.scala.Option[Long] = this.mobile
    var _passthroughFields = this._passthroughFields
    _blob.id match {
      case 1 =>
        id = readIdValue(_blob.read)
      case 2 =>
        uid = readUidValue(_blob.read)
      case 3 =>
        nick = _root_.scala.Some(readNickValue(_blob.read))
      case 4 =>
        iconUrl = _root_.scala.Some(readIconUrlValue(_blob.read))
      case 5 =>
        uName = readUNameValue(_blob.read)
      case 6 =>
        mobile = _root_.scala.Some(readMobileValue(_blob.read))
      case _ => _passthroughFields += (_blob.id -> _blob)
    }
    new Immutable(
      id,
      uid,
      nick,
      iconUrl,
      uName,
      mobile,
      _passthroughFields
    )
  }

  /**
   * If the specified field is optional, it is set to None.  Otherwise, if the field is
   * known, it is reverted to its default value; if the field is unknown, it is removed
   * from the passthroughFields map, if present.
   */
  def unsetField(_fieldId: Short): User = {
    var id: Int = this.id
    var uid: String = this.uid
    var nick: _root_.scala.Option[String] = this.nick
    var iconUrl: _root_.scala.Option[String] = this.iconUrl
    var uName: String = this.uName
    var mobile: _root_.scala.Option[Long] = this.mobile

    _fieldId match {
      case 1 =>
        id = 0
      case 2 =>
        uid = null
      case 3 =>
        nick = _root_.scala.None
      case 4 =>
        iconUrl = _root_.scala.None
      case 5 =>
        uName = null
      case 6 =>
        mobile = _root_.scala.None
      case _ =>
    }
    new Immutable(
      id,
      uid,
      nick,
      iconUrl,
      uName,
      mobile,
      _passthroughFields - _fieldId
    )
  }

  /**
   * If the specified field is optional, it is set to None.  Otherwise, if the field is
   * known, it is reverted to its default value; if the field is unknown, it is removed
   * from the passthroughFields map, if present.
   */
  def unsetId: User = unsetField(1)

  def unsetUid: User = unsetField(2)

  def unsetNick: User = unsetField(3)

  def unsetIconUrl: User = unsetField(4)

  def unsetUName: User = unsetField(5)

  def unsetMobile: User = unsetField(6)


  override def write(_oprot: TProtocol): Unit = {
    User.validate(this)
    _oprot.writeStructBegin(Struct)
    writeIdField(id, _oprot)
    if (uid ne null) writeUidField(uid, _oprot)
    if (nick.isDefined) writeNickField(nick.get, _oprot)
    if (iconUrl.isDefined) writeIconUrlField(iconUrl.get, _oprot)
    if (uName ne null) writeUNameField(uName, _oprot)
    if (mobile.isDefined) writeMobileField(mobile.get, _oprot)
    if (_passthroughFields.nonEmpty) {
      _passthroughFields.values.foreach { _.write(_oprot) }
    }
    _oprot.writeFieldStop()
    _oprot.writeStructEnd()
  }

  def copy(
    id: Int = this.id,
    uid: String = this.uid,
    nick: _root_.scala.Option[String] = this.nick,
    iconUrl: _root_.scala.Option[String] = this.iconUrl,
    uName: String = this.uName,
    mobile: _root_.scala.Option[Long] = this.mobile,
    _passthroughFields: immutable$Map[Short, TFieldBlob] = this._passthroughFields
  ): User =
    new Immutable(
      id,
      uid,
      nick,
      iconUrl,
      uName,
      mobile,
      _passthroughFields
    )

  override def canEqual(other: Any): Boolean = other.isInstanceOf[User]

  private def _equals(x: User, y: User): Boolean =
      x.productArity == y.productArity &&
      x.productIterator.sameElements(y.productIterator)

  override def equals(other: Any): Boolean =
    canEqual(other) &&
      _equals(this, other.asInstanceOf[User]) &&
      _passthroughFields == other.asInstanceOf[User]._passthroughFields

  override def hashCode: Int = _root_.scala.runtime.ScalaRunTime._hashCode(this)

  override def toString: String = _root_.scala.runtime.ScalaRunTime._toString(this)


  override def productArity: Int = 6

  override def productElement(n: Int): Any = n match {
    case 0 => this.id
    case 1 => this.uid
    case 2 => this.nick
    case 3 => this.iconUrl
    case 4 => this.uName
    case 5 => this.mobile
    case _ => throw new IndexOutOfBoundsException(n.toString)
  }

  override def productPrefix: String = "User"

  def _codec: ThriftStructCodec3[User] = User
}

