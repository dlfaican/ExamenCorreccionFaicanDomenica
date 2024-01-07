package ec.edu.espe.examenfaican.examen.dao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ec.edu.espe.examenfaican.examen.domain.AlumnoAsignatura;
import ec.edu.espe.examenfaican.examen.domain.Asignatura;

public interface AsignaturaRepository extends CrudRepository<Asignatura, String> {
    List<AlumnoAsignatura> findByCodAlumno(Integer codAlumno);
}

