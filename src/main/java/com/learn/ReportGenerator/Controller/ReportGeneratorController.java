package com.learn.ReportGenerator.Controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.learn.ReportGenerator.Entity.DropdownForm;
import com.learn.ReportGenerator.Entity.ReportDropDown;
import com.learn.ReportGenerator.Entity.StatusTable;
import com.learn.ReportGenerator.Repository.ReportGeneratorRepository;
import com.learn.ReportGenerator.Repository.StatusTableRepository;
import com.learn.ReportGenerator.Service.ReportGeneratorService;

//@RestController
@Controller
public class ReportGeneratorController {

	@Autowired
	ReportGeneratorService reportGeneratorService;

	@Autowired
	ReportGeneratorRepository reportGeneratorRepository;

	@Autowired
	StatusTableRepository statusTableRepository;

//	@PostMapping("/index")
//	public String submit(@RequestParam String selectedReport, Model model, @ModelAttribute DropdownForm dropdownForm) {
//		ReportDropDown byScriptname = reportGeneratorRepository.findByScriptname(selectedReport);
//		ResponseEntity<String> runSHScriptStatus = reportGeneratorService.runSHScript(byScriptname.getScriptname());
//		model.addAttribute("dropdownForm", dropdownForm);
////		model.addAttribute("message", "You selected: " + byScriptname.getRname());
//		return "index";
//	}

//	@GetMapping("/index")
//	public String home(Model model) {
//		List<ReportDropDown> reports = reportGeneratorService.getAllReport();
//		List<StatusTable> alllogs = reportGeneratorService.getAlllogs();
//
//		model.addAttribute("reports", reports);
//		model.addAttribute("logs", alllogs);
//		model.addAttribute("dropdownForm", new DropdownForm());
//
//		return "index";
//	}
//
//	 @GetMapping("/logs")
//	    public String index(Model model) {
//	        model.addAttribute("content", statusTableRepository.findAll());
//	        return "logspage";
//	    }

//	@GetMapping("/fetch-data")
//    @ResponseBody
//    public List<StatusTable> fetchData() {
//        return reportGeneratorService.getAlllogs();
//    }
	@GetMapping("/items")
	public String getReportDropdown(Model model) {
		List<ReportDropDown> all = reportGeneratorRepository.findAll();
		List<StatusTable> alllogs = reportGeneratorService.getAlllogs();
		model.addAttribute("items", all);
		model.addAttribute("logs", alllogs);
		
		return "items";

	}

	@GetMapping("/submit")
	public String submitItem(@RequestParam String reportName) {
		ReportDropDown down = new ReportDropDown();
		down.setRname(reportName);
		return "redirect:/items";
	}

}
