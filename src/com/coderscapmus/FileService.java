package com.coderscapmus;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

//import com.coderscampus.assignment6.Tesla;

import java.time.format.DateTimeFormatter;
import java.time.YearMonth;


public class FileService {

	public static void getSalesListFromFile (List<Tesla> teslaSales, String filename) {
		BufferedReader fileReader = null;
	
		try {
			String line = null;
		
			fileReader = new BufferedReader(new FileReader(filename));
			fileReader.readLine();
		
			while ((line = fileReader.readLine()) != null) {
				String[] lineData = line.split(",");
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM-yy");
				YearMonth ymDate = YearMonth.parse(lineData[0], dtf);
				
				Tesla teslaMonth = new Tesla(ymDate, Integer.parseInt(lineData[1]));
				teslaSales.add(teslaMonth);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fileReader != null) {
					fileReader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
}

public static Integer readLength(String filename) {
	
	BufferedReader fileReader = null;
	Integer length = 0;
	try {
		
		fileReader = new BufferedReader(new FileReader(filename));
		while (fileReader.readLine()!= null) length++;
	
	} catch (IOException e) {
		e.printStackTrace();
	}
	return length;
}


}