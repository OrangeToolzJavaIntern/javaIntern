package com.example;

import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.text.PDFTextStripper;

public class Main {

	public static String location = "C:\\Users\\ASUS\\eclipse-workspace-update\\pdfReadWrite\\src\\main\\java\\com\\example\\hello.pdf";
	
	public void readMethod() throws IOException {
		try {
			File file = new File(location);
			PDDocument document = PDDocument.load(file);
			PDFTextStripper pdfStripper = new PDFTextStripper();
		
			String text = pdfStripper.getText(document);
			System.out.println(text);
		     
			document.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}

	public void writeMethod() throws IOException{
		PDDocument document = PDDocument.load(new File(location));
		PDPage page = document.getPage(0);
		PDPageContentStream contentStream = new PDPageContentStream(document, page,
				PDPageContentStream.AppendMode.APPEND, true, true);
		contentStream.beginText();

		contentStream.setFont(PDType1Font.TIMES_BOLD, 12);

		contentStream.newLineAtOffset(100, 700);

		String text = "Test writtern in the pdf file.";
		contentStream.showText(text);
		contentStream.endText();
		contentStream.close();
		document.save(new File(location));
		document.close();

	}

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		main.writeMethod();
		main.readMethod();

	}
}