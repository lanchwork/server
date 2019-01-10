package com.seal.ljk.common

import com.seal.ljk.base.loggerFor
import okhttp3.FormBody
import okhttp3.Request
import java.net.URLEncoder

object SMSUtil {

    private val log = loggerFor(this.javaClass)

    fun sendSMSContent(mobile: String, content: String){
        val url = "http://sms.hbsmservice.com:8080/sms_send2.do"
        val map = mapOf(
                "corp_id" to "hb0104",
                "corp_pwd" to "seal52",
                "corp_service" to "106914393301",
                "mobile" to mobile,
                "corp_msg_id" to "",
                "ext" to "1205"
        )

        val bodyBuilder = FormBody.Builder()
        map.forEach {
            bodyBuilder.add(it.key, it.value)
        }
        val contentEncoded = URLEncoder.encode(content, "GBK")
        bodyBuilder.addEncoded("msg_content",contentEncoded)

        val body = bodyBuilder.build()
        val request = Request.Builder().url(url).post(body).build()
        val response = HttpUtil.getRawResponse(request)
        val result = response.body().string()

        val code = result.split("#")[1]
        log.info("send SMS content:$content to $mobile, response:$code")
    }

}