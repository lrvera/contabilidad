package org.com.modelo.conta;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.TableGenerator;

/**
 *
 * @author lrvera
 */
@Entity
@TableGenerator(name = "PlanDeCuentasGenerator", table = "IdentityGenerator",
        pkColumnName = "name", valueColumnName = "value",
        pkColumnValue = "PlanDeCuentas", initialValue = 1, allocationSize = 1)
@NamedQueries({
    @NamedQuery(name = "PlanCuentas.findAll", query = "SELECT p FROM PlanDeCuentas p"),
    @NamedQuery(name = "PlanDeCuentas.findParent", query = "SELECT p FROM PlanDeCuentas p WHERE p.codigoCuenta = :codPadre")})
public class PlanDeCuentas implements Serializable {

//    ATRIBUTOS
    @Id
    @GeneratedValue(generator = "PlanDeCuentasGenerator", strategy = GenerationType.TABLE)
    private Long id;
    @Column(unique = true)
    private String codigoCuenta;
    private String descripcionCuenta;
    private int nivel;

    @OrderBy("codigoCuenta ASC")
    @OneToMany(mappedBy = "padre", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PlanDeCuentas> cuentas;

    @ManyToOne
    private PlanDeCuentas padre;
//    @OneToMany(mappedBy = "cuenta")
//    private List<AsientoContable> asientos;
    @OneToMany(mappedBy = "cuenta")
    private List<Transaccion> transaccions;

//    CONSTRUCTOR
    public PlanDeCuentas(Long id, String codigoCuenta, String descripcionCuenta, int nivel, PlanDeCuentas padre) {
        this.id = id;
        this.codigoCuenta = codigoCuenta;
        this.descripcionCuenta = descripcionCuenta;
        this.nivel = nivel;
        this.padre = padre;
    }

    public PlanDeCuentas() {
    }
    
//    public PlanDeCuentas(Object o) {
//        o = PlanDeCuentas.this;
//    }

//    public PlanDeCuentas(Long id, String descripcion) {
//        this.id = id;
//        this.descripcionCuenta = descripcion;
//    }

//    GETTERS Y SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoCuenta() {
        return codigoCuenta;
    }

    public void setCodigoCuenta(String codigoCuenta) {
        this.codigoCuenta = codigoCuenta;
    }

    public String getDescripcionCuenta() {
        return descripcionCuenta;
    }

    public void setDescripcionCuenta(String descripcionCuenta) {
        this.descripcionCuenta = descripcionCuenta;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public List<PlanDeCuentas> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<PlanDeCuentas> cuentas) {
        this.cuentas = cuentas;
    }

    public PlanDeCuentas getPadre() {
        return padre;
    }

    public void setPadre(PlanDeCuentas padre) {
        this.padre = padre;
    }

    public List<Transaccion> getTransaccions() {
        return transaccions;
    }

    public void setTransaccions(List<Transaccion> transaccions) {
        this.transaccions = transaccions;
    }

    /*public List<AsientoContable> getAsientos() {
        return asientos;
    }

    public void setAsientos(List<AsientoContable> asientos) {
        this.asientos = asientos;
    }*/
    
//    METODOS
    public void addPlanCuenta(PlanDeCuentas cuenta) {
        if (cuenta != null && !cuentas.contains(cuenta)) {
            cuentas.add(cuenta);
        }
    }
    
    /*public void addAsiento(AsientoContable ac){
        if(ac!=null && !asientos.contains(ac)){
            asientos.add(ac);
            ac.setCuenta(this);
        }
    }
    
    public void deleteAsiento(AsientoContable ac){
        if(ac!=null && asientos.contains(ac)){
            asientos.remove(ac);
            ac.setCuenta(null);
        }
    }*/
    
    public void addTransaccion(Transaccion tr){
        if(tr!=null && !transaccions.contains(tr)){
            transaccions.add(tr);
            tr.setCuenta(this);
        }
    }
    
    public void deleteTransaccion(Transaccion tr){
        if(tr!=null && transaccions.contains(tr)){
            transaccions.remove(tr);
            tr.setCuenta(null);
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.codigoCuenta);
        hash = 59 * hash + Objects.hashCode(this.descripcionCuenta);
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
        final PlanDeCuentas other = (PlanDeCuentas) obj;
        if (!Objects.equals(this.codigoCuenta, other.codigoCuenta)) {
            return false;
        }
        if (!Objects.equals(this.descripcionCuenta, other.descripcionCuenta)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PlanDeCuentas{" + "id=" + id + ", codigoCuenta="
                + codigoCuenta + ", descripcionCuenta=" + descripcionCuenta + '}';
    }
}
