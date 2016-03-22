package org.com.modelo.conta;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;

/**
 *
 * @author lrvera
 */
@Entity
@TableGenerator(name = "LibroDiarioGenerator", table = "IdentityGenerator",
        pkColumnName = "name", valueColumnName = "value",
        pkColumnValue = "LibroDiario", initialValue = 1, allocationSize = 1)
@NamedQueries({
    @NamedQuery(name = "LibroDiario.findAll", query = "SELECT l FROM LibroDiario l")})
public class LibroDiario implements Serializable {

//    ATRIBUTOS
    @Id
    @GeneratedValue(generator = "LibroDiarioGenerator", strategy = GenerationType.TABLE)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    private boolean abierto;
//    private String numDocumento;
    private String descripcion;
    @OneToMany(mappedBy = "diario")
    private List<AsientoContable> asientos;

//    CONSTRUCTOR
    public LibroDiario(Long id, List<AsientoContable> asientos) {
        this.id = id;
        this.asientos = asientos;
    }

    public LibroDiario() {
    }

//    GETTERS Y SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<AsientoContable> getAsientos() {
        return asientos;
    }

    public void setAsientos(List<AsientoContable> asientos) {
        this.asientos = asientos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean isAbierto() {
        return abierto;
    }

    public void setAbierto(boolean abierto) {
        this.abierto = abierto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /*public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }*/
//    METODOS
    public void addAsiento(AsientoContable asiento) {
        if (asiento != null && !asientos.contains(asiento)) {
            asientos.add(asiento);
            asiento.setDiario(this);
        }
    }

    public void deleteAsiento(AsientoContable asiento) {
        if (asiento != null && asientos.contains(asiento)) {
            asientos.remove(asiento);
            asiento.setDiario(null);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.asientos);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LibroDiario other = (LibroDiario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.asientos, other.asientos)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LibroDiario{" + "id=" + id + ", fecha=" + fecha + ", abierto=" + abierto + ", descripcion=" + descripcion + ", asientos=" + asientos + '}';
    }

}
