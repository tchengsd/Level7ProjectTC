package org.jointheleague.api.game.service;

import org.springframework.stereotype.Service;
import org.jointheleague.api.game.repository.LocRepository;

@Service
public class LocService {
    private final LocRepository locRepository;

    public LocService(LocRepository locR) {
        locRepository = locR;
    }
    public String getResults(String query){
        return locRepository.getResults(query);
    }
}