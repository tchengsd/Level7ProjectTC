package org.jointheleague.api.unisearch.presentation;

import org.jointheleague.api.unisearch.repository.dto.Result;
import org.jointheleague.api.unisearch.service.LocService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(LocController.class)
public class LocControllerIntTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LocService locService;

    @Test
    public void givenGoodQuery_whenSearchForResults_thenIsOkayAndReturnsResults() throws Exception {
        //given
        String query = "Java";
        Result result = new Result();
        String name = "UNIVERSITY";
        String country = "UNIVERSITY";
        String stateProvince = "UNIVERSITY";
        result.setStateProvince(stateProvince);
        result.setCountry(country);
        result.setName(name);
        Result[] expectedResults = {result};

        when(locService.getResults(query)).thenReturn(expectedResults);
        //when
        //then
        MvcResult mvcResult  = mockMvc.perform(get("/searchLocResults?q=" + query))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", is(name)))
                .andExpect(jsonPath("$[0].state-province", is(stateProvince)))
                .andExpect(jsonPath("$[0].country", is(country)))
                .andReturn();

        assertEquals(MediaType.APPLICATION_JSON_VALUE, mvcResult.getResponse().getContentType());
    }

    @Test
    public void givenBadQuery_whenSearchForResults_thenIsNotFound() throws Exception {
        //given
        String query = "Java";

        //when
        //then
        mockMvc.perform(get("/searchLocResults?q="+query))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}
