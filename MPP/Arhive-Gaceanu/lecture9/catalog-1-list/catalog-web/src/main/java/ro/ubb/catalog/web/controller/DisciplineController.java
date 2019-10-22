package ro.ubb.catalog.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.ubb.catalog.core.service.DisciplineService;
import ro.ubb.catalog.web.converter.DisciplineConverter;
import ro.ubb.catalog.web.dto.DisciplineDto;

import java.util.ArrayList;
import java.util.List;

/**
 * author: radu
 */

@RestController
public class DisciplineController {

    @Autowired
    private DisciplineService disciplineService;

    @Autowired
    private DisciplineConverter disciplineConverter;

    @RequestMapping(value = "/disciplines", method = RequestMethod.GET)
    List<DisciplineDto> getAllDisciplines() {
        return new ArrayList<>(disciplineConverter.convertModelsToDtos(
                disciplineService.getAllDisciplines()
        ));
    }


}
