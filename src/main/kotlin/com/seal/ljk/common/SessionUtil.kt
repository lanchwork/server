package com.seal.ljk.common

import com.seal.ljk.model.SysUser
import com.seal.ljk.model.User
import javax.servlet.http.HttpServletRequest

/**
 * Created by chenjh on 2018/12/24.
 */
object SessionUtil {

    val USER_SESSION = ThreadLocal<SysUser>()
    val REQUEST_HOLDER = ThreadLocal<HttpServletRequest>()
}

fun setSessionUser(user: SysUser) {
    SessionUtil.USER_SESSION.set(user)
}

fun getSessionUser(): SysUser? {
    return SessionUtil.USER_SESSION.get()
}

fun setRequest(request: HttpServletRequest) {
    SessionUtil.REQUEST_HOLDER.set(request)
}

fun getRequest(): HttpServletRequest? {
    return SessionUtil.REQUEST_HOLDER.get()
}
