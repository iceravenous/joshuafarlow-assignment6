package com.coderscapmus;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class Tesla {
	String date = "";
	String dateString = "Jan-23";
	String sales = "";
//	DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MMM-yy");
//	YearMonth yDate = YearMonth.parse(date, dateTimeFormatter);
	
//public class Tesla {
//	this.date = date;
//	this.sales = sales;
//}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getSales() {
		return sales;
	}
	public void setSales(String sales) {
		this.sales = sales;
	}
	public Tesla(String date, String sales) {
		this.date = date;
		this.sales = sales;
	}
//	public Tesla(String date, String sales, YearMonth yDate) {
//		this.date = date;
//		this.sales = sales;
//		this.yDate = yDate;
//	}
//	public void setYDate(YearMonth yDate) {
//		this.yDate = yDate;
//	}
//	public YearMonth getyDate() {
//		return yDate;
//	}
	
	@Override
	public String toString() {
		return "Tesla [date=" + date + ", Sales=" + sales + "]";
	}
	

}
