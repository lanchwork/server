package com.seal.ljk.service

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONObject
import com.seal.ljk.common.HttpUtil
import org.springframework.stereotype.Service


/**
 * @description: 合作方(公司)信息统计
 *
 * @author: tingyx
 *
 * @create: 2018-11-26 13:34
 **/
@Service
class PartnerStatisticsService {

    /**
     * @Description: 调用炼金控的接口获取合作方上链的统计信息
     * @Param: 合作方Id
     * @Return: 合作方统计信息
     * @Author: tingyx
     * @Time: 2018-11-26 13:42
     */
    fun DoPartnerStatisticsApi(partnerId: String): Map<String, Any>{
        val param = mapOf<String, Any>("channelMark" to partnerId)
        //map转json
        val dataJson = JSONObject.toJSON(param).toString()
        //请求路径
        val url = "http://localhost:8080"
        var api = "/api/seal/queryOperationalStatistics"
        //发送API请求并将结果解析为Json
        val response = JSON.parseObject(HttpUtil.post(url + api, dataJson))

        //获取统计数据
        val resArray = response.getJSONObject("data").getJSONArray("list")
        if(resArray.isEmpty())
            return mapOf()
        else
            return resArray.getJSONObject(0).toMap()
    }

}