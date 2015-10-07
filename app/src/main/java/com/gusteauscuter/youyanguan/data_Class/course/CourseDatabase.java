package com.gusteauscuter.youyanguan.data_Class.course;

import java.util.List;

/**
 * Created by WangCe on 2015/10/3.
 */
public class CourseDatabase {

    List<Course> mCourseLists;

    public CourseDatabase() {
        Course aCourse = new Course();
        Course.TimeAndPosition timeAndPostion = aCourse.new TimeAndPosition();
        timeAndPostion.setPosition("35号楼502");
    }




    /**
     * 将课程数据存到CourseDatabase
     * @param courseLists
     * @return 如果储存成功，则返回值为true
     */
    public boolean addCourses(List<Course> courseLists) {

        return false;
    }

    /**
     * 将课程数据存到CourseDatabase
     * @param course
     * @return 如果储存成功，则返回值为true
     */
    public boolean addCourses(Course course) {

        return false;
    }

    /**
     * 从CourseDatabase中删除课程数据
     * @param course
     * @return 如果删除成功，则返回值为true
     */
    public boolean deleteCourses(Course course) {

        return false;
    }
    /**
     * 从本地数据库查询课程，查询第几周的所有课程，区分单周和双周
     * @param weekNumber 第几周
     * @return
     */
    public List<Course> searchCourses(int weekNumber) {

//        WeekCalculator weekCalculator = new WeekCalculator(150910); //在外面的activity中计算出是第几周，作为参数传进来
//        int weekNumber = weekCalculator.getWeekNumber();

        int evenOrOdd = (weekNumber % 2 == 0) ? WeekCalculator.EVEN_WEEK : WeekCalculator.ODD_WEEK;

        // TODO: 2015/10/3 根据当前是第几周,和是单周还是双周，从本地数据库中查询课程数据
        List<Course> courseLists = null;
        return courseLists;

    }

    /**
     * 从bmob数据库查询课程，
     * @param academy 学院
     * @param courseName 课程名称，关键字，模糊查询
     * @return
     */
    public List<Course> searchCourses(String academy, String courseName) {
        return null;
    }

    /**
     * 从本地数据库查询课程，查询第几周星期几的所有课程，区分单周和双周
     * @param weekNumber 第几周
     * @param weekday 星期几
     * @return
     */
    public List<Course> searchCourses(int weekNumber, int weekday) {

//        WeekCalculator weekCalculator = new WeekCalculator(150910);
//        int weekNumber = weekCalculator.getWeekNumber();//在外面的activity中计算出是第几周，作为参数传进来
//        int weekday = weekCalculator.getWeekday();//在外面的activity中计算出是周几，作为参数传进来


        int evenOrOdd = (weekNumber % 2 == 0) ? WeekCalculator.EVEN_WEEK : WeekCalculator.ODD_WEEK;

        // TODO: 2015/10/3 根据当前是第几周,和是单周还是双周，是周几，从本地数据库中查询课程数据
        List<Course> courseLists = null;
        return courseLists;

    }


}
