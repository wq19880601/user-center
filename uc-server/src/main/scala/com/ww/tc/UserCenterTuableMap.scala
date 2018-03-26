package com.ww.tc

import com.twitter.util.tunable.{ServiceLoadedTunableMap, Tunable, TunableMap}

class UserCenterTuableMap  extends ServiceLoadedTunableMap{
  override def id: String = "usercenter"

  override def apply[Duration](key: TunableMap.Key[Duration]): Tunable[Duration] = {

    Tunable.
  }

}
