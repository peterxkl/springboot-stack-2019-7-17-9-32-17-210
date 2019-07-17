package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.Inquisitor;
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
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class InquisitorRepositoryTest {

    @Autowired
    private InquisitorRepository inquisitorRepository;

    @Before
    public void setUp(){
        List<Inquisitor> inquisitors = new ArrayList<>();
        inquisitors.add(new Inquisitor("Dillon"));
        inquisitors.add(new Inquisitor("Peter"));
        inquisitors.add(new Inquisitor("Kit"));
        inquisitorRepository.saveAll(inquisitors);
    }

    @Test
    public void should_return_Procuratorate_when_query_ProcuratorateId(){
        Inquisitor inquisitor = inquisitorRepository.findByInquisitorId(1);
        assertEquals("Dillon",inquisitor.getInquisitorName());

    }

}