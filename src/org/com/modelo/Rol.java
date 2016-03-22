package org.com.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;

/**
 *
 * @author lrvera
 */
@Entity
@TableGenerator(name = "RolGenerator", table = "IdentityGenerator",
        pkColumnName = "name", valueColumnName = "value",
        pkColumnValue = "Rol", initialValue = 1, allocationSize = 1)
public class Rol implements Serializable {

//    ATRIBUTOS
    @Id
    @GeneratedValue(generator = "RolGenerator", strategy = GenerationType.TABLE)
    private Long id;
    private String nombreRol;
    @Column(length = 2147483647, columnDefinition = "TEXT")
    private String descripcion;

    @ManyToMany
    private List<Usuario> usuarios;

    @OneToMany(mappedBy = "rol", cascade = javax.persistence.CascadeType.ALL)
    private List<Permisos> permisos;

//    CONSTRUCTOR
    public Rol(Long id, String nombreRol, String descripcion, List<Usuario> usuarios, List<Permisos> permisos) {
        this.id = id;
        this.nombreRol = nombreRol;
        this.descripcion = descripcion;
        this.usuarios = usuarios;
        this.permisos = permisos;
    }

    public Rol() {
        this.permisos = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

//    GETTERS Y SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Permisos> getPermisos() {
        return permisos;
    }

    public void setPermisos(List<Permisos> permisos) {
        this.permisos = permisos;
    }

//    METODOS
    
    public void addUsuario(Usuario us){
        if(us!=null && !usuarios.contains(us)){
            usuarios.add(us);
            us.addRol(this);
        }
    }
    
    public void deleteUsuario(Usuario us){
        if(us!=null && usuarios.contains(us)){
            usuarios.remove(us);
            us.deleteRol(this);
        }
    }
    
    public void addPermiso(Permisos permiso){
        if(permiso!=null && !permisos.contains(permiso)){
            permisos.add(permiso);
            permiso.setRol(this);
        }
    }
    
    public void deletePermiso(Permisos permiso){
        if(permiso!=null && permisos.contains(permiso)){
            permisos.add(permiso);
            permiso.setRol(null);
        }
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.id);
        hash = 37 * hash + Objects.hashCode(this.nombreRol);
        hash = 37 * hash + Objects.hashCode(this.descripcion);
        hash = 37 * hash + Objects.hashCode(this.usuarios);
        hash = 37 * hash + Objects.hashCode(this.permisos);
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
        final Rol other = (Rol) obj;
        if (!Objects.equals(this.nombreRol, other.nombreRol)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.usuarios, other.usuarios)) {
            return false;
        }
        if (!Objects.equals(this.permisos, other.permisos)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Rol{" + "id=" + id + ", name=" + nombreRol + ", description="
                + descripcion + ", users=" + usuarios + ", permisos=" + permisos + '}';
    }

}
