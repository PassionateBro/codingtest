package com.test;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;

import java.util.Date;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2021-07-13 9:24
 */
public class NewSource {

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public Integer sourceId;


    public static void main(String[] args) {
        Date beginTime = DateUtil.offset(DateUtil.beginOfDay(DateUtil.parseDate("2023-11-14")), DateField.HOUR_OF_DAY, 24);
        System.out.println(beginTime);
        System.out.println(DateUtil.offset(beginTime, DateField.HOUR_OF_DAY, 24 * 7).toString());
    }
}
