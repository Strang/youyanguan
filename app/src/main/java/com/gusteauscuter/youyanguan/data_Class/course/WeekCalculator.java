package com.gusteauscuter.youyanguan.data_Class.course;

/**
 * Created by hu on 2015/10/3.
 * 计算当前周是第几周
 */
public class WeekCalculator {

    public static final int EVEN_WEEK = 2;
    public static final int ODD_WEEK = 1;
    public static final int EVERY_WEEK = 0;

    private int startDate; //开始上课的第一天

    public WeekCalculator(int startDate) {
        this.startDate = startDate;
    }


    /**
     * 利用startDate计算当前属于第几周
     * @return 第几周
     */
    public int getWeekNumber() {
        return 0;
    }

    /**
     * 计算当前是周几
     * @return 周几
     */
    public int getWeekday() {
        return 0;
    }


}
