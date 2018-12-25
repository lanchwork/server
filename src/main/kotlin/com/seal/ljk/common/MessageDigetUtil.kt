package com.seal.ljk.common

import java.io.ByteArrayOutputStream
import java.io.ObjectOutputStream
import java.io.Serializable
import java.security.MessageDigest


/**
 * Created by cjh on 2018/12/10.
 */
object MessageDigetUtil {
    
    fun md5Pass(pass: String): String {
        return md5(pass + Constant.SEAL_SALT)
    }
    /**
     * 用户登录用的比较广泛
     */
    fun md5(input: String): String {
        val digest = MessageDigest.getInstance("MD5")
        val result = digest.digest(input.toByteArray())
        return toHex(result)
    }
    
    fun sha256(input: String): String {
        val digest = MessageDigest.getInstance("SHA-256")
        val result = digest.digest(input.toByteArray())
        return toHex(result)
    }
    
    fun sha256(input: Serializable): String {
        val baos = ByteArrayOutputStream()
        val oos = ObjectOutputStream(baos)
        oos.writeObject(input)
        oos.close()
        val digest = MessageDigest.getInstance("SHA-256")
        val result = digest.digest(baos.toByteArray())
        return toHex(result)
    }
    
    //转成16进制
    private fun toHex(byteArray: ByteArray): String {
        return with(StringBuilder()) {
            byteArray.forEach {
                val value = it
                val hex = value.toInt() and (0xFF)
                val hexStr = Integer.toHexString(hex)
                if (hexStr.length == 1) {
                    append("0").append(hexStr)
                } else {
                    append(hexStr)
                }
            }
            toString()
        }
        
    }
    
}

fun main(args: Array<String>) {
}
