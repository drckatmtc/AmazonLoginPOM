package Utils;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataExcel {

	final static String FILE_LOCATION = "./data/AmazonTestData.xlsx";

	public static String ReadExcel(String sheetName, int rowNum, int colNum) {
		String data = "";

		try {
			FileInputStream fileInputStream = new FileInputStream(FILE_LOCATION);
			Workbook workbook = WorkbookFactory.create(fileInputStream);
			Sheet sheet = workbook.getSheet(sheetName);
			Row row = sheet.getRow(rowNum);
			Cell cell = row.getCell(colNum);
			data = cell.getStringCellValue();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

}
