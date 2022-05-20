package org.jointheleague.api.game.repository;

import org.springframework.stereotype.Repository;


@Repository
public class LocRepository {
    public String getResults(String query){
        return "Searching for games related to " + query;
    }
}
