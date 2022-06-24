package org.jointheleague.api.unisearch.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import org.jointheleague.api.unisearch.repository.dto.Result;
import org.jointheleague.api.unisearch.repository.dto.LocResponse;

@Repository
public class LocRepository {
    private final WebClient webClient;
    private static final String baseUrl = "http://universities.hipolabs.com/search";

    public LocRepository() {
        webClient = WebClient.builder().baseUrl(baseUrl).build();
    }
    public List<Result> getResults(String query) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("name",query)
                        .build()
                ).retrieve()
                .bodyToMono(LocResponse.class)
                .block().getResults();
    }
}
