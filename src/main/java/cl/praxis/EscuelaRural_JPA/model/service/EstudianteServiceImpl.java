package cl.praxis.EscuelaRural_JPA.model.service;

import cl.praxis.EscuelaRural_JPA.model.entities.Curso;
import cl.praxis.EscuelaRural_JPA.model.entities.Estudiante;
import cl.praxis.EscuelaRural_JPA.model.repository.EstudianteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    private final EstudianteRepository repository;

    public EstudianteServiceImpl(EstudianteRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Estudiante> findAll() {
        return repository.findAll();
    }

    @Override
    public Estudiante findOne(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Estudiante> findByCurso(Curso curso) {
        return repository.findByCurso(curso);
    }

    @Override
    public boolean update(Estudiante e) {
        Estudiante result = repository.save(e);
        return true;
    }

    @Override
    public boolean create(Estudiante e) {
        repository.save(e);
        return true;
    }

    @Override
    public boolean delete(int id) {
        boolean exist = repository.existsById(id);
        if(exist){
            repository.deleteById(id);
        }
        return exist;
    }
}
