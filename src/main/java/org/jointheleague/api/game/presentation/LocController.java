package org.jointheleague.api.game.presentation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.jointheleague.api.game.service.LocService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

@RestController
public class LocController {
    private final LocService locService;

    public LocController(LocService locS) {
        locService = locS;
    }

    @GetMapping("/searchLocResults")
    @ApiOperation(value = "Searches for games matching the search term",
            notes = "Response may include multiple Result values.",
            response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Result(s) found")
    })
    public String getResults(@RequestParam(value="q") String query){
        return locService.getResults(query);
    }
}