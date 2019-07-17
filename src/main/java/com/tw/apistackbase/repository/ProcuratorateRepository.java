package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.Procuratorate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcuratorateRepository extends JpaRepository<Procuratorate , Integer> {
    Procuratorate findByProcuratotateId(int id);
}
