package zavrsnirad.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelUtils {

	public static final String PATH = "C:\\Users\\Krstic\\Desktop\\Data (1).xls";
	public static final String USER_SHEET = "Registracija";
	public static final String POST_SHEET = "Tekst";

	// Reference na privatna polja koja nam sluze za skladistenje objekata excel-a
	private static HSSFSheet excelWSheet;
	private static HSSFWorkbook excelWBook;
	private static HSSFCell cell;
	private static HSSFRow row;
	private static DataFormatter formatter;

	// Metoda za postavljanje konkretnog Excel fajla i trazenog worksheeta
	public static void setExcelFile(String path, String sheetName) throws Exception {
		try {
			FileInputStream fis = new FileInputStream(path); // Ucitavanje Excel fajla na osnovu putanje
			excelWBook = new HSSFWorkbook(fis); // Otvaranje Excel fajla
			excelWSheet = excelWBook.getSheet(sheetName); // Uzimanje worksheet-a iz otvorenog Excel fajla
			formatter = new DataFormatter(); // Inicijalizacija dataformatter objekta
		} catch (Exception ex) {
			throw (ex);
		}
	}

	// Metoda za uzimanje podataka o ukupnom broju redova
	public static int getRowCount(String sheetName) {
		excelWSheet = excelWBook.getSheet(sheetName);
		int rowCount = excelWSheet.getLastRowNum() + 1;
		return rowCount;
	}

	// Metoda za uzimanje podataka o ukupnom broju kolona
	public static int getColumnCount(String sheetName, int a) {
		excelWSheet = excelWBook.getSheet(sheetName);
		row = excelWSheet.getRow(a);
		int colCount = row.getLastCellNum();
		return colCount;
	}

	// Metoda za uzimanje podataka iz tabele iz datog reda i kolone
	public static String getCellData(int rowNum, int colNum) throws Exception {
		try {
			cell = excelWSheet.getRow(rowNum).getCell(colNum); // Uzimanje celije dohvatanjem prvo reda pa kolone
			String cellData = formatter.formatCellValue(cell); // Uzimanje podataka iz celije na osnovu pretvaranja
																// vrednosti celije u String
			// String CellData = Cell.getStringCellValue();
			return cellData;
		} catch (Exception ex) {
			return "";
		}
	}

	// Metoda za postavljanje podataka u tabelu u zadatu celiju
	// na osnovu reda i kolone
	public static void setCellData(String value, int rowNum, int colNum) throws Exception {
		try {
			row = excelWSheet.getRow(rowNum); // Uzimanje reda u koji upisujemo
			cell = row.getCell(colNum, MissingCellPolicy.RETURN_BLANK_AS_NULL); // Uzimanje celije u koju zelimo da
																				// upisemo postavljanjem kolone
			// ukoliko je celija prazna ili nepostojeca
			if (cell == null) {
				cell = row.createCell(colNum); // Kreiranje celije na zadatom mestu
				cell.setCellValue(value); // Postavljanje vrednosti u celiji
			} else {
				cell.setCellValue(value); // Postavljanje vrednosti u celiji svakako, ako je vec postojala vrednost,
											// stara vrednost se gazi
			}
			// Ovaj deo koda upisuje izmene u excel fajl
			FileOutputStream fos = new FileOutputStream(PATH);
			excelWBook.write(fos);
			fos.flush();// prazni podatke unutar fajla
			fos.close(); // zatvaramo izlazni tok ka fajlu
		} catch (Exception ex) {
			throw (ex);
		}
	}

	// Metoda za vracanje reference na worksheet
	public static HSSFSheet getWSheet() {
		return excelWSheet;
	}
}
