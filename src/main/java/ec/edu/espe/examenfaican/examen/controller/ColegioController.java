package ec.edu.espe.examenfaican.examen.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.examenfaican.examen.domain.Colegio;
import ec.edu.espe.examenfaican.examen.service.ColegioService;

@RestController
@RequestMapping("/colegio")
public class ColegioController {

   
    private final ColegioService colegioService;

    public ColegioController(ColegioService colegioService) {
        this.colegioService = colegioService;
    }

    @PostMapping("/crear")
    public ResponseEntity<Colegio> crearColegio(@RequestBody Colegio colegio) {
        Colegio nuevoColegio = colegioService.crearColegio(colegio);
        return new ResponseEntity<>(nuevoColegio, HttpStatus.CREATED);
    }

    @GetMapping("/buscar-por-nombre")
    public ResponseEntity<List<Colegio>> obtenerColegiosPorNombre(@RequestParam String patronNombre) {
        List<Colegio> colegios = colegioService.obtenerColegiosPorPatronNombre(patronNombre);
        return new ResponseEntity<>(colegios, HttpStatus.OK);
    }
}
