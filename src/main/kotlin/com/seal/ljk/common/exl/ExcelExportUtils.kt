package com.seal.ljk.common.exl

import com.alibaba.druid.util.StringUtils
import org.apache.poi.hssf.usermodel.*
import org.apache.poi.ss.usermodel.ClientAnchor
import org.slf4j.LoggerFactory

import java.lang.reflect.Field
import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Pattern


class ExcelExportUtils<T : Any> {

    /**
     * 功能说明: 导出Excel
     */
    @Throws(Exception::class)
    fun exportExcel(title: String?, dataset: List<T>?, classes: Class<*>): HSSFWorkbook {

        if (dataset == null || title == null) {
            throw Exception("传入的数据不正确，数据集为空或标题为空！")
        }

        val filed = classes.declaredFields
        return this.exportExcel(title, dataset, filed)
    }

    /**
     * 导出Excel
     *
     * @param title   标题
     * @param dataset 集合
     * @param
     */
    @Throws(Exception::class)
    fun exportExcel(title: String?, dataset: List<T>?): HSSFWorkbook {
        if (dataset == null || title == null || dataset.size == 0) {
            throw Exception("传入的数据不正确，数据集为空或标题为空！")
        }
        val its = dataset.iterator()
        val filed = its.next().javaClass.getDeclaredFields()

        return this.exportExcel(title, dataset, filed)
    }

    private fun exportExcel(title: String, dataset: List<T>, filed: Array<Field>): HSSFWorkbook {
        val workbook = HSSFWorkbook()

        try {

            val sheet = workbook.createSheet(title)

            val headStyle = workbook.createCellStyle()

            val bodyStyle = workbook.createCellStyle()

            val exportMetas = ArrayList<Array<Any>>()

            // 遍历整个filed
            for (i in filed.indices) {
                val f = filed[i]
                val exa = f.getAnnotation(ExcelAnnotation::class.java)
                // 如果设置了annottion
                if (exa != null) {
                    val exprot = exa.exportName
                    val pattern = exa.pattern
                    val order = Integer.valueOf(exa.order)

                    // 添加到标题
                    exportMetas.add(arrayOf(f.name, exprot, pattern, order))
                }
            }

            // 排序exportMetas
            Collections.sort(exportMetas) { o1, o2 ->
                /** 根据元注释order 排列顺序  */
                val order1 = o1[3] as Int
                val order2 = o2[3] as Int
                order1.compareTo(order2)
            }

            // 产生表格标题行
            var row = sheet.createRow(0)
            for (i in exportMetas.indices) {
                val cell = row.createCell(i)
                cell.setCellStyle(headStyle)
                val text = HSSFRichTextString(
                        exportMetas[i][1] as String)
                cell.setCellValue(text)
            }

            // 循环整个集合
            for (i in dataset.indices) {
                row = sheet.createRow(i + 1) // 第一行为标题列, 从1开始写excel
                val t = dataset[i]

                for (k in exportMetas.indices) {
                    val cell = row.createCell(k)
                    val fieldName = exportMetas[k][0] as String
                    val getMethodName = ("get"
                            + fieldName.substring(0, 1).toUpperCase()
                            + fieldName.substring(1))
                    val tCls = t.javaClass
                    val getMethod = tCls.getMethod(getMethodName,
                            *arrayOf())
                    val value = getMethod.invoke(t, *arrayOf())
                    val textValue = getValue(value, exportMetas[k])

                    val richString = HSSFRichTextString(
                            textValue)
                    cell.setCellValue(richString)
                    cell.setCellStyle(bodyStyle)
                }
            }

        } catch (e: Exception) {
            e.printStackTrace()
            logger.error(e.message, e)
        }

        return workbook
    }

    fun getValue(value: Any?, meta: Array<Any>): String {
        var textValue = ""
        if (value == null)
            return textValue

        if (value is Boolean) {
            val bValue = (value as Boolean?)!!
            textValue = "是"
            if (!bValue) {
                textValue = "否"
            }
        } else if (value is Date) {
            var pattern = meta[2] as String
            if (StringUtils.isEmpty(pattern))
                pattern = "yyyy-MM-dd"
            textValue = parse2StandardDate((value as Date?)!!, pattern)
        } else {
            textValue = value.toString()
        }

        return textValue
    }


    fun exportExcelTemp(title: String, resultList: List<Array<Any>>, exportMetas: Array<Any>): HSSFWorkbook {
        val workbook = HSSFWorkbook()

        try {

            val sheet = workbook.createSheet(title)

            val headStyle = workbook.createCellStyle()

            val bodyStyle = workbook.createCellStyle()


            // 产生表格标题行
            var row = sheet.createRow(0)
            for (i in exportMetas.indices) {
                val cell = row.createCell(i)
                cell.setCellStyle(headStyle)
                val text = HSSFRichTextString(
                        exportMetas[i] as String)
                cell.setCellValue(text)
            }

            // 循环整个集合
            for (i in resultList.indices) {
                row = sheet.createRow(i + 1) // 第一行为标题列, 从1开始写excel
                for (k in exportMetas.indices) {
                    val cell = row.createCell(k)
                    val richString = HSSFRichTextString(resultList[i][k].toString())
                    cell.setCellValue(richString)
                    cell.setCellStyle(bodyStyle)
                }
            }

        } catch (e: Exception) {
            e.printStackTrace()
            logger.error(e.message, e)
        }

        return workbook
    }


    fun exportExcelAsHeader(title: String, headers: Array<String>, Col: Array<String>, dataset: Collection<T>, pattern: String): HSSFWorkbook {

        val workbook = HSSFWorkbook()

        try {
            val sheet = workbook.createSheet(title)
            val headStyle = workbook.createCellStyle()
            val bodyStyle = workbook.createCellStyle()

            // 产生表格标题行
            var row = sheet.createRow(0)
            val patriarch = sheet.createDrawingPatriarch()
            var Cell = 0
            for (i in headers.indices) {
                val cell = row.createCell(Cell)
                cell.setCellStyle(headStyle)
                val text = HSSFRichTextString(headers[i])
                cell.setCellValue(text)
                Cell++
            }
            // 遍历集合数据，产生数据行
            val it = dataset.iterator()
            var index = 0
            while (it.hasNext()) {
                index++
                row = sheet.createRow(index)
                val t = it.next()
                val fields = Col
                Cell = 0
                val font3 = workbook.createFont()
                for (i in fields.indices) {
                    val fieldName = fields[i]
                    val cell = row.createCell(Cell)
                    cell.setCellStyle(bodyStyle)

                    var value: Any? = ""
                    var tCls: Class<*>? = null
                    var map: Map<*, *>? = null
                    if (t is Map<*, *>) {
                        map = t
                        value = map[fieldName]
                    } else {
                        val getMethodName = ("get"
                                + fieldName.substring(0, 1).toUpperCase()
                                + fieldName.substring(1))
                        tCls = t.javaClass
                        val getMethod = tCls.getMethod(getMethodName, *arrayOf())
                        value = getMethod.invoke(t, *arrayOf())


                    }
                    if (value == null) value = ""


                    // 判断值的类型后进行强制类型转换
                    var textValue: String? = null
                    if (value is Date) {
                        val date = value as Date?
                        val sdf = SimpleDateFormat(pattern)
                        textValue = sdf.format(date)
                    } else if (value is ByteArray) {
                        // 有图片时，设置行高为60px;
                        row.heightInPoints = 60f
                        // 设置图片所在列宽度为80px,注意这里单位的一个换算
                        sheet.setColumnWidth(Cell, (35.7 * 80).toShort().toInt())
                        val bsValue = value as ByteArray?
                        val anchor = HSSFClientAnchor(0, 0,
                                1023, 255, 6.toShort(), index, 6.toShort(), index)
                        anchor.anchorType = ClientAnchor.AnchorType.byId(2)
                        patriarch.createPicture(anchor, workbook.addPicture(
                                bsValue!!, HSSFWorkbook.PICTURE_TYPE_JPEG))
                    } else {
                        // 其它数据类型都当作字符串简单处理
                        textValue = value.toString()
                    }

                    if (textValue != null) {
                        val p = Pattern.compile("^//d+(//.//d+)?$")
                        val matcher = p.matcher(textValue)
                        if (matcher.matches()) {
                            cell.setCellValue(java.lang.Double.parseDouble(textValue))
                        } else {
                            val richString = HSSFRichTextString(
                                    textValue)
                            richString.applyFont(font3)
                            cell.setCellValue(richString)
                        }
                    }
                    Cell++

                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            logger.error(e.message, e)
        }

        return workbook
    }

    companion object {
        private val logger = LoggerFactory.getLogger(ExcelExportUtils::class.java)

        fun parse2StandardDate(date: Date, dateFormat: String): String {
            var dateFormat = dateFormat
            if (StringUtils.isEmpty(dateFormat)) {
                dateFormat = "yyyy-MM-dd"
            }
            try {
                val sdf = SimpleDateFormat(dateFormat)
                return sdf.format(date)
            } catch (e: Exception) {
                return ""
            }

        }
    }
}