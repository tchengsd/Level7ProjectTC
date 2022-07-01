package org.jointheleague.api.unisearch.repository;

import org.jointheleague.api.unisearch.repository.dto.Result;
import org.springframework.web.reactive.function.client.WebClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class LocRepositoryTest {
    private LocRepository repository;

    @Mock
    private WebClient client;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
        repository = new LocRepository();
    }
}
