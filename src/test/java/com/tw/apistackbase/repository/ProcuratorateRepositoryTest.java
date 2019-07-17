package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.Case;
import com.tw.apistackbase.model.CaseDetail;
import com.tw.apistackbase.model.Procuratorate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@DataJpaTest
public class ProcuratorateRepositoryTest {
    @Autowired
    private ProcuratorateRepository procuratorateRepository;

    @Before
    public void setUp(){
        List<Procuratorate> procuratorates = new ArrayList<>();
        procuratorates.add(new Procuratorate("检察院1"));
        procuratorates.add(new Procuratorate("检察院2"));
        procuratorateRepository.saveAll(procuratorates);
    }

    @Test
    public void should_return_Procuratorate_when_query_ProcuratorateId(){
        Procuratorate procuratorate = procuratorateRepository.findByProcuratotateId(1);
        assertEquals("检察院1",procuratorate.getProcuratotateName());
    }




}