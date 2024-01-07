package ec.edu.espe.examenfaican.examen.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.examenfaican.examen.domain.AlumnoAsignatura;
import ec.edu.espe.examenfaican.examen.service.MatriculaService;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    private final MatriculaService matriculaService;

    public MatriculaController(MatriculaService matriculaService) {
        this.matriculaService = matriculaService;
    }

    @PostMapping("/alumno/{codAlumno}/asignatura/{codAsignatura}")
    public ResponseEntity<AlumnoAsignatura> matricularAlumnoEnAsignatura(
            @PathVariable Integer codAlumno,
            @PathVariable String codAsignatura,
            @RequestBody AlumnoAsignatura matricula) {
        try {
            AlumnoAsignatura nuevaMatricula = matriculaService.matricularAlumnoEnAsignatura(codAlumno, codAsignatura, matricula);
            return new ResponseEntity<>(nuevaMatricula, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
