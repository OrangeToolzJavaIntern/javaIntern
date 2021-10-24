package com.example.test;

import java.io.*;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfFile {

	public static void main(String[] args) throws IOException{
		
		
	   createandWritefile();
		
	   readFile();
		

	}
	
	private static void readFile() throws IOException{
		
		File file = new File("H:\\mypdf.pdf");
		
		FileInputStream filein = new FileInputStream(file);
		
		 PDDocument doc = PDDocument.load(filein);
		
	    PDFTextStripper pdf = new PDFTextStripper();
	    String text =pdf.getText(doc);
	    System.out.println(text);
	    
//	       String[] a= text.split("this is Self PDf");
//	       System.out.println(a[1]);
	    
	    boolean check =  text.contains("Self");
	   if(check== true) {
		   System.out.println("String has in PDF");
	   }else {
		   System.out.println("String has not in PDF");
	     }
	   
		
	}

	private static void createandWritefile() throws IOException{
        try {
            Document document = new Document();
            
            PdfWriter writer  = PdfWriter.getInstance(document, new FileOutputStream("H:\\mypdf.pdf"));
            document.open();
            
            Font f = new Font();
            f.setStyle(Font.ITALIC);
            f.setSize(8);
            
            document.add(new Paragraph("this is Self PDf", f));
            document.add(new Paragraph("Hello PDF", f));
            document.close();
           
            writer.close();
          
          
        } catch (DocumentException ex) {
            ex.printStackTrace();
        }
        
        
    }

}
