package org.com.modelo.conta;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;

/**
 *
 * @author lrvera
 */
@Entity
@TableGenerator(name = "TransaccionGenerator", table = "IdentityGenerator",
        pkColumnName = "name", valueColumnName = "value",
        pkColumnValue = "Transaccion", initialValue = 1, allocationSize = 1)
public class Transaccion implements Serializable {

    @Id
    @GeneratedValue(generator = "TransaccionGenerator", strategy = GenerationType.TABLE)
    private Long id;
    private double debe;
    private double haber;
    @ManyToOne
    private PlanDeCuentas cuenta;
    @ManyToOne
    private AsientoContable asientoContable;

    public Transaccion() {
    }

    public Transaccion(Long id, double debe, double haber, PlanDeCuentas cuenta) {
        this.id = id;
        this.debe = debe;
        this.haber = haber;
        this.cuenta = cuenta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getDebe() {
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
    }

    public PlanDeCuentas getCuenta() {
        return cuenta;
    }

    public void setCuenta(PlanDeCuentas cuenta) {
        this.cuenta = cuenta;
    }

    public AsientoContable getAsientoContable() {
        return asientoContable;
    }

    public void setAsientoContable(AsientoContable asientoContable) {
        this.asientoContable = asientoContable;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.debe) ^ (Double.doubleToLongBits(this.debe) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.haber) ^ (Double.doubleToLongBits(this.haber) >>> 32));
        hash = 59 * hash + Objects.hashCode(this.cuenta);
        hash = 59 * hash + Objects.hashCode(this.asientoContable);
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
        final Transaccion other = (Transaccion) obj;
        if (Double.doubleToLongBits(this.debe) != Double.doubleToLongBits(other.debe)) {
            return false;
        }
        if (Double.doubleToLongBits(this.haber) != Double.doubleToLongBits(other.haber)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.cuenta, other.cuenta)) {
            return false;
        }
        if (!Objects.equals(this.asientoContable, other.asientoContable)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Transaccion{" + "id=" + id + ", debe=" + debe + ", haber=" + haber + ", cuenta=" + cuenta + ", asientoContable=" + asientoContable + '}';
    }

}
