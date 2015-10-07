package com.gusteauscuter.youyanguan.data_Class.course;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ziqian on 2015/9/23.
 */
public class Course  implements Serializable {

    private String name;
    private String teacher;

    private int startWeek;
    private int endWeek;
    private int whichWeek;

    static int AllleWeek=0;
    static int SingleWeek=1;
    static int DoubleeWeek=2;

//    private List<TimeAndPosition> timeAndPositions;
    private TimeAndPosition timeAndPositions;


    public Course() {
        this("示例课程","",1,10,AllleWeek);
    }

    /**Test
     *
     * @param weekday 周几上课
     */
    public Course(int weekday) {
        this("示例课程","",1,10,AllleWeek);
        this.setTimeAndPositions(new TimeAndPosition(weekday,"10:00","340101"));
    }

    /**
     *
     * @param name
     * @param teacher
     * @param startWeek
     * @param endWeek
     * @param whichWeek
     * @param timeAndPositions
     */

    public Course(String name, String teacher, int startWeek, int endWeek,
                  int whichWeek, TimeAndPosition timeAndPositions) {
        this.name = name;
        this.teacher = teacher;
        this.startWeek = startWeek;
        this.endWeek = endWeek;
        this.whichWeek = whichWeek;
        this.timeAndPositions = timeAndPositions;
    }

    /**
     *
     * @param name
     * @param teacher
     * @param startWeek
     * @param endWeek
     * @param whichWeek
     */

    public Course(String name, String teacher, int startWeek, int endWeek,
                  int whichWeek) {
        this.name = name;
        this.teacher = teacher;
        this.startWeek = startWeek;
        this.endWeek = endWeek;
        this.whichWeek = whichWeek;
        this.timeAndPositions = new TimeAndPosition();
//        this.timeAndPositions = new ArrayList<>();
//        timeAndPositions.add(new TimeAndPosition());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public int getStartWeek() {
        return startWeek;
    }

    public void setStartWeek(int startWeek) {
        this.startWeek = startWeek;
    }

    public int getEndWeek() {
        return endWeek;
    }

    public void setEndWeek(int endWeek) {
        this.endWeek = endWeek;
    }

    public int getWhichWeek() {
        return whichWeek;
    }

    public void setWhichWeek(int whichWeek) {
        this.whichWeek = whichWeek;
    }

//    public List<TimeAndPosition> getTimeAndPositions() {
//        return timeAndPositions;
//    }

    public TimeAndPosition getTimeAndPositions() {
        return timeAndPositions;
    }

//    public void setTimeAndPositions(List<TimeAndPosition> timeAndPositions) {
//        this.timeAndPositions = timeAndPositions;
//    }

    public void setTimeAndPositions(TimeAndPosition timeAndPositions) {
        this.timeAndPositions = timeAndPositions;
    }

    /**
     *
     */
    public class TimeAndPosition implements Serializable{
        private int weekday;
        private String time;
        private String position;

        /**
         *
         */
        public TimeAndPosition() {
            this(1,"9:00","34号楼");
        }

        /**
         *
         * @param weekday
         * @param time
         * @param position
         */
        public TimeAndPosition(int weekday, String time, String position) {
            this.weekday = weekday;
            this.time = time;
            this.position = position;
        }

        public int getWeekday() {
            return weekday;
        }

        public String getTime() {
            return time;
        }

        public String getPosition() {
            return position;
        }

        public void setWeekday(int weekday) {
            this.weekday = weekday;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }


}
