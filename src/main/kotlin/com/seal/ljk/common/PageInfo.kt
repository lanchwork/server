package com.seal.ljk.common

import com.github.pagehelper.Page


/**
 * 分页类
 * @author hxl
 *
 * @param <T>
 */

class PageInfo<T> {

    var list: List<T>? = null            //保存查询的结果集合
    var totalRecord: Int? = 0        //总记录数
    var pageSize: Int? = 5       //页面显示的数目
    private var totalPage: Int? = null            //总页码数
    var currentPage:Int? = 1    //当前页码
    private var previousPage: Int? = 0        //前一页
    private var nextPage: Int? = 0            //后一页
    private var pageBar: IntArray? = null            //条目数
    /*	public int getSelectEndIndex() {     //oracle中的结束查询条件，供传入数据库参数使用
		return this.getStartIndex()+this.pageSize - 1;
	}*/

    constructor(list: List<T>?, totalRecord: Int, pageSize: Int, currentPage: Int) {
        this.list = list
        this.totalRecord = totalRecord
        this.pageSize = pageSize
        this.currentPage = currentPage
    }

    var startIndex: Int = 0
        get() {
            this.startIndex = (this.currentPage!! - 1) * this.pageSize!!
            return field
        }            //开始页
    //从数据库中获取的结束索引，供页面使用
    //不包含最后一条记录-1
    var endIndex: Int = 0
        get() {
            var end = this.startIndex + this.pageSize!!
            if (end > this.totalRecord!!) {
                end = this.startIndex + this.totalRecord!! % this.pageSize!!
            }
            this.endIndex = end
            return field
        }            //结束页



    fun getTotalPage(): Int? {
        //得到总页码数
        if (this.pageSize == 0) {
            this.totalPage = 1
        } else if (this.totalRecord!! % this.pageSize!! == 0) {
            this.totalPage = this.totalRecord!! / this.pageSize!!
        } else {
            this.totalPage = this.totalRecord!! / this.pageSize!! + 1
        }
        return totalPage
    }

    fun getPreviousPage(): Int {
        if (this.currentPage!! - 1 < 1) {      //如果上一页小于1，则说明当前页码已经是第一页了
            this.previousPage = 1
        } else {
            this.previousPage = this.currentPage!! - 1
        }
        return previousPage as Int
    }

    fun getNextPage(): Int {
        if (this.currentPage!! + 1 >= this.totalPage!!) {   //如果下一页大于总数页，则说明当前页码已经是最后一页了
            this.nextPage = this.totalPage!!
        } else {
            this.nextPage = this.currentPage!! + 1
        }
        return nextPage as Int
    }

    fun getPageBar(): IntArray {
        var startPage: Int      //记住页码的起始位置
        var endPage: Int        //记住页码的结束位置，因为页码条目是既定的，由startpage，endpage两个变量通过循环就可以得全部页码
        var pageBar: IntArray? = null
        if (this.getTotalPage()!! <= PAGEITEMCOUNT) {    //当总页码不足或等于既定页面大小时
            pageBar = IntArray(this.totalPage!!)
            startPage = 1
            endPage = this.totalPage!!
        } else {                    //当总页码大于既定页面大小时
            pageBar = IntArray(PAGEITEMCOUNT)
            startPage = this.currentPage!! - (PAGEITEMCOUNT / 2 - 1)    //为了保证当前页在中间
            endPage = this.currentPage!! + PAGEITEMCOUNT / 2

            if (startPage < 1) {
                startPage = 1
                endPage = PAGEITEMCOUNT
            }

            if (endPage > this.totalPage!!) {
                endPage = this.totalPage!!
                startPage = this.totalPage!! - (PAGEITEMCOUNT - 1)
            }
        }

        var index = 0
        for (i in startPage..endPage) {
            pageBar[index++] = i
        }

        this.pageBar = pageBar
        return this.pageBar!!
    }

    companion object {

        private val PAGEITEMCOUNT = 10  //显示页码条目数，即页码数量顶多是10个
    }

}

fun <T> Page<T>.getPageInfo(): PageInfo<T> {
    return PageInfo(this, this.total.toInt(), this.pageSize, this.pageNum)
}

fun <T> List<T>.getPageInfo(pageSize: Int, pageNum: Int, total: Int): PageInfo<T> {
    return PageInfo(this, total, pageSize, pageNum)
}
