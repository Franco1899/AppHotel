package model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreUsuario;
    private String password;
    private String email;
    // Otros atributos según tus necesidades

    // Constructor por defecto
    public Usuario() {
    }

    // Constructor con todos los atributos
    public Usuario(String nombreUsuario, String password, String email) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.email = email;
    }

    // Getters y setters para todos los atributos
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Otros getters y setters según tus necesidades
}