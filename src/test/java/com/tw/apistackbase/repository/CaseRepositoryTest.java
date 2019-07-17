package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.Case;
import com.tw.apistackbase.model.CaseDetail;
import com.tw.apistackbase.model.Procuratorate;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CaseRepositoryTest {

    @Autowired
    private CaseRepository caseRepository;

    @Autowired
    private CaseDetailRepository caseDetailRepository;

    @Before
    public void setUp(){
        List<Case> cases = new ArrayList<>();
        cases.add(new Case("案件1",1563369057661l));
        cases.add(new Case("案件2",1563369057662l));
        cases.add(new Case("案件3",1563369057663l));
        caseRepository.saveAll(cases);

        List<CaseDetail> caseDetails = new ArrayList<>();
        caseDetails.add(new CaseDetail("aaaaa","bbbbb"));
        caseDetails.add(new CaseDetail("ccccc","ddddd"));
        caseDetails.add(new CaseDetail("eeeee","fffff"));
        caseDetails.add(new CaseDetail("eeeee","fffff"));
        caseDetails.add(new CaseDetail("eeeee","fffff"));
        caseDetails.add(new CaseDetail("eeeee","fffff"));
        //caseDetailRepository.saveAll(caseDetails);

    }

    @Test
    public void should_return_Case_when_query_caseId(){
         Case ca = caseRepository.findById(1);
         assertEquals("案件1",ca.getName());
    }

    @Test
    public void should_return_AllCase_when_query(){
        List<Case> cases1 = caseRepository.findAllByOrderByTimeDesc();
        assertEquals("案件1",cases1.get(3).getName());
    }

    @Test
    public void should_return_SomeCase_when_query_By_Name(){
        List<Case> cases1 = caseRepository.findCasesByName("案件3");
        assertEquals(2,cases1.size());
    }

    @Test
    public void should_return_number_when_delete_By_Id(){
        int num = caseRepository.deleteCaseById(1);
        assertEquals(1,num);
    }

    @Test
    public void should_return_number_when_add_All_caseDetail(){
        Set<CaseDetail> caseDetails = new HashSet<>();
        caseDetails.add(new CaseDetail("aaaaa","bbbbb"));
        caseDetails.add(new CaseDetail("ccccc","ddddd"));
        caseDetails.add(new CaseDetail("eeeee","fffff"));
        caseDetails.add(new CaseDetail("eeeee","fffff"));
        caseDetails.add(new CaseDetail("eeeee","fffff"));
        caseDetails.add(new CaseDetail("eeeee","fffff"));
        List<Case> cases = caseRepository.findAll();
        cases.get(0).setCaseDetails(caseDetails);
        assertEquals(6,cases.get(0).getCaseDetails().size());
    }

    @Test
    public void should_add_All_Procuratorate(){
        Procuratorate procuratorate = new Procuratorate("检察院1");
        List<Case> cases1 = caseRepository.findAll();
        //cases1.stream().map(x->x.setProcuratorate(procuratorate));
        for(Case case1 : cases1){
            case1.setProcuratorate(procuratorate);
        }
        assertEquals("检察院1",caseRepository.findAll().get(0).getProcuratorate().getProcuratotateName());
    }




}