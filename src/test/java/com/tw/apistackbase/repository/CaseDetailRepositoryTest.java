package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.Case;
import com.tw.apistackbase.model.CaseDetail;
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
public  class CaseDetailRepositoryTest {
    @Autowired
    private CaseDetailRepository caseDetailRepository;

    @Before
    public void setUp(){
        List<CaseDetail> caseDetails = new ArrayList<>();
        caseDetails.add(new CaseDetail("aaaaa","bbbbb"));
        caseDetails.add(new CaseDetail("ccccc","ddddd"));
        caseDetails.add(new CaseDetail("eeeee","fffff"));
        caseDetailRepository.saveAll(caseDetails);
    }

    @Test
    public void should_return_CaseDetail_By_CaseId(){
        CaseDetail caseDetail = caseDetailRepository.findByCaseId(1);
        assertSame("aaaaa",caseDetail.getSubCondition());
        assertSame("bbbbb",caseDetail.getObCondition());

    }


}