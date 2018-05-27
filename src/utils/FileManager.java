package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

import java.io.OutputStream;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import data.Customer;
import data.IndividualCustomer;
import data.SOHOCustomer;
import data.TabCustomers;

public class FileManager {

	public void writeCustomersToFile(Customer cust) throws Exception {

		if (cust instanceof IndividualCustomer) {
			try (InputStream inp = new FileInputStream("Customers.xls")) {
				Workbook wb = WorkbookFactory.create(inp);
				Sheet sheet = wb.getSheetAt(0);
				int lastRow = sheet.getLastRowNum();
				Row row = sheet.createRow(lastRow + 1);
				IndividualCustomer Indvcust = (IndividualCustomer) cust;
				row.createCell(0).setCellValue(Indvcust.getIdCustomer());
				row.createCell(1).setCellValue(Indvcust.getFirstName());
				row.createCell(2).setCellValue(Indvcust.getLastName());
				row.createCell(3).setCellValue(Indvcust.getPesel());
				row.createCell(4).setCellValue(Indvcust.getMSISDN());

				try (OutputStream fileOut = new FileOutputStream("Customers.xls")) {
					wb.write(fileOut);
				}
			}
		} else if (cust instanceof SOHOCustomer) {
			try (InputStream inp = new FileInputStream("Customers.xls")) {
				Workbook wb = WorkbookFactory.create(inp);
				Sheet sheet = wb.getSheetAt(1);
				int lastRow = sheet.getLastRowNum();
				Row row = sheet.createRow(lastRow + 1);
				SOHOCustomer SOHOcust = (SOHOCustomer) cust;
				row.createCell(0).setCellValue(SOHOcust.getIdCustomer());
				row.createCell(1).setCellValue(SOHOcust.getName());
				row.createCell(2).setCellValue(SOHOcust.getNip());
				row.createCell(3).setCellValue(SOHOcust.getMSISDN());

				try (OutputStream fileOut = new FileOutputStream("Customers.xls")) {
					wb.write(fileOut);
				}
			}
		} else {
			System.out.println("Dupa cust");
		}

	}

	public TabCustomers readCustomersFromFile() throws Exception {
		TabCustomers tab = new TabCustomers();
		try (FileInputStream fis = new FileInputStream(new File("Customers.xls"));
				HSSFWorkbook wb = new HSSFWorkbook(fis);) {
			
			
			HSSFSheet sheetIndv = wb.getSheetAt(0);

			for (int i = 1; i <= sheetIndv.getLastRowNum(); i++) {
				sheetIndv.getRow(i).getCell(3).setCellType(Cell.CELL_TYPE_STRING);
				sheetIndv.getRow(i).getCell(4).setCellType(Cell.CELL_TYPE_STRING);
				Customer cust = new IndividualCustomer((int) sheetIndv.getRow(i).getCell(0).getNumericCellValue(),
						sheetIndv.getRow(i).getCell(1).getStringCellValue(),
						sheetIndv.getRow(i).getCell(2).getStringCellValue(),
						sheetIndv.getRow(i).getCell(3).getStringCellValue(),
						sheetIndv.getRow(i).getCell(4).getStringCellValue());
				tab.addCustomer(cust);
			}

			HSSFSheet sheetSOHO = wb.getSheetAt(0);

			for (int i = 1; i <= sheetSOHO.getLastRowNum(); i++) {
				sheetSOHO.getRow(i).getCell(2).setCellType(Cell.CELL_TYPE_STRING);
				sheetSOHO.getRow(i).getCell(3).setCellType(Cell.CELL_TYPE_STRING);
				Customer cust = new SOHOCustomer((int) sheetSOHO.getRow(i).getCell(0).getNumericCellValue(),
						sheetSOHO.getRow(i).getCell(1).getStringCellValue(),
						sheetSOHO.getRow(i).getCell(2).getStringCellValue(),
						sheetSOHO.getRow(i).getCell(3).getStringCellValue());
				tab.addCustomer(cust);
			}

			fis.close();

		}

		return tab;
	}
}
