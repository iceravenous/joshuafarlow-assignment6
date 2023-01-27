package com.coderscapmus;

import java.io.BufferedReader;
//import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
//import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class FileService {

//public static Tesla[] getSalesListFromFile (String filename) {
	//public static List<Tesla> getSalesListFromFile (String filename) {
	public static void getSalesListFromFile (List<Tesla> teslaSales, String filename) {
	BufferedReader fileReader = null;
	
	try {
		//Integer fileLength = readLength(filename);
		//int i=0;
		String line = null;
		//Tesla teslaMonth = new Tesla;
		//List<Tesla> teslaSales = new ArrayList<>();
		fileReader = new BufferedReader(new FileReader(filename));
		
		while ((line = fileReader.readLine()) != null) {
			String[] lineData = line.split(",");
			Tesla teslaMonth = new Tesla(lineData[0], lineData[1]);
			//teslaMonth[0] = lineData[0];  = new Tesla(lineData[0],lineData[1]);
			//System.out.println("Month: " + lineData[0] + " Sales: " + lineData[1]);
			teslaSales.add(teslaMonth);
			/////////teslaSales.add(new Tesla(lineData[0], lineData[1]));
//			teslaSales[i] = teslaSale;
//			i++;
			//System.out.println("Here" + teslaSales);
		}
		//return teslaSales;
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
	//return null;
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

//public static void readFile(Tesla[] teslaSales, String fileName) throws IOException {
//	BufferedWriter writer = null;
//	
//	try {
//		writer = new BufferedWriter(new FileWriter(fileName));
//		writer.write("Month, Salese\n");
//		for(Tesla tesla:teslaSales) {
//			writer.write(tesla.getDate() + "," + tesla.getSales()  + "\n" );
//		}
//	} finally {
//		if(writer != null) writer.close(); 
//	}
//	
//	
//	
//	
//	
//	writer.close();
//}
}