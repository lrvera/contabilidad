package org.com.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author lrvera
 */
@Entity
@TableGenerator(name = "PersonaGenerator",
        table = "IdentityGenerator",
        pkColumnName = "name", valueColumnName = "value",
        pkColumnValue = "Persona", initialValue = 1, allocationSize = 1)
public class Persona implements Serializable {

//    ATRIBUTOS
    @Id
    @GeneratedValue(generator = "PersonaGenerator", strategy = GenerationType.TABLE)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date fecha_nacimiento;
    @Enumerated(EnumType.STRING)
    private TipoIdentificacion tipoDocumento;
    @Column(length = 15)
    private String num_documento;
    private String nombres;
    private String apellido_materno;
    private String apellido_paterno;
    @Column(length = 80)
    private String email;
    private String telefono;
    private String direccion;
    
//    RELACIONES
    
    @OneToMany
    private List<Usuario> usuarios;

//    GETTERS Y SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public TipoIdentificacion getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoIdentificacion tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNum_documento() {
        return num_documento;
    }

    public void setNum_documento(String num_documento) {
        this.num_documento = num_documento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
        
//    METODOS
    @Transient
    public String getNombresCompletos(){
        return nombres+" "+apellido_paterno+" "+apellido_materno;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.fecha_nacimiento);
        hash = 67 * hash + Objects.hashCode(this.tipoDocumento);
        hash = 67 * hash + Objects.hashCode(this.num_documento);
        hash = 67 * hash + Objects.hashCode(this.nombres);
        hash = 67 * hash + Objects.hashCode(this.apellido_materno);
        hash = 67 * hash + Objects.hashCode(this.apellido_paterno);
        hash = 67 * hash + Objects.hashCode(this.email);
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
        final Persona other = (Persona) obj;
        if (!Objects.equals(this.num_documento, other.num_documento)) {
            return false;
        }
        if (!Objects.equals(this.nombres, other.nombres)) {
            return false;
        }
        if (!Objects.equals(this.apellido_materno, other.apellido_materno)) {
            return false;
        }
        if (!Objects.equals(this.apellido_paterno, other.apellido_paterno)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.fecha_nacimiento, other.fecha_nacimiento)) {
            return false;
        }
        if (this.tipoDocumento != other.tipoDocumento) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", fecha_nacimiento="
                + fecha_nacimiento + ", tipoDocumento=" + tipoDocumento
                + ", num_documento=" + num_documento + ", nombres=" + nombres
                + ", apellido_materno=" + apellido_materno
                + ", apellido_paterno=" + apellido_paterno + ", email=" + email + '}';
    }

}
