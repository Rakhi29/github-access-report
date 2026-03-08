
package com.example.githubaccess.controller;

import com.example.githubaccess.model.AccessReport;
import com.example.githubaccess.service.AccessReportService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AccessReportController {

    private final AccessReportService reportService;

    public AccessReportController(AccessReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/access-report")
    public List<AccessReport> getAccessReport() {
        return reportService.generateReport();
    }
}
