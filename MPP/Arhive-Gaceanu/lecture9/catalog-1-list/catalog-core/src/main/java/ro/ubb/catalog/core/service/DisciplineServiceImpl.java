package ro.ubb.catalog.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ubb.catalog.core.model.Discipline;
import ro.ubb.catalog.core.repository.DisciplineRepository;

import java.util.List;

/**
 * author: radu
 */

@Service
public class DisciplineServiceImpl implements DisciplineService {

    @Autowired
    private DisciplineRepository disciplineRepository;

    @Override
    public List<Discipline> getAllDisciplines() {
        return disciplineRepository.findAll();
    }
}
