package org.com.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;

/**
 *
 * @author lrvera
 */
@Entity
@TableGenerator(name = "PermisoGenerator", table = "IdentityGenerator",
        pkColumnName = "name", valueColumnName = "value",
        pkColumnValue = "Permiso", initialValue = 1, allocationSize = 1)
public class Permisos implements Serializable {

//    ATRIBUTOS
    @Id
    @GeneratedValue(generator = "PermisoGenerator", strategy = GenerationType.TABLE)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaExpiracion;
    @Column
    private Boolean visibleDesdeMenu;
    @Enumerated(EnumType.STRING)
    @Column(length = 5)
    private TipoPermiso tipoPermiso;

    @ManyToOne
    private Rol rol;

    @ManyToOne
    @JoinColumn(name = "accion_id")
    private Accion accion;

//    CONSTRUCTOR
    public Permisos(Long id, Date fechaExpiracion, TipoPermiso tipoPermiso, Rol rol, Accion accion) {
        this.id = id;
        this.fechaExpiracion = fechaExpiracion;
        this.tipoPermiso = tipoPermiso;
        this.rol = rol;
        this.accion = accion;
    }

    public Permisos() {
        this.visibleDesdeMenu = Boolean.FALSE;
    }

//    GETTERS Y SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(Date fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public Boolean getVisibleDesdeMenu() {
        return visibleDesdeMenu;
    }

    public void setVisibleDesdeMenu(Boolean visibleDesdeMenu) {
        this.visibleDesdeMenu = visibleDesdeMenu;
    }

    public TipoPermiso getTipoPermiso() {
        return tipoPermiso;
    }

    public void setTipoPermiso(TipoPermiso tipoPermiso) {
        this.tipoPermiso = tipoPermiso;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Accion getAccion() {
        return accion;
    }

    public void setAccion(Accion accion) {
        this.accion = accion;
    }

//    METODOS
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.fechaExpiracion);
        hash = 79 * hash + Objects.hashCode(this.visibleDesdeMenu);
        hash = 79 * hash + Objects.hashCode(this.tipoPermiso);
        hash = 79 * hash + Objects.hashCode(this.rol);
        hash = 79 * hash + Objects.hashCode(this.accion);
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
        final Permisos other = (Permisos) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.fechaExpiracion, other.fechaExpiracion)) {
            return false;
        }
        if (!Objects.equals(this.visibleDesdeMenu, other.visibleDesdeMenu)) {
            return false;
        }
        if (this.tipoPermiso != other.tipoPermiso) {
            return false;
        }
        if (!Objects.equals(this.rol, other.rol)) {
            return false;
        }
        if (!Objects.equals(this.accion, other.accion)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Permisos{" + "id=" + id + ", fechaExpiracion="
                + fechaExpiracion + ", visibleDesdeMenu=" + visibleDesdeMenu
                + ", tipoPermiso=" + tipoPermiso + ", rol=" + rol + ", accion="
                + accion + '}';
    }

}
