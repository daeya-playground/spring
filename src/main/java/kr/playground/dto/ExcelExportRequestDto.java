package kr.playground.dto;

import java.util.ArrayList;
import java.util.List;

public class ExcelExportRequestDto {

    private List<ExcelSheetDto> sheets = new ArrayList<ExcelSheetDto>();

    public List<ExcelSheetDto> getSheets() {
        return sheets;
    }

    public void setSheets(List<ExcelSheetDto> sheets) {
        this.sheets = sheets;
    }
}
