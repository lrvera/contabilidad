package org.com.modelo.conta;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.Transient;

/**
 *
 * @author lrvera
 */
@Entity
@TableGenerator(name = "AsientoContableGenerator", table = "IdentityGenerator",
        pkColumnName = "name", valueColumnName = "value",
        pkColumnValue = "AsientoContable", initialValue = 1, allocationSize = 1)
@NamedQueries({
//    @NamedQuery(name = "AsientoContable.findPlanCuenta", query = "SELECT p FROM PlanDeCuentas p WHERE p.descripcionCuenta = :cod"),
    @NamedQuery(name = "AsientoContable.findPlanCuenta", query = "SELECT p FROM PlanDeCuentas p WHERE UPPER(p.descripcionCuenta) LIKE UPPER(:cod)"),
    @NamedQuery(name = "AsientoContable.findAll", query = "SELECT a FROM AsientoContable a")})
public class AsientoContable implements Serializable {

//    ATRIBUTOS
    @Id
    @GeneratedValue(generator = "AsientoContableGenerator", strategy = GenerationType.TABLE)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    private String descripcion;
//    private double debe;
//    private double haber;
    private String secuencia;
    private TipoDocumento tipoDocumento;
    private String numeroDoc;

    @ManyToOne(fetch = FetchType.LAZY)
    private LibroDiario diario;
    
    @OneToMany(mappedBy = "asientoContable", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaccion> transacciones;
    
    @Transient
    private double saldo;
    
//    @ManyToOne
//    private PlanDeCuentas cuenta;

//    CONSTRUCTOR
    public AsientoContable(Long id, Date fecha, String descripcion, Float debe, Float haber, LibroDiario diario) {
        this.id = id;
        this.fecha = fecha;
        this.descripcion = descripcion;
//        this.debe = debe;
//        this.haber = haber;
        this.diario = diario;
    }

    public AsientoContable() {
    }

//    GETTERS Y SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /*public double getDebe() {
        return debe;
    }

    public void setDebe(double debe) {
        this.debe = debe;
    }

    public double getHaber() {
        return haber;
    }

    public void setHaber(double haber) {
        this.haber = haber;
    }*/
    
    public LibroDiario getDiario() {
        return diario;
    }

    public void setDiario(LibroDiario diario) {
        this.diario = diario;
    }

    public List<Transaccion> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(List<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }
    /*public PlanDeCuentas getCuenta() {
        return cuenta;
    }

    public void setCuenta(PlanDeCuentas cuenta) {
        this.cuenta = cuenta;
    }*/
    
    public String getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(String secuencia) {
        this.secuencia = secuencia;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDoc() {
        return numeroDoc;
    }

    public void setNumeroDoc(String numeroDoc) {
        this.numeroDoc = numeroDoc;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

//    METODOS
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.id);
        hash = 43 * hash + Objects.hashCode(this.fecha);
        hash = 43 * hash + Objects.hashCode(this.descripcion);
//        hash = 43 * hash + Objects.hashCode(this.debe);
//        hash = 43 * hash + Objects.hashCode(this.haber);
        hash = 43 * hash + Objects.hashCode(this.diario);
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
        final AsientoContable other = (AsientoContable) obj;
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
//        if (!Objects.equals(this.debe, other.debe)) {
//            return false;
//        }
//        if (!Objects.equals(this.haber, other.haber)) {
//            return false;
//        }
        if (!Objects.equals(this.diario, other.diario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AsientoContable{" + "id=" + id + ", fecha=" + fecha + ", descripcion=" + descripcion + ", secuencia=" + secuencia + ", tipoDocumento=" + tipoDocumento + ", diario=" + diario + ", transacciones=" + transacciones + '}';
    }
    
    
    
}
