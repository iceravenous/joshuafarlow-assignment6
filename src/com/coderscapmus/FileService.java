package com.coderscapmus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class FileService {

	public static List<TeslaSales> getSalesListFromFile (String filename) {

		List<TeslaSales> teslaSales = new ArrayList<>();
		try {
			String line = null;

			BufferedReader fileReader = new BufferedReader(new FileReader(filename));
			fileReader.readLine();
		
			while ((line = fileReader.readLine()) != null) {
				String[] lineData = line.split(",");
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM-yy");
				YearMonth ymDate = YearMonth.parse(lineData[0], dtf);
				
				TeslaSales teslaSalesMonth = new TeslaSales(ymDate, Integer.parseInt(lineData[1]));
				teslaSales.add(teslaSalesMonth);
			}

			fileReader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return teslaSales;
	
	}

}