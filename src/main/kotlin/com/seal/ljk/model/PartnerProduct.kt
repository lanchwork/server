package com.seal.ljk.model

class PartnerProduct (
    var partnerProductId: String = "",    //合作方产品设置ID
    var allotProfitId:String = "",        //分润设置ID
    var productName:String = "",          //产品名称
    var dayRate:Int = 0,             //日利率（投）
    var isOpen:Int = 0,               //是否开启
    var endDate:String = ""              //截止日期
):Base()