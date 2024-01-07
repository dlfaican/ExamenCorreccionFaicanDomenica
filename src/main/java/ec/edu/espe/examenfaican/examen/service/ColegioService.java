package ec.edu.espe.examenfaican.examen.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ec.edu.espe.examenfaican.examen.dao.ColegioRepository;
import ec.edu.espe.examenfaican.examen.domain.Colegio;
import ec.edu.espe.examenfaican.examen.service.exception.CreateException;

@Service
public class ColegioService {

    private  final ColegioRepository colegioRepository;
    
    public ColegioService(ColegioRepository colegioRepository) {
        this.colegioRepository = colegioRepository;
    }

    public Colegio crearColegio(Colegio colegio) {
        try {
            return this.colegioRepository.save(colegio);
        } catch (Exception e) {
            throw new CreateException("Error al crear un Colegio: " + colegio.toString(), e);
        }
    }
    
    public List<Colegio> obtenerColegiosPorPatronNombre(String patronNombre) {
        try {
            return this.colegioRepository.findByNombreContainingIgnoreCase(patronNombre);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener colegios por nombre: " + patronNombre, e);
        }
    }
    


    
}
