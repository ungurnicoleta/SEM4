package ro.ubb.catalog.web.converter;

import org.springframework.stereotype.Component;
import ro.ubb.catalog.core.model.Discipline;
import ro.ubb.catalog.web.dto.DisciplineDto;

/**
 * author: radu
 */

@Component
public class DisciplineConverter
        extends BaseConverter<Discipline, DisciplineDto> {
    @Override
    public Discipline convertDtoToModel(DisciplineDto dto) {
        Discipline discipline = new Discipline(dto.getTitle());
        discipline.setId(dto.getId());
        return discipline;
    }

    @Override
    public DisciplineDto convertModelToDto(Discipline discipline) {
        DisciplineDto dto = new DisciplineDto(discipline.getTitle());
        dto.setId(discipline.getId());
        return dto;
    }
}
