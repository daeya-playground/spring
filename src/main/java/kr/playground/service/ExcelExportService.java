package kr.playground.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import kr.playground.dto.ExcelExportRequestDto;
import kr.playground.dto.ExcelSheetDto;
import kr.playground.exception.ApiException;

@Service("excelExportService")
public class ExcelExportService {

    public byte[] export(ExcelExportRequestDto request) {
        if (request.getSheets() == null || request.getSheets().isEmpty()) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "보낼 시트를 선택해 주세요");
        }

        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            CellStyle headerStyle = createHeaderStyle(workbook);
            CellStyle bodyStyle = createBodyStyle(workbook);

            for (ExcelSheetDto sheetDto : request.getSheets()) {
                String sheetName = sanitizeSheetName(sheetDto.getName());
                Sheet sheet = workbook.createSheet(sheetName);

                List<String> headers = sheetDto.getHeaders();
                if (headers == null || headers.isEmpty()) {
                    throw new ApiException(HttpStatus.BAD_REQUEST, "시트 헤더가 비어 있습니다: " + sheetName);
                }

                Row headerRow = sheet.createRow(0);
                for (int col = 0; col < headers.size(); col++) {
                    Cell cell = headerRow.createCell(col);
                    cell.setCellValue(headers.get(col));
                    cell.setCellStyle(headerStyle);
                }

                List<List<String>> rows = sheetDto.getRows();
                if (rows != null) {
                    for (int rowIdx = 0; rowIdx < rows.size(); rowIdx++) {
                        Row row = sheet.createRow(rowIdx + 1);
                        List<String> values = rows.get(rowIdx);
                        for (int col = 0; col < headers.size(); col++) {
                            Cell cell = row.createCell(col);
                            String value = values != null && col < values.size() ? values.get(col) : "";
                            cell.setCellValue(value == null ? "" : value);
                            cell.setCellStyle(bodyStyle);
                        }
                    }
                }

                for (int col = 0; col < headers.size(); col++) {
                    sheet.autoSizeColumn(col);
                    int width = sheet.getColumnWidth(col);
                    sheet.setColumnWidth(col, Math.min(width + 512, 256 * 40));
                }
            }

            workbook.write(out);
            return out.toByteArray();
        } catch (IOException e) {
            throw new ApiException(HttpStatus.INTERNAL_SERVER_ERROR, "엑셀 생성에 실패했습니다");
        }
    }

    private CellStyle createHeaderStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        font.setColor(IndexedColors.WHITE.getIndex());
        style.setFont(font);
        style.setFillForegroundColor(IndexedColors.DARK_BLUE.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        return style;
    }

    private CellStyle createBodyStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        return style;
    }

    private String sanitizeSheetName(String name) {
        String value = name == null || name.trim().isEmpty() ? "Sheet" : name.trim();
        value = value.replaceAll("[\\\\/*?:\\[\\]]", "_");
        if (value.length() > 31) {
            value = value.substring(0, 31);
        }
        return value;
    }
}
