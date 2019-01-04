package com.seal.ljk.common

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.TypeReference
import com.seal.ljk.base.SealException
import com.seal.ljk.model.TzTokenMeta
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

/**
 * 钱包项目关联工具
 * Created by chenjh on 2019-01-04.
 */
@Component
@ConfigurationProperties("wallet-config")
object WalletUtil {

    @Value("\${wallet-config.url}")
    lateinit var url: String

    fun getTokenMetaByNos(tokenNos: Array<String>): List<TzTokenMeta>? {
        val resultJson = HttpUtil.post("$url/tokenMeta/infos", JSON.toJSONString(mapOf(
                "tokenNos" to tokenNos
        )))
        val resData = JSON.parseObject(resultJson, object : TypeReference<ResData<List<TzTokenMeta>>>() {})
        if (resData.code != 0) {
            throw SealException(message = resData.msg)
        }
        return resData.data
    }


}
