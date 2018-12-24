package com.seal.ljk.common

import com.seal.ljk.model.User

/**
 * Created by chenjh on 2018/12/24.
 */
object SessionUtil {
    
    val USER_SESSION = ThreadLocal<User>()
}

fun setSessionUser(user: User) {
    SessionUtil.USER_SESSION.set(user)
}

fun getSessionUser(): User? {
    return SessionUtil.USER_SESSION.get()
}
