package com.learn.ReportGenerator.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
//@Table(name = "logtable")
public class StatusTable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numid;

	private String processname;

	private String status;

	public String getProcessname() {
		return processname;
	}

	public void setProcessname(String processname) {
		this.processname = processname;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getNumid() {
		return numid;
	}

	public void setNumid(Long numid) {
		this.numid = numid;
	}

}
