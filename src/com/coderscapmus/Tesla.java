package com.coderscapmus;

public class Tesla {
	String date = "";
	String sales = "";
	
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
	@Override
	public String toString() {
		return "Tesla [date=" + date + ", Sales=" + sales + "]";
	}
	

}
