package ec.edu.espe.examenfaican.examen.domain;

import java.math.BigDecimal;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ASIGNATURA")
public class Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_ASIGNATURA", nullable = false, length = 10)
    private String codAsignatura;

    @Column(name = "NOMBRE", nullable = false, length = 50)
    private String nombre;

    @Column(name = "CREDITOS", nullable = false, precision = 1, scale = 0)
    private BigDecimal creditos;

    @Version
    private Long version;

    public Asignatura() {
    }

    public Asignatura(String codAsignatura) {
        this.codAsignatura = codAsignatura;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codAsignatura == null) ? 0 : codAsignatura.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Asignatura other = (Asignatura) obj;
        if (codAsignatura == null) {
            if (other.codAsignatura != null)
                return false;
        } else if (!codAsignatura.equals(other.codAsignatura))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Asignatura [codAsignatura=" + codAsignatura + ", nombre=" + nombre + ", creditos=" + creditos
                + ", version=" + version + "]";
    }


}
