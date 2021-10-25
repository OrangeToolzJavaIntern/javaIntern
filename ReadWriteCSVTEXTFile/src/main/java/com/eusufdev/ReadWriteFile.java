package com.eusufdev;

import java.io.*;
import java.util.*;
import com.opencsv.*;
import com.opencsv.exceptions.CsvValidationException;

public class ReadWriteFile {

	public static void main(String[] args) throws IOException, CsvValidationException {

		Scanner scannerin = new Scanner(System.in);
		System.out.println("Read And Write With TXT File Press 1|Read And Write With CSV File Press 2");
		System.out.print("You Entered: ");
		int input = scannerin.nextInt();

		if (input == 1) {

			CreateWriteTextFile();

			ReadTextFile();

		} else if (input == 2) {

			CreatewriteCSVfile();
			ReadCSVfile();

		} else {
			System.out.println("Please Run again and give valid Input");
		}

	}

	private static void ReadTextFile() throws FileNotFoundException {

		Scanner readscanner = new Scanner(new File("testdata//sampletext.txt"));

		System.out.print("\nStart Reading TXT File...\n\n");
		while (readscanner.hasNext()) {

			System.out.println(readscanner.nextLine());
		}
		readscanner.close();

		System.out.println("\n\nText File Read Completed");

	}

	private static void CreateWriteTextFile() throws IOException {

		File file = new File("testdata//sampletext.txt");

		if (!file.exists()) {
			file.createNewFile();
		}

		Scanner scanner = new Scanner(System.in);
		System.out.print("Please Entered Anything to Write in Text file: ");
		String userinputtxt = scanner.nextLine();

		PrintWriter pw = new PrintWriter(file);
		
		pw.println(userinputtxt);
		pw.close();

	}

	private static void ReadCSVfile() throws CsvValidationException {
		try {

			System.out.println("\n\nCSV File Read Staring\n");

			CSVReader reader = new CSVReader(new FileReader("testdata//sample2.csv"));
			String[] nextlineStrings;
			while ((nextlineStrings = reader.readNext()) != null) {

				if (nextlineStrings != null) {

					System.out.println(Arrays.toString(nextlineStrings));
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println("\n\nCSV File Read Completed");

	}

	private static void CreatewriteCSVfile() throws IOException {

		// Intiating the CSV Writer Class
		CSVWriter write = new CSVWriter(new FileWriter("testdata//sample2.csv"));

		Scanner in = new Scanner(System.in);

		System.out.print("Which Length of Array do you want: ");
		int number = in.nextInt();
		String[] array = new String[number];

		// Initiating String type Array List
		List<String[]> list = new ArrayList<String[]>();

		for (int i = 0; i < array.length; i++) {
			array[i] = in.next();
		}

		list.add(array);

		write.writeAll(list);

		// flush data to CSV file
		write.flush();

		System.out.println("Data Entered Successfully");

	}

}
