package ec.edu.espe.examenfaican.examen.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.examenfaican.examen.dao.AlumnoRepository;
import ec.edu.espe.examenfaican.examen.dao.ColegioRepository;
import ec.edu.espe.examenfaican.examen.domain.Alumno;
import ec.edu.espe.examenfaican.examen.domain.Colegio;
import ec.edu.espe.examenfaican.examen.service.exception.CreateException;

@Service
public class AlumnoService {

    private final AlumnoRepository alumnoRepository;
    private final ColegioRepository colegioRepository;

    public AlumnoService(AlumnoRepository alumnoRepository, ColegioRepository colegioRepository) {
        this.alumnoRepository = alumnoRepository;
        this.colegioRepository = colegioRepository;
    }

    public Alumno crearAlumno(Alumno alumno) {
        try {
            Optional<Colegio> colegioOptional = colegioRepository.findById(alumno.getCodColegio());
            if (colegioOptional.isEmpty()) {
                throw new RuntimeException("Error, el colegio no se encuentra registrado");
            }

            LocalDate fechaNacimiento = alumno.getFechaNacimiento().toLocalDate();
            LocalDate fechaActual = LocalDate.now();
            if (fechaNacimiento.isAfter(fechaActual)) {
                throw new RuntimeException("Error, la fecha de nacimiento debe ser menor a la fecha actual");
            }

            return alumnoRepository.save(alumno);
        } catch (Exception e) {
            throw new CreateException("Error al crear un Alumno: " + alumno.toString(), e);
        }
    }
}