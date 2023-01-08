package com.cgm.crud.common;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.cgm.crud.bl.dto.EmployeeDto;

public class ExcelView extends AbstractXlsxView {

	public static final String[] header = { "ID", "Name", "Department", "Email", "Salary" };

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		List<EmployeeDto> empList = (List<EmployeeDto>) model.get("empList");
		int rowNum = 1;
		Sheet sheet = workbook.createSheet("EmployeeLists");
		// for header
		Font font = workbook.createFont();
		font.setFontName("HELVETICA");
		font.setColor(IndexedColors.WHITE.getIndex());
		font.setBold(true);
		CellStyle style = workbook.createCellStyle();
		style.setFont(font);
		style.setWrapText(true);
		style.setFillForegroundColor(IndexedColors.CORNFLOWER_BLUE.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		Row row = sheet.createRow(0);
		for (int i = 0; i < header.length; i++) {
			sheet.setColumnWidth(i, 30 * 256);
			Cell cell = row.createCell(i);
			cell.setCellValue(header[i]);
			cell.setCellStyle(style);
		}
		// for rows in the sheet

		for (EmployeeDto emp : empList) {
			row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(emp.getId());
			row.createCell(1).setCellValue(emp.getName());
			row.createCell(2).setCellValue(emp.getDepartment());
			row.createCell(3).setCellValue(emp.getEmail());
			row.createCell(4).setCellValue(emp.getSalary());
		}
	}
}
