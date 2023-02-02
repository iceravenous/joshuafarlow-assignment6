package com.coderscapmus;


import java.time.YearMonth;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.HashMap;

import com.coderscapmus.FileService;
import com.coderscapmus.Tesla;

public class SalesAnalysis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Read in data from Tesla sales Model 3
		 * 		add total sales for 17- into Model32017
		 * 		add total sales for 18- into Model32018
		 * 		add total sales for 19- intol Model32018
		 * 		variable - bestMonthModel3
		 * 		variable - worstMonthModel3
		 * 
		 * Read in data from Tesal sales Model X
		 * 		Use similar variables for model 3
		 * Read in data from Tesla sales Model S
		 * 		use similar variables for model 3
		 * 
		 * Output for each:
		 * Model {#####> Yearly Sales Reports
		 * --------------------------8
		 * 2016 -> ####
		 * 2017 -> ####
		 * 2018 -> ####
		 * 2019 -> ####
		 * 
		 * The best month for Model #### was: yyyy-MM
		 * THe worst month for Model #### was: yyyy-MM
		 */
		
		//Tesla[] tesla3Sales = FileService.getSalesListFromFile("model3.csv");
		List<Tesla> tesla3Sales = new ArrayList<>();
		FileService.getSalesListFromFile(tesla3Sales, "model3.csv");
//		tesla3Sales.add(new Tesla("Jul-17", 30));
//		tesla3Sales.add(new Tesla("Dec-17", 1060));
//		tesla3Sales.add(new Tesla("Feb-18", 2485));
//		System.out.println(tesla3Sales);
//		for(Tesla month:tesla3Sales) {
//			System.out.println(month);
//		}
		Tesla teslaTest = new Tesla("Jan-23", "2300");
		teslaTest.yDate = YearMonth.parse("Feb-23", teslaTest.dateTimeFormatter);
		System.out.println(teslaTest.yDate);
		printReport(tesla3Sales);
	}
	
	public static void printReport(List<Tesla> tesla3Sales) {
		System.out.println("Model 3 Yearly Sales Report");
		System.out.println(tesla3Sales);
		System.out.println("---------------------");
		
		List<String> dates = tesla3Sales.stream()
								.map(date -> date.getDate())
								.filter(x -> x.endsWith("17"))
								.collect(Collectors.toList());
		//System.out.println(dates);
		
		List<Integer> sales = tesla3Sales.stream()
					
					.map(sale -> sale.getSales())
					.map(Integer::valueOf)
					.collect(Collectors.toList());
		
		Map<String, List<Tesla>> groupedByYear = tesla3Sales.stream()
	//			.filter(map -> map.endsWith("17"))
				.collect(Collectors.groupingBy((year) -> year.getDate()));
				
		Set<Entry<String, List<Tesla>>> entrySet = groupedByYear.entrySet();
		
		entrySet.stream()
			.forEach((entry) -> {
				System.out.println(entry.getKey() + " -> " + entry.getValue());
			});
		// System.out.println(sales);
		
		int sum17 = 0;
		
		
		
		/*
		 * open stream -> collect just the 2017 year, focus on price and get sum (then same for remaining years)
		 * open stream - > collect best month
		 * open stream - > collect worst month
		 */
		System.out.println("2017 -> " + sum17);
		System.out.println("2018 -> Number2");
		System.out.println("2019 -> Number3\n");
		System.out.println("The Best month for Model 3 was: yyyy-MM");
		System.out.println("The Worst month for Model 3 was: yyyy-MM");
		
	}

}
