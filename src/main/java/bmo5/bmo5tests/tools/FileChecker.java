package bmo5.bmo5tests.tools;

import java.io.File;
import org.junit.Assert;

public class FileChecker {
	
	public void verifyFileIsDownloaded1(String fileName){
		boolean isPresent = false;
		String newFileName1 = fileName.replaceAll("&", "and");
		String newFileName2 = fileName.replaceAll("&", "");
		newFileName1 = newFileName1.replaceAll("[^a-zA-Z0-9]", "");
		newFileName1 = newFileName1.toLowerCase();
		System.out.println(fileName);
		System.out.println(newFileName1);
		newFileName2 = newFileName2.replaceAll("[^a-zA-Z0-9]", "");
		newFileName2 = newFileName2.toLowerCase();
		System.out.println(fileName);
		System.out.println(newFileName2);
		File rootFolder = new File(Constants.DOWNLOAD_FOLDER_PATH);
		File[] listOfFiles = rootFolder.listFiles(); 
	
		theFor:
		for(File fileNow:listOfFiles){
			String f = fileNow.getName().replaceAll("[^a-zA-Z0-9]", "");
			f = f.replaceAll("pdf", "");
			f = f.toLowerCase();
			System.out.println(f);
			System.out.println(fileNow.getName());
			System.out.println(fileNow.getAbsolutePath());
			System.out.println(fileNow.length());
			if(f.contains(newFileName1)&& (fileNow.length() > 0) && (fileNow.getName().endsWith(".pdf")) || f.contains(newFileName2)&& (fileNow.length() > 0) && (fileNow.getName().endsWith(".pdf")) ){
				ReadPDF reader = new ReadPDF();
				reader.readPDF(fileNow);
				fileNow.delete();
				isPresent=true;
				break theFor;
			}
		}
		Assert.assertTrue("File has not been found in the list.... ", isPresent);
	}
	
		public void verifyViewFullReport(){
			boolean isPresent = false;
			File rootFolder = new File(Constants.DOWNLOAD_FOLDER_PATH);
			File[] listOfFiles = rootFolder.listFiles(); 
		
			theFor:
			for(File fileNow:listOfFiles){
				String f = fileNow.getName().replaceAll("[^a-zA-Z0-9]", "");
				f = f.replaceAll("pdf", "");
				System.out.println(f);
				System.out.println("File now name : " + fileNow.getName());
				System.out.println(fileNow.getAbsolutePath());
				System.out.println(fileNow.length());
				if((fileNow.length() > 0) && (fileNow.getName().endsWith(".pdf")) ){
					ReadPDF reader = new ReadPDF();
					reader.readPDF(fileNow);
					fileNow.delete();
					isPresent=true;
					break theFor;
				}
			}
			Assert.assertTrue("File has not been found in the list.... ", isPresent);
		}
	
	public void verifyFileIsDownloaded2(String fileName){
		boolean isPresent = false;
		String newFileName = fileName.replaceAll("[^a-zA-Z0-9]", "");
		System.out.println(fileName);
		System.out.println(newFileName);
		File rootFolder = new File(Constants.DOWNLOAD_FOLDER_PATH);
		File[] listOfFiles = rootFolder.listFiles(); 
	
		theFor:
		for(File fileNow:listOfFiles){
			String f = fileNow.getName().replaceAll("[^a-zA-Z0-9]", "");
			System.out.println(f);
			System.out.println("File now name : " + fileNow.getName());
			System.out.println(fileNow.getAbsolutePath());
			System.out.println(fileNow.length());
			if(newFileName.contains(f.substring(0, 10))&& (fileNow.length() > 0) && (fileNow.getName().endsWith(".pdf")) ){
				ReadPDF reader = new ReadPDF();
				reader.readPDF(fileNow);
				fileNow.delete();
				isPresent=true;
				break theFor;
			}
		}
		Assert.assertTrue("File has not been found in the list.... ", isPresent);
	}
	
	public void verifyFileIsDownloadedRelatives(String fileName){
		boolean isPresent = false;
		String[] newFileName;
		newFileName= fileName.split("[-]");
		System.out.println(newFileName);
		newFileName[1] = newFileName[1].replaceAll("[^a-zA-Z0-9]", "");
		System.out.println(fileName);
		System.out.println(newFileName);
		File rootFolder = new File(Constants.DOWNLOAD_FOLDER_PATH);
		File[] listOfFiles = rootFolder.listFiles(); 
	
		theFor:
		for(File fileNow:listOfFiles){
			String f = fileNow.getName().replaceAll("[^a-zA-Z0-9]", "");
			f = f.replaceAll("pdf", "");
			System.out.println(f);
			System.out.println("File now name : " + fileNow.getName());
			System.out.println(fileNow.getAbsolutePath());
			System.out.println(fileNow.length());
			if(f.contains(newFileName[1])&& (fileNow.length() > 0) && (fileNow.getName().endsWith(".pdf")) ){
				ReadPDF reader = new ReadPDF();
				reader.readPDF(fileNow);
				fileNow.delete();
				isPresent=true;
				break theFor;
			}
		}
		Assert.assertTrue("File has not been found in the list.... ", isPresent);
	}
	
	public void verifyFileIsDownloadedRelativesArchives(String fileName){
		boolean isPresent = false;
		String[] newFileName;
		newFileName= fileName.split("[-]");
		String newFileName1 = newFileName[0].replaceAll("&", "and");
		String newFileName2 = newFileName[0].replaceAll("&", "");
		newFileName1 = newFileName1.replaceAll("[^a-zA-Z]", "");
		newFileName1 = newFileName1.toLowerCase();
		System.out.println(fileName);
		System.out.println(newFileName1);
		newFileName2 = newFileName2.replaceAll("[^a-zA-Z]", "");
		newFileName2 = newFileName2.toLowerCase();
		System.out.println(newFileName2);
		System.out.println(fileName);
		System.out.println(newFileName);
		File rootFolder = new File(Constants.DOWNLOAD_FOLDER_PATH);
		File[] listOfFiles = rootFolder.listFiles(); 
	
		theFor:
		for(File fileNow:listOfFiles){
			String f = fileNow.getName().replaceAll("[^a-zA-Z]", "");
			f = f.toLowerCase();
			System.out.println(f);
			System.out.println("File now name : " + fileNow.getName());
			System.out.println(fileNow.getAbsolutePath());
			System.out.println(fileNow.length());
			if((f.contains(newFileName1)&& (fileNow.length() > 0) && (fileNow.getName().endsWith(".pdf"))) || (f.contains(newFileName2)&& (fileNow.length() > 0) && (fileNow.getName().endsWith(".pdf")))){
				ReadPDF reader = new ReadPDF();
				reader.readPDF(fileNow);
				fileNow.delete();
				isPresent=true;
				break theFor;
			}
		}
		Assert.assertTrue("File has not been found in the list.... ", isPresent);
	}
	
	/*public void verifyFileIsDownloadedSavedArticles(){
		boolean isPresent = false;
		File rootFolder = new File(Constants.DOWNLOAD_FOLDER_PATH);
		File[] listOfFiles = rootFolder.listFiles(); 
		theFor:
		for(File fileNow:listOfFiles){
			String f = fileNow.getName().replaceAll("[^a-zA-Z0-9]", "");
			System.out.println(f);
			System.out.println("File now name : " + fileNow.getName());
			System.out.println(fileNow.getAbsolutePath());
			System.out.println(fileNow.length());
			if(f.contains("articles")&& (fileNow.length() > 0) && (fileNow.getName().endsWith(".pdf")) ){
				ReadPDF reader = new ReadPDF();
				reader.readPDF(fileNow);
				fileNow.delete();
				isPresent=true;
				break theFor;
			}
		}
		Assert.assertTrue("File has not been found in the list.... ", isPresent);
	}*/
	
	public String convertFileName(String fileName){
		return fileName.replace(" ", "_");
	}
	
	public void verifyExtentionExcelFile(String extension){
		boolean isPresent = false;
		File rootFolder = new File(Constants.DOWNLOAD_FOLDER_PATH);
		File[] listOfFiles = rootFolder.listFiles(); 
	
		theFor:
		for(File fileNow:listOfFiles){
			String f = fileNow.getName().replaceAll("[^a-zA-Z0-9]", "");
			System.out.println(f);
			System.out.println("File now name : " + fileNow.getName());
			System.out.println(fileNow.getAbsolutePath());
			System.out.println(fileNow.length());
			if(f.contains("BMIComparativeData") && (fileNow.getName().endsWith(extension)) ){
				fileNow.delete();
				isPresent=true;
				break theFor;
			}
		}
		Assert.assertTrue("File has not been found in the list.... ", isPresent);
	}
	
	public void verifyExtentionExcelFileForGeneralDvPack(String extension){
		boolean isPresent = false;
		File rootFolder = new File(Constants.DOWNLOAD_FOLDER_PATH);
		File[] listOfFiles = rootFolder.listFiles(); 
	
		theFor:
		for(File fileNow:listOfFiles){
			String f = fileNow.getName().replaceAll("[^a-zA-Z0-9]", "");
			System.out.println(f);
			System.out.println("File now name : " + fileNow.getName());
			System.out.println(fileNow.getAbsolutePath());
			System.out.println(fileNow.length());
			if(fileNow.getName().endsWith(extension)){
				fileNow.delete();
				isPresent=true;
				break theFor;
			}
		}
		Assert.assertTrue("File has not been found in the list.... ", isPresent);
	}
	
	public void verifyExtentionExcelFileMnc(String extension){
		boolean isPresent = false;
		File rootFolder = new File(Constants.DOWNLOAD_FOLDER_PATH);
		File[] listOfFiles = rootFolder.listFiles(); 
	
		theFor:
		for(File fileNow:listOfFiles){
			String f = fileNow.getName().replaceAll("[^a-zA-Z0-9]", "");
			System.out.println(f);
			System.out.println("File now name : " + fileNow.getName());
			System.out.println(fileNow.getAbsolutePath());
			System.out.println(fileNow.length());
			if(f.contains("bmicompanydata") && (fileNow.getName().endsWith(extension)) ){
				fileNow.delete();
				isPresent=true;
				break theFor;
			}
		}
		Assert.assertTrue("File has not been found in the list.... ", isPresent);
	}
	
	public void verifyExtentionExcelFileFromDataToolTrialUser(String extension){
		boolean isPresent = false;
		File rootFolder = new File(Constants.DOWNLOAD_FOLDER_PATH);
		File[] listOfFiles = rootFolder.listFiles(); 
	
		theFor:
		for(File fileNow:listOfFiles){
			String f = fileNow.getName().replaceAll("[^a-zA-Z0-9]", "");
			System.out.println(f);
			System.out.println("File now name : " + fileNow.getName());
			System.out.println(fileNow.getAbsolutePath());
			System.out.println(fileNow.length());
			if(f.contains("risk") || f.contains("BMIDataExport") || f.contains("BMIComparativeData") && (fileNow.getName().endsWith(extension)) ){
				fileNow.delete();
				isPresent=true;
				break theFor;
			}
		}
		Assert.assertTrue("File has not been found in the list.... ", isPresent);
	}
	
	public void verifyExtentionJpgOrPngFile(String extension){
		boolean isPresent = false;
		File rootFolder = new File(Constants.DOWNLOAD_FOLDER_PATH);
		File[] listOfFiles = rootFolder.listFiles(); 
	
		theFor:
		for(File fileNow:listOfFiles){
			String f = fileNow.getName().replaceAll("[^a-zA-Z0-9]", "");
			System.out.println(f);
			System.out.println("File now name : " + fileNow.getName());
			System.out.println(fileNow.getAbsolutePath());
			System.out.println(fileNow.length());
			if(f.contains("chartcolor") && (fileNow.getName().endsWith(extension)) ){
				fileNow.delete();
				isPresent=true;
				break theFor;
			}
		}
		Assert.assertTrue("File has not been found in the list.... ", isPresent);
	}
	
	public void verifyFilesAreDownloaded(){
		boolean isPresent = false;
		File rootFolder = new File(Constants.DOWNLOAD_FOLDER_PATH);
		File[] listOfFiles = rootFolder.listFiles(); 
	
		theFor:
		for(File fileNow:listOfFiles){
			String f = fileNow.getName().replaceAll("[^a-zA-Z0-9]", "");
			System.out.println(f);
			System.out.println("File now name : " + fileNow.getName());
			System.out.println(fileNow.getAbsolutePath());
			System.out.println(fileNow.length());
			if(f.contains("articlespdf") && (fileNow.getName().endsWith(".pdf")) ){
				fileNow.delete();
				isPresent=true;
				break theFor;
			}
		}
		Assert.assertTrue("File has not been found in the list.... ", isPresent);
	}
	
	public void verifyReportsAreDownloaded(){
		boolean isPresent = false;
		File rootFolder = new File(Constants.DOWNLOAD_FOLDER_PATH);
		File[] listOfFiles = rootFolder.listFiles(); 
	
		theFor:
		for(File fileNow:listOfFiles){
			String f = fileNow.getName().replaceAll("[^a-zA-Z0-9]", "");
			System.out.println(f);
			System.out.println("File now name : " + fileNow.getName());
			System.out.println(fileNow.getAbsolutePath());
			System.out.println(fileNow.length());
			if(f.contains("pdfreports") && (fileNow.getName().endsWith(".zip")) ){
				fileNow.delete();
				isPresent=true;
				break theFor;
			}
		}
		Assert.assertTrue("File has not been found in the list.... ", isPresent);
	}
	
	public void genericVerifyFileIsDownloaded(String fileName){
		boolean isPresent = false;
		File rootFolder = new File(Constants.DOWNLOAD_FOLDER_PATH);
		File[] listOfFiles = rootFolder.listFiles(); 
	
		theFor:
		for(File fileNow:listOfFiles){
			String f = fileNow.getName();
			if(f.equals(fileName)){
//				fileNow.delete();
				System.out.println("File '"+fileName+"' was found on disk");
				isPresent=true;
				break theFor;
			}
		}
		Assert.assertTrue("File has not been found in the list.... ", isPresent);
	}
	
	public void verifyServiceCompanyExcelForSelectedService(){
		boolean isPresent = false;
		File rootFolder = new File(Constants.DOWNLOAD_FOLDER_PATH);
		File[] listOfFiles = rootFolder.listFiles(); 
	
		theFor:
		for(File fileNow:listOfFiles){
			String f = fileNow.getName().replaceAll("[^a-zA-Z0-9]", "");
			if(f.contains("ServiceCompanies") && (fileNow.getName().endsWith(".xls")) ){
//				String excelPath = "C:\\Users\\"+System.getProperty("user.name")+"\\Downloads\\" + "ServiceCompanies.xls";
//				System.out.println(excelPath);
//				FileInputStream fileInputStream;
//				try {
//					fileInputStream = new FileInputStream(excelPath);
//			
//				XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
//				XSSFSheet worksheet = workbook.getSheet("Sheet1");
//				
//				Iterator<Row> rowIterator = worksheet.iterator();
//				while (rowIterator.hasNext()) {
//					Row row = rowIterator.next();
//					XSSFRow row2 = worksheet.getRow(1);	
//					if (row.getRowNum() > 8) {
//						XSSFCell cell = row2.getCell((short) 1);
//						if(cell.getStringCellValue().contains(companyName)){
//							companyPresent = true;
//							XSSFCell cellState = row2.getCell((short) 2);
//							Assert.assertTrue(cellState.getStringCellValue().contains(state));
//							XSSFCell cellNationality = row2.getCell((short) 3);
//							Assert.assertTrue(cellNationality.getStringCellValue().contains(nationality));
//						}
//					}
//				}
//				fileInputStream.close();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				fileNow.delete();
				isPresent=true;
				break theFor;
			}
		}
		Assert.assertTrue("File has not been found in the list.... ", isPresent);
//		Assert.assertTrue(companyPresent);
	}
}
