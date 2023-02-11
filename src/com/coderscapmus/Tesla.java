package com.coderscapmus;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class Tesla {
	private String date = "";
	String sales = "";
	Integer salesInt = 0;
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM-yy");
	YearMonth ymdate=YearMonth.now();

	public YearMonth getYMDate(){
		return ymdate;
	  }

	  public void setYMDate(YearMonth ymdate){
	    this.ymdate = ymdate;
	  }
	  
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
	public Tesla(YearMonth ymdate, Integer salesInt) {
		this.ymdate = ymdate;
		this.salesInt = salesInt; 
	}
	  public Integer getSalesInt() {
		    return salesInt;
		  }
		  public void setSalesInt(Integer salesInt){
		    this.salesInt = salesInt;
		  }
	
	@Override
	public String toString() {
		return ""+ymdate;
	}
	

}
