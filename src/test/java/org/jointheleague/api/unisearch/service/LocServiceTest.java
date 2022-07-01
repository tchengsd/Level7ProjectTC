package org.jointheleague.api.unisearch.service;

import org.jointheleague.api.unisearch.repository.LocRepository;
import org.jointheleague.api.unisearch.repository.dto.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class LocServiceTest {
    private LocService service;
    @Mock
    private LocRepository repository;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
        service = new LocService(repository);
    }

    @Test
    void whenGetResults_thenReturnListOfResults(){
        //given
        String query = "LEAGUE";
        Result result = new Result();
        result.setCountry("COUNTRY");
        result.setName("UNIVERSITY");
        result.setStateProvince("STATE");
        Result[] expectedResults = {result};

        when(repository.getResults(query)).thenReturn(expectedResults);
        //when
        Result[] actualResults = service.getResults(query);
        //then
        assertEquals(expectedResults, actualResults);
    }
}

