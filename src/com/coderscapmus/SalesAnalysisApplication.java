package com.coderscapmus;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.Optional;
import java.util.Comparator;

public class SalesAnalysisApplication {

	public static void main(String[] args) {

		List<TeslaSales> tesla3Sales = FileService.getSalesListFromFile("model3.csv");
		List<TeslaSales> teslaSSales = FileService.getSalesListFromFile("modelS.csv");
		List<TeslaSales> teslaXSales = FileService.getSalesListFromFile("modelX.csv");


		printReport(tesla3Sales, "Model 3");
		printReport(teslaSSales, "Model S");
		printReport(teslaXSales, "Model X");
	}
	
	public static void printReport(List<TeslaSales> teslaSales, String model) {
		System.out.println(model + " Yearly Sales Report");
		System.out.println("---------------------");

		printYearlySales(teslaSales);

		Optional<TeslaSales>salesMax = teslaSales.stream()
				.max(Comparator.comparingInt(TeslaSales::getSalesInt));
		
		Optional<TeslaSales>salesMin = teslaSales.stream()
				.min(Comparator.comparingInt(TeslaSales::getSalesInt));

            
		System.out.println("\nThe Best month for " + model + " was: " + salesMax.get());
		System.out.println("\nThe Worst month for " + model + " was: " + salesMin.get()+"\n");
		
	}

  	public static void printYearlySales(List<TeslaSales> teslaSales) {
		Map<Object, List<TeslaSales>> groupedByYear = teslaSales.stream().
                collect(Collectors.groupingBy((date)-> date.ymdate.getYear()));

		groupedByYear.forEach((year, sales) -> {
			int totalYearSales = sales.stream()
					.mapToInt(x -> x.getSalesInt())
					.sum();

			System.out.println(year + " -> " + totalYearSales);
		});
  	}

}
