package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.Case;
import com.tw.apistackbase.model.CaseDetail;
import com.tw.apistackbase.model.Inquisitor;
import com.tw.apistackbase.model.Procuratorate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@DataJpaTest
public class ProcuratorateRepositoryTest {
    @Autowired
    private ProcuratorateRepository procuratorateRepository;

    @Autowired
    private InquisitorRepository inquisitorRepository;

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

    @Test
    public void should_add_All_Inquisitor(){
        Set<Inquisitor> inquisitors = new HashSet<>();
        inquisitors.add(new Inquisitor("Dillon"));
        inquisitors.add(new Inquisitor("Peter"));
        inquisitors.add(new Inquisitor("Kit"));
        inquisitorRepository.saveAll(inquisitors);
        Procuratorate procuratorate = new Procuratorate("检察院1");
//        List<Inquisitor> inquisitors1 = inquisitorRepository.findAll();
        procuratorate.setInquisitors(inquisitors);
        assertEquals(3,procuratorate.getInquisitors().size());
    }

}