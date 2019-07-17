package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.CaseDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaseDetailRepository extends JpaRepository<CaseDetail , Integer> {

          CaseDetail findByCaseId(int id);
}
