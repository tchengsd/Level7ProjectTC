package org.jointheleague.api.unisearch.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.jointheleague.api.unisearch.repository.LocRepository;
import org.jointheleague.api.unisearch.repository.dto.Result;
import org.jointheleague.api.unisearch.repository.dto.LocResponse;

@Service
public class LocService {
    private final LocRepository locRepository;

    public LocService(LocRepository locR) {
        locRepository = locR;
    }
    public List<Result> getResults(String query){
        return locRepository.getResults(query);
    }
}