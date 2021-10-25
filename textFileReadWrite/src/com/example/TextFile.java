package com.example;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextFile {

	public void writeMethod() {
		try {
            FileWriter writer = new FileWriter("MyFile.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
 
            bufferedWriter.write("Hello World");
            bufferedWriter.newLine();
            bufferedWriter.write("See You Again!");
            bufferedWriter.newLine();
            
 
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public void readMethod() {
		try {
			String fileLocation = "C:\\Users\\ASUS\\eclipse-workspace-update\\textFileReadWrite\\Myfile.txt";
            FileReader reader = new FileReader(fileLocation);
            BufferedReader bufferedReader = new BufferedReader(reader);
 
            String line;
 
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public static void main(String[] args) {
		TextFile textFile = new TextFile();
		textFile.writeMethod();
		textFile.readMethod();

	}

}
