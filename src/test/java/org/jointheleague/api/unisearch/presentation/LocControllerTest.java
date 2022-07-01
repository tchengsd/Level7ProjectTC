package org.jointheleague.api.unisearch.presentation;

import org.jointheleague.api.unisearch.service.LocService;
import org.jointheleague.api.unisearch.repository.dto.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class LocControllerTest {
    private LocController controller;
    @Mock
    private LocService service;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
        controller = new LocController(service);
    }

    @Test
    void givenGoodQuery_whenGetResults_thenReturnListOfResults(){
        //given
        String query = "LEAGUE";
        Result result = new Result();
        result.setCountry("COUNTRY");
        result.setName("UNIVERSITY");
        result.setStateProvince("STATE");
        Result[] expectedResults = {result};

        when(service.getResults(query)).thenReturn(expectedResults);
        //when
        Result[] actualResults = controller.getResults(query);
        //then
        assertEquals(expectedResults, actualResults);
    }

    @Test
    void givenBadQuery_whenGetResults_thenThrowsException() {
        //given
        String query = "game";
        //when

        //then
        Throwable exceptionThrown = assertThrows(ResponseStatusException.class, () -> controller.getResults(query));
        assertEquals(exceptionThrown.getMessage(), "404 NOT_FOUND \"Result(s) not found.\"");
    }
}
