package cl.praxis.EscuelaRural_JPA.model.service;

import cl.praxis.EscuelaRural_JPA.model.entities.Curso;
import cl.praxis.EscuelaRural_JPA.model.entities.Estudiante;

import java.util.List;

public interface EstudianteService {
    List<Estudiante> findAll();
    Estudiante findOne(int id);

    List<Estudiante> findByCurso(Curso curso);

    boolean update(Estudiante e);
    boolean create(Estudiante e);
    boolean delete(int id);
}
