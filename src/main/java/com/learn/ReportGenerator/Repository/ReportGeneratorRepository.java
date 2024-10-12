package com.learn.ReportGenerator.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.ReportGenerator.Entity.ReportDropDown;

@Repository
public interface ReportGeneratorRepository extends JpaRepository<ReportDropDown, Long> {

	public ReportDropDown findByScriptname(String rname);
}
