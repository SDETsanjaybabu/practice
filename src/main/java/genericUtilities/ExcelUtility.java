package genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author SanjayBabu
 *
 */
public class ExcelUtility {
/**
 * @throws IOException 
 * @throws EncryptedDocumentException 
 * 
 */
	public String getDataFromExcel(String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fs=new FileInputStream(IPathConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fs);
		String data=wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).toString();
		wb.close();
		return data;
	}
}
