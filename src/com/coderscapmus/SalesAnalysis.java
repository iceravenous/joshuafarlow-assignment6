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

		printReport(tesla3Sales, "Model 3");
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

              
		System.out.println("The Best month for Model 3 was: " + salesMax);
		System.out.println("The Worst month for Model 3 was: " + salesMin);
		
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
