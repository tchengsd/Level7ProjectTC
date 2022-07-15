package org.jointheleague.api.unisearch.repository;

import org.jointheleague.api.unisearch.repository.dto.Result;
import org.springframework.web.reactive.function.client.WebClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.util.UriBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class LocRepositoryTest {
    private LocRepository repository;

    @Mock
    WebClient client;
    
    @Mock
    WebClient.RequestHeadersUriSpec requestHeadersUriSpec;

    @Mock
    WebClient.RequestHeadersSpec requestHeadersSpec;

    @Mock
    WebClient.ResponseSpec responseSpec;

    @Mock
    Mono<Result[]> resultMono;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
        repository = new LocRepository();
    }

    @Test
    void whenGetResults_thenReturnResultsArray() {
        //given
        String query = "Java";
        Result result = new Result();
        result.setCountry("United States");
        result.setStateProvince("OH");
        result.setName("Java University in the very interesting state of Ohio");
        Result[] expectedResults = {result};

        when(client.get())
                .thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.uri((Function<UriBuilder, URI>) any()))
                .thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.retrieve())
                .thenReturn(responseSpec);
        when(responseSpec.bodyToMono(Result[].class))
                .thenReturn(resultMono);
        when(resultMono.block())
                .thenReturn(expectedResults);

        //when
        Result[] actualResults = repository.getResults(query);
        //then
        assertEquals(expectedResults, actualResults);
    }
}


