package com.learn.ReportGenerator.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learn.ReportGenerator.Entity.ReportDropDown;
import com.learn.ReportGenerator.Repository.ReportGeneratorRepository;
import com.learn.ReportGenerator.Service.ReportGeneratorService;

//@RestController
@Controller
public class ReportGeneratorController {

	@Autowired
	ReportGeneratorService reportGeneratorService;

	@Autowired
	ReportGeneratorRepository reportGeneratorRepository;

	@PostMapping("/submit")
	public String submit(@RequestParam String selectedReport, Model model) {
		ReportDropDown byScriptname = reportGeneratorRepository.findByScriptname(selectedReport);
		ResponseEntity<String> runSHScriptStatus = reportGeneratorService.runSHScript(byScriptname.getScriptname());

		model.addAttribute("message", "You selected: " + byScriptname.getRname());
		return "result";
	}

	@GetMapping("/")
	public String home(Model model) {
		List<ReportDropDown> reports = reportGeneratorService.getAllReport();
		model.addAttribute("reports", reports);
		return "index";
	}
}
