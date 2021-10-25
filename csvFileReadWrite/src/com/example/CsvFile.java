package com.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CsvFile {

	public static String fileLocation = "F:\\OfficeWork\\javaintern\\csvFileReadWrite\\csvData.csv";

	public void writeMethod() {  //
		try {
			FileWriter writer = new FileWriter(fileLocation, true);
			BufferedWriter bufferedWriter = new BufferedWriter(writer);
			
			bufferedWriter.write("Naz, 011, 3.5");
            bufferedWriter.newLine();
            
            bufferedWriter.close();
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		

	}
   
	public void readMethod() {
		String line = "";
		String splitBy = ",";

		try {
		
			BufferedReader br = new BufferedReader(new FileReader(fileLocation));
			while ((line = br.readLine()) != null)
			{
				String[] student = line.split(splitBy);
				System.out.println("Employee [Student Name= " + student[0] + ", ID= " + student[1]
						+ ", Cgpa= " + student[2]  +"]");
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		CsvFile csvFile = new CsvFile();
		csvFile.writeMethod();
		csvFile.readMethod();

	}

}
