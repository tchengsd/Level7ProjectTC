package org.jointheleague.api.unisearch.service;

import org.springframework.stereotype.Service;
import org.jointheleague.api.unisearch.repository.LocRepository;
import org.jointheleague.api.unisearch.repository.dto.Result;

@Service
public class LocService {
    private final LocRepository locRepository;

    public LocService(LocRepository locR) {
        locRepository = locR;
    }
    public Result[] getResults(String query){
        return locRepository.getResults(query);
    }
}