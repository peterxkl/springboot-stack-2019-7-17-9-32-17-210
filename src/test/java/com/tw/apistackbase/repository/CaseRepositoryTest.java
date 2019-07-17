package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.Case;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@DataJpaTest
public class CaseRepositoryTest {

    @Autowired
    private CaseRepository caseRepository;

    @Before
    public void setUp(){
        List<Case> cases = new ArrayList<>();
        cases.add(new Case("案件1",new Date().getTime()));
        cases.add(new Case("案件2",new Date().getTime()+1));
        cases.add(new Case("案件3",new Date().getTime()+2));
        caseRepository.saveAll(cases);
    }

    @Test
    public void should_return_Case_when_query_caseid(){
         Case ca = caseRepository.findById(1);
         assertEquals("案件1",ca.getName());
    }



}