package org.jointheleague.api.game.repository;

import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

@Repository
public class LocRepository {
    private final WebClient webClient;
    private static final String baseUrl = "https://api.igdb.com/v4/games";

    public LocRepository() {
        webClient = WebClient.builder().baseUrl(baseUrl).build();
    }
    public String getResults(String query) {
        return "Searching for games related to " + query;
    }
}
