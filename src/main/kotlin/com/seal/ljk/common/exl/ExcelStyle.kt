package com.seal.ljk.common.exl


import org.apache.poi.hssf.usermodel.HSSFCellStyle
import org.apache.poi.hssf.usermodel.HSSFFont
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.hssf.util.HSSFColor

/**
 * 设置Excel样式
 */
object ExcelStyle {

    /**
     * 设置头样式
     *
     * @param workbook
     * @param style
     * @return
     */
    fun setHeadStyle(workbook: HSSFWorkbook, style: HSSFCellStyle): HSSFCellStyle {

        style.fillForegroundColor = HSSFColor.LIGHT_BLUE.index
        style.fillPattern = HSSFCellStyle.SOLID_FOREGROUND
        style.borderBottom = HSSFCellStyle.BORDER_THIN
        style.borderLeft = HSSFCellStyle.BORDER_THIN
        style.borderRight = HSSFCellStyle.BORDER_THIN
        style.borderTop = HSSFCellStyle.BORDER_THIN
        style.alignment = HSSFCellStyle.ALIGN_CENTER

        val font = workbook.createFont() // 生成字体
        font.color = HSSFColor.VIOLET.index
        font.fontHeightInPoints = 12.toShort()
        font.boldweight = HSSFFont.BOLDWEIGHT_BOLD

        style.setFont(font) // 把字体应用到当前的样样式
        return style

    }

    /**
     * 设置数据体样式
     *
     * @param workbook
     * @param style
     * @return
     */
    fun setBodyStyle(workbook: HSSFWorkbook, style: HSSFCellStyle): HSSFCellStyle {
        style.fillForegroundColor = HSSFColor.LIGHT_YELLOW.index
        style.fillPattern = HSSFCellStyle.SOLID_FOREGROUND
        style.borderBottom = HSSFCellStyle.BORDER_THIN
        style.borderLeft = HSSFCellStyle.BORDER_THIN
        style.borderRight = HSSFCellStyle.BORDER_THIN
        style.borderTop = HSSFCellStyle.BORDER_THIN
        style.alignment = HSSFCellStyle.ALIGN_LEFT
        style.verticalAlignment = HSSFCellStyle.VERTICAL_CENTER

        val font = workbook.createFont() //生成字体
        font.boldweight = HSSFFont.BOLDWEIGHT_NORMAL

        style.setFont(font) //把字体应用到当前的样样式
        return style
    }
}
