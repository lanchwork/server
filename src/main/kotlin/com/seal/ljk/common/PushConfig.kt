package com.seal.ljk.common

import cn.jiguang.common.ClientConfig
import cn.jpush.api.JPushClient
import cn.jpush.api.push.model.Message
import cn.jpush.api.push.model.Platform
import cn.jpush.api.push.model.PushPayload
import cn.jpush.api.push.model.audience.Audience
import cn.jpush.api.push.model.notification.AndroidNotification
import cn.jpush.api.push.model.notification.IosNotification
import cn.jpush.api.push.model.notification.Notification
import com.seal.ljk.base.loggerFor
import okhttp3.FormBody
import okhttp3.Request
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component
import java.net.URLEncoder

@Component
@ConfigurationProperties(prefix = "push")
class PushUtil {

    @Value("\${push.sms.url}")
    lateinit var smsUrl: String
    @Value("\${push.sms.corp_id}")
    lateinit var smsCorpId: String
    @Value("\${push.sms.corp_pwd}")
    lateinit var smsCorpPwd: String
    @Value("\${push.sms.corp_service}")
    lateinit var smsCorpService: String
    @Value("\${push.sms.ext}")
    lateinit var smsExt: String


    @Value("\${push.jpush.url}")
    lateinit var jpushUrl: String
    @Value("\${push.jpush.key}")
    lateinit var jpushKey: String
    @Value("\${push.jpush.secret}")
    lateinit var jpushSecret: String


    private val log = loggerFor(this.javaClass)

    fun sendSMS(mobile: String, content: String) {

        val body = with(FormBody.Builder()) {

            add("corp_id", smsCorpId)
            add("corp_pwd", smsCorpPwd)
            add("corp_service", smsCorpService)
            add("corp_msg_id", "")
            add("ext", smsExt)
            add("mobile", mobile)

            addEncoded("msg_content", URLEncoder.encode(content, "GBK"))
            this.build()
        }

        val request = Request.Builder().url(smsUrl).post(body).build()
        val response = HttpUtil.getRawResponse(request)
        val result = response.body().string()

        val code = result.split("#")[1]
        log.debug("send SMS content:$content to $mobile, response:$code")
    }

    fun sendPush(alias: String, title: String, content: String, extras: Map<String, String>) {
        val jpushClient = JPushClient(jpushSecret, jpushKey, null, ClientConfig.getInstance())

        val payload = PushPayload.newBuilder()
                .setPlatform(Platform.android_ios())
                .setAudience(Audience.alias(alias))
                .setNotification(Notification.newBuilder()
                        .setAlert(content)
                        .addPlatformNotification(AndroidNotification.newBuilder()
                                .setTitle(title)
                                .setAlert(content)
                                .addExtras(extras)
                                .build())
                        .addPlatformNotification(IosNotification.newBuilder()
                                .setAlert(mapOf(
                                        "title" to title,
                                        "alert" to content
                                ))
                                .incrBadge(1)
                                .setContentAvailable(true)
                                .setSound("sound.caf")
                                .addExtras(extras)
                                .build())
                        .build())
                .setMessage(Message.newBuilder()
                        .setMsgContent(content)
                        .setTitle(title)
                        .addExtras(extras)
                        .build())
                .build()

        try {
            val result = jpushClient.sendPush(payload)
            log.debug("push success - $result")
        } catch (e: Exception) {
            log.debug(e.message)
        }


    }
}


