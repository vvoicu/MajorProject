package bmo5.bmo5tests.tools;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

public class ReadPDF {

	public String readPDF(File pdfFile) {
		String aText = "";
		try {
			PDDocument pd = PDDocument.load(pdfFile.getAbsolutePath());
			PDFTextStripper stripper = new PDFTextStripper();

			aText = stripper.getText(pd);

			System.out.println("the text: " + aText);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return aText;
	}

}
