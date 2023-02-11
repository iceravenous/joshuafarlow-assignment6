package com.coderscapmus;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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

		printReport(tesla3Sales, "Model 3");
	}
	
	public static void printReport(List<Tesla> tesla3Sales, String model) {
		System.out.println(model + " Yearly Sales Report");
		System.out.println(tesla3Sales);
		System.out.println("---------------------");
		
		List<String> dates = tesla3Sales.stream()
								.map(date -> date.getDate())
								//.filter(x -> x.endsWith("17"))
								.collect(Collectors.toList());
//		List<String> numbers = dates.stream()
//				.flatMap(x->x.getSales().stream())
//				.collect(Collectors.toList());
		
//		long sum = dates.stream()
//				.flatMap(x -> x.stream())
//				.mapToInt(x -> x.getSales())
//				.sum();
		System.out.println("Just print dates\n==================\n");
		System.out.println(dates);
		System.out.println("===================");
		
		List<Integer> sales = tesla3Sales.stream()
					
					.map(sale -> sale.getSales())
					.map(Integer::valueOf)
					.collect(Collectors.toList());
		
		Map<String, List<Tesla>> groupedByYear = tesla3Sales.stream()
				
				.collect(Collectors.groupingBy((year) -> year.getDate()));
				
		Set<Entry<String, List<Tesla>>> entrySet = groupedByYear.entrySet();

		for(Entry<String, String> e: map.entrySet()) {
			
		}
		
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
//		System.out.println("2017 -> " + sum17);
//		System.out.println("2018 -> Number2");
//		System.out.println("2019 -> Number3\n");
//		System.out.println("The Best month for Model 3 was: yyyy-MM");
//		System.out.println("The Worst month for Model 3 was: yyyy-MM");
//		
	}

}
