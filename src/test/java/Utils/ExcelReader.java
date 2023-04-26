package Utils;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {
	public static String cellValue = null;
	final static String FILE_LOCATION = "./data/AmazonTestData.xlsx";

	public static String readByColumnName(String sheetName, String columnName, int rowNum) throws Exception {
		try {

			FileInputStream fileInputStream = new FileInputStream(FILE_LOCATION);
			Workbook workbook = WorkbookFactory.create(fileInputStream);
			Sheet sheet = workbook.getSheet(sheetName);
			Row row = sheet.getRow(0);
			short lastcolumnused = row.getLastCellNum();

			int colnum = 0;
			for (int i = 0; i < lastcolumnused; i++) {
				if (row.getCell(i).getStringCellValue().equalsIgnoreCase(columnName)) {
					colnum = i;
					break;
				}
			}
			row = sheet.getRow(rowNum);
			Cell column = row.getCell(colnum);
			cellValue = column.getStringCellValue();
		} catch (Exception e) {
			System.out.println(e);
		}
		return cellValue;
	}
}
