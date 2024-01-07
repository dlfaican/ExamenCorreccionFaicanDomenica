package ec.edu.espe.examenfaican.examen.dao;

import org.springframework.data.repository.CrudRepository;

import ec.edu.espe.examenfaican.examen.domain.Alumno;

public interface AlumnoRepository extends CrudRepository<Alumno, Integer> {
    Alumno findByCedula(String cedula);
}
