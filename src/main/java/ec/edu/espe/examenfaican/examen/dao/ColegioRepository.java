package ec.edu.espe.examenfaican.examen.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ec.edu.espe.examenfaican.examen.domain.Colegio;

public interface ColegioRepository extends CrudRepository<Colegio, Integer> {
    List<Colegio> findByNombreContainingIgnoreCase(String patronNombre);
}
