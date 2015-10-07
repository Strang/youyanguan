package com.gusteauscuter.youyanguan.data_Class.book;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class LocationInformation {
	private String location;
	private String detailLocation;
	private String searchNum;
	private String barcode;
	private String volume;
	private String status;
	
	public LocationInformation(Element tr) {
		Elements elements = tr.getElementsByTag("td");
		location = elements.get(0).text();
		detailLocation = elements.get(1).text();
		searchNum = elements.get(2).text();
		barcode = elements.get(3).text();
		volume = elements.get(4).text();
		status = elements.get(5).text();
				
	}
	
	public String toString() {
		return location + "||" + detailLocation
				+ "\n" + searchNum + "||" + barcode + "||" + volume + "||" + status;
				
	}
	
	public String getLocation() {
		return location;
	}
	public String getDetailLocation() {
		return detailLocation;
	}
	public String getSearchNum() {
		return searchNum;
	}
	public String getBarcode() {
		return barcode;
	}
	public String getVolume() {
		return volume;
	}
	public String getStatus() {
		return status;
	}
	
	
	
}
