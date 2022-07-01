package org.jointheleague.api.unisearch.repository;

import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import org.jointheleague.api.unisearch.repository.dto.Result;

@Repository
public class LocRepository {
    private final WebClient webClient;
    private static final String baseUrl = "http://universities.hipolabs.com/search";

    public LocRepository() {
        webClient = WebClient.builder().baseUrl(baseUrl).build();
    }
    public Result[] getResults(String query) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("name",query)
                        .queryParam("country","United States")
                        .build()
                ).retrieve()
                .bodyToMono(Result[].class)
                .block();
    }
}
