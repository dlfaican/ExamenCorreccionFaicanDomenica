package ec.edu.espe.examenfaican.examen.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class AlumnoAsignaturaPK implements Serializable {
    @Column(name="COD_ALUMNO", nullable = false)
    private Integer codAlumno;
    @Column(name="COD_ASIGNATURA", nullable = false, length = 10)
    private String codAsignatura;

    public AlumnoAsignaturaPK() {
    }

    public AlumnoAsignaturaPK(Integer codAlumno, String codAsignatura) {
        this.codAlumno = codAlumno;
        this.codAsignatura = codAsignatura;
    }

    @Override
    public String toString() {
        return "AlumnoAsignaturaPK [codAlumno=" + codAlumno + ", codAsignatura=" + codAsignatura + "]";
    }
    

}
