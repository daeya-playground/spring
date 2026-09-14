package kr.playground.dto;

import java.util.ArrayList;
import java.util.List;

public class ExcelSheetDto {

    private String name;
    private List<String> headers = new ArrayList<String>();
    private List<List<String>> rows = new ArrayList<List<String>>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getHeaders() {
        return headers;
    }

    public void setHeaders(List<String> headers) {
        this.headers = headers;
    }

    public List<List<String>> getRows() {
        return rows;
    }

    public void setRows(List<List<String>> rows) {
        this.rows = rows;
    }
}
