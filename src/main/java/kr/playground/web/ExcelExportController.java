package kr.playground.web;

import javax.annotation.Resource;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.playground.dto.ExcelExportRequestDto;
import kr.playground.service.ExcelExportService;

@RestController
@RequestMapping("/api/excel")
public class ExcelExportController {

    @Resource(name = "excelExportService")
    private ExcelExportService excelExportService;

    @PostMapping("/export")
    public ResponseEntity<byte[]> export(@RequestBody ExcelExportRequestDto request) {
        byte[] data = excelExportService.export(request);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"playground-export.xlsx\"")
                .contentType(MediaType.parseMediaType(
                        "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                .body(data);
    }
}
