package com.learn.ReportGenerator.Service.Impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.learn.ReportGenerator.Entity.ReportDropDown;
import com.learn.ReportGenerator.Repository.ReportGeneratorRepository;
import com.learn.ReportGenerator.Service.ReportGeneratorService;

@Service
public class ReportGeneratorServiceImpl implements ReportGeneratorService {

	@Autowired
	ReportGeneratorRepository generatorRepository;

	@Override
	public List<ReportDropDown> getAllReport() {
		// TODO Auto-generated method stub
		return generatorRepository.findAll();
	}

	public ResponseEntity<String> runSHScript(String filename) {

		String scriptPath = "/d/Projects/Shell-Scripting/" + filename + ".sh"; //

		// Create a ProcessBuilder
		ProcessBuilder processBuilder = new ProcessBuilder("C:\\Program Files\\Git\\bin\\bash.exe", "-c", scriptPath);

		try {
			// Start the process
			Process process = processBuilder.start();

			// Read the output from the script
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));

			// Output the result
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println("OUTPUT: " + line);

			}

			// Read any errors from the script
			while ((line = errorReader.readLine()) != null) {
				System.err.println("ERROR: " + line);
			}

			// Wait for the process to complete
			int exitCode = process.waitFor();
			System.out.println("Exited with code: " + exitCode);
			if (exitCode == 127) {
				String responseBody = "Resource not found";
				return new ResponseEntity<String>(responseBody, HttpStatus.NOT_FOUND);
			}

		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>(HttpStatus.OK);

	}
}
