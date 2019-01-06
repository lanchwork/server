package com.seal.ljk.common

import com.seal.ljk.model.SysPartner

object SysDictUtil {

    var sysDict: MutableMap<String, List<Map<String, Any?>>> = mutableMapOf()

    fun mapOf(vararg keys: String): MutableMap<String, List<Map<String, Any?>>> {
        val result = mutableMapOf<String, List<Map<String, Any?>>>()
        keys.forEach { sysDict[it]?.apply { result[it] = this } }
        return result
    }

    fun updateSysPartner(sysPartner: SysPartner) {
        sysDict["partner"]?.apply {
            SysDictUtil.sysDict["partner"] = this.map {
                if (it["value"] == sysPartner.channelMark) {
                    mapOf(
                            "value" to sysPartner.channelMark,
                            "showVal" to sysPartner.partnerName
                    )
                } else {
                    it
                }
            }
        }
    }

    fun addSysPartner(sysPartner: SysPartner) {
        sysDict["partner"]?.apply {
            val list = this.toMutableList()
            list.add(mapOf(
                    "value" to sysPartner.channelMark,
                    "showVal" to sysPartner.partnerName
            ))
            SysDictUtil.sysDict["partner"] = list
        }
    }

    fun initDict(sysDictTypes: List<Map<String, String>>) {
        val dicMap = sysDictTypes.groupBy { it["code"] }

        dicMap.forEach { code, list ->
            code?.apply {
                sysDict[code] = list.map {
                    mapOf(
                            "value" to it["value"],
                            "showVal" to it["show_val"]
                    )
                }
            }
        }
    }

    fun initPartner(partners: List<SysPartner>) {
        sysDict["partner"] = partners.map {
            mapOf(
                    "value" to it.channelMark,
                    "showVal" to it.partnerName
            )
        }
    }

}
