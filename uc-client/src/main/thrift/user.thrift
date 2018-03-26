namespace java com.ww.user.thriftjava
#@namespace scala com.ww.user.thriftscala


struct User {
1: i32 id,
2: string uid,
3: optional string nick,
4: optional string iconUrl,
5: string uName,
6: optional i64 mobile
}

struct UserQuery{
1: string uid,
2:string uName
}

service UserService {

// calculate service

/**
   * Increment a number
   */
  i32 increment( 1: i32 a )
  /**
   * Add two numbers
   */
  i32 addNumbers( 1: i32 a 2: i32 b )
  /**
   * Add two strings
   */
  string addStrings( 1: string a 2: string b )

    // user service
  list<User> queryList(1: UserQuery userQuery)

  User getById(1:string uid)

}