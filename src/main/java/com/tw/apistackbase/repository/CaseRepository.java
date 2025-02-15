package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.Case;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CaseRepository extends JpaRepository<Case, Integer> {
    Case findById(int id);
    List<Case> findAllByOrderByTimeDesc();
    List<Case> findCasesByName(String name);
    int deleteCaseById(int id);
    List<Case> findAll();
}
