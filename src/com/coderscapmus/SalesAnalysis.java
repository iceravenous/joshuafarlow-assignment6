package com.coderscapmus;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Comparator;

public class SalesAnalysis {

	public static void main(String[] args) {
		
		
		List<Tesla> tesla3Sales = new ArrayList<>();
		FileService.getSalesListFromFile(tesla3Sales, "model3.csv");

		List<Tesla> teslaSSales = new ArrayList<>();
		FileService.getSalesListFromFile(teslaSSales, "modelS.csv");
		
		List<Tesla> teslaXSales = new ArrayList<>();
		FileService.getSalesListFromFile(teslaXSales, "modelX.csv");
		
		
		
		

		printReport(tesla3Sales, "Model 3");
		printReport2(teslaSSales, "Model S");
		printReport2(teslaXSales, "Model X");
	}
	
	public static void printReport(List<Tesla> tesla3Sales, String model) {
		System.out.println(model + " Yearly Sales Report");
		System.out.println("---------------------");

    long sum17 = SumYear(tesla3Sales, 2017);
    long sum18 = SumYear(tesla3Sales, 2018);
    long sum19 = SumYear(tesla3Sales, 2019);
	
		System.out.println("2017 -> " + sum17);
		System.out.println("2018 -> " + sum18);
		System.out.println("2019 -> " + sum19);

		Optional<Tesla>salesMax = tesla3Sales.stream()
				.max(Comparator.comparingInt(Tesla::getSalesInt));
		
		Optional<Tesla>salesMin = tesla3Sales.stream()
				.min(Comparator.comparingInt(Tesla::getSalesInt));


//		YearMonth maxSales = tesla3Sales.stream()
//				.max(Comparator.comparingInt(Tesla::getSalesInt));

              
		System.out.println("\nThe Best month for " + model + " was: " + salesMax.get());
		System.out.println("\nThe Worst month for " + model + " was: " + salesMin.get()+"\n");
		
	}
	
	public static void printReport2(List<Tesla> tesla3Sales, String model) {
		System.out.println(model + " Yearly Sales Report");
		System.out.println("---------------------");
		
		long sum16 = SumYear(tesla3Sales, 2016);
		long sum17 = SumYear(tesla3Sales, 2017);
		long sum18 = SumYear(tesla3Sales, 2018);
		long sum19 = SumYear(tesla3Sales, 2019);
	
		System.out.println("2016 -> " + sum16);
		System.out.println("2017 -> " + sum17);
		System.out.println("2018 -> " + sum18);
		System.out.println("2019 -> " + sum19);

		Optional<Tesla>salesMax = tesla3Sales.stream()
				.max(Comparator.comparingInt(Tesla::getSalesInt));
		
		Optional<Tesla>salesMin = tesla3Sales.stream()
				.min(Comparator.comparingInt(Tesla::getSalesInt));

            
		System.out.println("\nThe Best month for " + model + " was: " + salesMax.get());
		System.out.println("\nThe Worst month for " + model + " was: " + salesMin.get()+"\n");
		
	}

  public static long SumYear(List<Tesla> tesla3Sales, int mYear){
		Map<Object, List<Tesla>> groupedByYear = tesla3Sales.stream().
                filter(e -> e.ymdate.getYear()==mYear).
                collect(Collectors.groupingBy((date)-> date.ymdate.getYear()));
    Set<Entry<Object, List<Tesla>>> entrySet = groupedByYear.entrySet();
    long sum17 = entrySet.stream()
                  .flatMap(x -> x.getValue().stream())
                  .mapToInt(x -> x.getSalesInt())
                  .sum();

    return sum17;
  }	

}
