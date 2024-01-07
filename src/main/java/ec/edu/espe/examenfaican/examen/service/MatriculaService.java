package ec.edu.espe.examenfaican.examen.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.examenfaican.examen.dao.AlumnoAsignaturaRepository;
import ec.edu.espe.examenfaican.examen.dao.AlumnoRepository;
import ec.edu.espe.examenfaican.examen.dao.AsignaturaRepository;
import ec.edu.espe.examenfaican.examen.domain.Alumno;
import ec.edu.espe.examenfaican.examen.domain.AlumnoAsignatura;
import ec.edu.espe.examenfaican.examen.domain.AlumnoAsignaturaPK;
import ec.edu.espe.examenfaican.examen.domain.Asignatura;
import ec.edu.espe.examenfaican.examen.service.exception.CreateException;

@Service
public class MatriculaService {

    private final AlumnoRepository alumnoRepository;
    private final AsignaturaRepository asignaturaRepository;
    private final AlumnoAsignaturaRepository alumnoAsignaturaRepository;

    public MatriculaService(AlumnoRepository alumnoRepository, AsignaturaRepository asignaturaRepository,
            AlumnoAsignaturaRepository alumnoAsignaturaRepository) {
        this.alumnoRepository = alumnoRepository;
        this.asignaturaRepository = asignaturaRepository;
        this.alumnoAsignaturaRepository = alumnoAsignaturaRepository;
    }

    public AlumnoAsignatura matricularAlumnoEnAsignatura(Integer codAlumno, String codAsignatura,
            AlumnoAsignatura matricula) {
        Alumno alumno = validarExistenciaAlumno(codAlumno);
        Asignatura asignatura = validarExistenciaAsignatura(codAsignatura);

        validarMatriculaExistente(codAlumno, codAsignatura);

        matricula.setAlumno(alumno);
        matricula.setAsignatura(asignatura);

        try {
            return alumnoAsignaturaRepository.save(matricula);
        } catch (Exception e) {
            throw new CreateException("Error al matricular al alumno en la asignatura: " + e.getMessage(), e);
        }
    }

    private Alumno validarExistenciaAlumno(Integer codAlumno) {
        Optional<Alumno> alumnoOptional = alumnoRepository.findById(codAlumno);
        return alumnoOptional
                .orElseThrow(() -> new CreateException("El alumno con código " + codAlumno + " no existe."));
    }

    private Asignatura validarExistenciaAsignatura(String codAsignatura) {
        Optional<Asignatura> asignaturaOptional = asignaturaRepository.findById(codAsignatura);
        return asignaturaOptional
                .orElseThrow(() -> new CreateException("La asignatura con código " + codAsignatura + " no existe."));
    }

    private void validarMatriculaExistente(Integer codAlumno, String codAsignatura) {
        AlumnoAsignaturaPK matriculaId = new AlumnoAsignaturaPK(codAlumno, codAsignatura);
        Optional<AlumnoAsignatura> matriculaExistente = alumnoAsignaturaRepository.findById(matriculaId);
        if (matriculaExistente.isPresent()) {
            throw new CreateException("El alumno ya está matriculado en la asignatura.");
        }
    }
}
