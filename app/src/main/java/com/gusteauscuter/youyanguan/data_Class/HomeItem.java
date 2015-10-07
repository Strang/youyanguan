package com.gusteauscuter.youyanguan.data_Class;

import com.gusteauscuter.youyanguan.data_Class.book.Book;
import com.gusteauscuter.youyanguan.data_Class.course.Course;

import java.io.Serializable;

public class HomeItem implements Serializable {

	private static int typeNull=0;
	private static int typeBook=1;
	private static int typeSchedule=2;
	private int type;

	private String title;
	private String date;
	private String description;
	private Object sourceObject;

	public String getTitle(){
		return this.title;
	}

	public String getDate(){
		return this.date;
	}

	public String getDescription(){
		return this.description;
	}

	public Object getSourceObject(){
		return this.sourceObject;
	}

	public HomeItem(int type, String title, String date,
					String description, Object sourceObject){
		this.type=type;
		this.title=title;
		this.date=date;
		this.description=description;
		this.sourceObject=sourceObject;
	}

//	public HomeItem(){
//		this(typeNull,"null","this is empty data" ,"no date",new Book());
//	}

//	public HomeItem(){
//		this(new Book());
//	}

	public HomeItem(Book book){
		this(typeBook,book.getTitle(),book.getReturnDay(),
				book.getDescription(),book);
	}

	public HomeItem(Course schedual){
		this(typeSchedule,schedual.getName(),schedual.getTeacher(),
				String.valueOf(schedual.getWhichWeek()),schedual);
	}







}
