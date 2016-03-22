package org.com.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author lrvera
 */
@Entity
@TableGenerator(name = "UsuarioGenerator", table = "IdentityGenerator",
        pkColumnName = "name", valueColumnName = "value",
        pkColumnValue = "Usuario", initialValue = 1, allocationSize = 1)
@NamedQueries({@NamedQuery(name = "Usuario.findUsername", query = "SELECT u FROM Usuario u WHERE u.nombreUsuario = :nombreU")})
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(generator = "UsuarioGenerator", strategy = GenerationType.TABLE)
    private Long id;
    @Column(nullable = false, unique = true)
    private String nombreUsuario;
    @Column(nullable = false)
    private String clave;
    private Boolean activo;
    private Boolean bloqueado;
    @Temporal(TemporalType.DATE)
    private Date fechaExpiracion;
    @Temporal(TemporalType.DATE)
    private Date fechaRenovacionClave;
    @Transient
    private String claveLimpia;
    @Transient
    private String direccionIp;
    
//    RELACIONES
    
    @ManyToMany(mappedBy = "usuarios")
    private List<Rol>roles;
    
//    CONSTRUCTOR

    public Usuario(Long id, String nombreUsuario, String clave, Boolean activo, Boolean bloqueado, Date fechaExpiracion, Date fechaRenovacionClave, String claveLimpia, String direccionIp, Persona persona) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.clave = clave;
        this.activo = activo;
        this.bloqueado = bloqueado;
        this.fechaExpiracion = fechaExpiracion;
        this.fechaRenovacionClave = fechaRenovacionClave;
        this.claveLimpia = claveLimpia;
        this.direccionIp = direccionIp;
        this.persona = persona;
    }

    public Usuario() {
        this.roles = new ArrayList<>();
    }

//    RELACIONES
    
    @ManyToOne
    private Persona persona;
    
//    GETTERS Y SETTERS
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Boolean getBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(Boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(Date fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public Date getFechaRenovacionClave() {
        return fechaRenovacionClave;
    }

    public void setFechaRenovacionClave(Date fechaRenovacionClave) {
        this.fechaRenovacionClave = fechaRenovacionClave;
    }

    public String getClaveLimpia() {
        return claveLimpia;
    }

    public void setClaveLimpia(String claveLimpia) {
        this.claveLimpia = claveLimpia;
    }

    public String getDireccionIp() {
        return direccionIp;
    }

    public void setDireccionIp(String direccionIp) {
        this.direccionIp = direccionIp;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
//    METODOS
    
    public void addRol(Rol rol){
        if(rol!=null && !roles.contains(rol)){
            roles.add(rol);
            rol.addUsuario(this);
        }
    }
    
    public void deleteRol(Rol rol){
        if(rol!=null && roles.contains(rol)){
            roles.remove(rol);
            rol.deleteUsuario(this);
        }
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        hash = 71 * hash + Objects.hashCode(this.nombreUsuario);
        hash = 71 * hash + Objects.hashCode(this.clave);
        hash = 71 * hash + Objects.hashCode(this.activo);
        hash = 71 * hash + Objects.hashCode(this.bloqueado);
        hash = 71 * hash + Objects.hashCode(this.fechaExpiracion);
        hash = 71 * hash + Objects.hashCode(this.fechaRenovacionClave);
        hash = 71 * hash + Objects.hashCode(this.claveLimpia);
        hash = 71 * hash + Objects.hashCode(this.direccionIp);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.nombreUsuario, other.nombreUsuario)) {
            return false;
        }
        if (!Objects.equals(this.clave, other.clave)) {
            return false;
        }
        if (!Objects.equals(this.claveLimpia, other.claveLimpia)) {
            return false;
        }
        if (!Objects.equals(this.direccionIp, other.direccionIp)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.activo, other.activo)) {
            return false;
        }
        if (!Objects.equals(this.bloqueado, other.bloqueado)) {
            return false;
        }
        if (!Objects.equals(this.fechaExpiracion, other.fechaExpiracion)) {
            return false;
        }
        if (!Objects.equals(this.fechaRenovacionClave, other.fechaRenovacionClave)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombreUsuario="
                + nombreUsuario + ", clave=" + clave + ", activo="
                + activo + ", bloqueado=" + bloqueado + ", fechaExpiracion="
                + fechaExpiracion + ", fechaRenovacionClave="
                + fechaRenovacionClave + ", claveLimpia=" + claveLimpia
                + ", direccionIp=" + direccionIp + '}';
    }
}
