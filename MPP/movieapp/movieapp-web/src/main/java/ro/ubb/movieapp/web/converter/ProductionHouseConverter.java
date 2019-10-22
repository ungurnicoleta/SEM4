package ro.ubb.movieapp.web.converter;

import ro.ubb.movieapp.core.model.Movie;
import ro.ubb.movieapp.core.model.ProductionHouse;
import ro.ubb.movieapp.web.dto.MovieDto;
import ro.ubb.movieapp.web.dto.ProductionHouseDto;

public class ProductionHouseConverter extends BaseConverter<ProductionHouse, ProductionHouseDto> {

    @Override
    public ProductionHouse convertDtoToModel(ProductionHouseDto dto) {
        return null;
    }

    @Override
    public ProductionHouseDto convertModelToDto(ProductionHouse productionHouse) {
        return null;
    }
}
