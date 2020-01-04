package com.slowgenius.someUtils.excel;


import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author slowgenius
 * @date 1/3/2020 2:32 PM
 * @description
 */
public class ExcelUtil {

    public void write() {
        String fileName = "C:\\Users\\slowgenius\\Desktop\\demo.xlsx";
        // 这里 需要指定写用哪个class去读，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, DemoData.class).sheet("模板").doWrite(data());
    }

    private List<DemoData> data() {
        List<DemoData> list = new ArrayList<DemoData>();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setString("字符串" + i);
            data.setDate(new Date());
            data.setDoubleData(0.56);
            list.add(data);
        }
        return list;
    }

    public static void main(String[] args) {
        ExcelUtil excelUtil = new ExcelUtil();
        excelUtil.write();
    }
}
