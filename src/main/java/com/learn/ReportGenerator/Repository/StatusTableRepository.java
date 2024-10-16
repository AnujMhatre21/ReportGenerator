package com.learn.ReportGenerator.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.ReportGenerator.Entity.StatusTable;

public interface StatusTableRepository extends JpaRepository<StatusTable, Long> {

}
