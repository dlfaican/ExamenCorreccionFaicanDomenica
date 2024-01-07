package ec.edu.espe.examenfaican.examen.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import ec.edu.espe.examenfaican.examen.domain.AlumnoAsignatura;
import ec.edu.espe.examenfaican.examen.domain.AlumnoAsignaturaPK;

public interface AlumnoAsignaturaRepository extends CrudRepository<AlumnoAsignatura, AlumnoAsignaturaPK> {
    List<AlumnoAsignatura> findByCodAlumno(Integer codAlumno);
}