package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.Case;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
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
        final List<Case> cases = new ArrayList<>();
        cases.add(new Case("案件1",1563369057661l));
        cases.add(new Case("案件2",1563369057662l));
        cases.add(new Case("案件3",1563369057663l));
        caseRepository.saveAll(cases);
    }

    @Test
    public void should_return_Case_when_query_caseId(){
         Case ca = caseRepository.findById(1);
         assertEquals("案件1",ca.getName());
    }

    @Test
    public void should_return_AllCase_when_query(){
        List<Case> cases1 = caseRepository.findAllByOrderByTimeDesc();
        assertEquals("案件1",cases1.get(2).getName());

    }



}