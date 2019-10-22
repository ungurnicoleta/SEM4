package ro.ubb.movieapp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import ro.ubb.movieapp.core.service.ProductionHouseService;
import ro.ubb.movieapp.web.dto.MovieDto;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    private final ProductionHouseService productionHouseService;

    @Autowired
    public MovieController(ProductionHouseService productionHouseService) {
        this.productionHouseService = productionHouseService;
    }

    @ResponseBody
    public List<MovieDto> getAllMovies() {
        return productionHouseService.getMovies("p1")
                .stream()
                .map(x -> MovieDto
                        .builder()
                        .title(x.getTitle())
                        .description(x.getDescription())
                        .productionHouse(x.getProductionHouse().getName())
                        .build())
                .collect(Collectors.toList());
    }


}
