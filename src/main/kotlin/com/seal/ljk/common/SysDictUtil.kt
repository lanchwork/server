package com.seal.ljk.common

import com.seal.ljk.model.SysPartner

object SysDictUtil {

    var sysDict: MutableMap<String, List<Map<String, String>>> = mutableMapOf()

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

}
