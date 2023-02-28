package com.coderscapmus;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class TeslaSales {
	Integer salesInt = 0;
	YearMonth ymdate = YearMonth.now();

	public TeslaSales(YearMonth ymdate, Integer salesInt) {
		this.ymdate = ymdate;
		this.salesInt = salesInt; 
	}
	public Integer getSalesInt() {
		    return salesInt;
		  }

	@Override
	public String toString() {
		return ""+ymdate;
	}

}
