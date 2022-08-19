package org.jointheleague.api.unisearch.presentation;

import org.jointheleague.api.unisearch.repository.dto.LocResponse;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.jointheleague.api.unisearch.service.LocService;
import org.jointheleague.api.unisearch.repository.dto.Result;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class LocController {
    private final LocService locService;

    public LocController(LocService locS) {
        locService = locS;
    }

    @GetMapping("/searchLocResults")
    @CrossOrigin(origins = "http://localhost:3000")
    @ApiOperation(value = "Searches for universities matching the search term",
            notes = "Response may include multiple Result values.",
            response = Result.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Result(s) found"),
            @ApiResponse(code = 404, message = "Result(s) not found")
    })
    public List<Result> getResults(@RequestParam(value="q") String query){
        List<Result> results = locService.getResults(query);
        if(CollectionUtils.isEmpty(results)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Result(s) not found.");
        }
        return results;
    }
}
