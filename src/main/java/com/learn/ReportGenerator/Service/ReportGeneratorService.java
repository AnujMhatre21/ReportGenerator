package com.learn.ReportGenerator.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.learn.ReportGenerator.Entity.ReportDropDown;

public interface ReportGeneratorService {

	public List<ReportDropDown> getAllReport();

	public ResponseEntity<String> runSHScript(String filename);
}
