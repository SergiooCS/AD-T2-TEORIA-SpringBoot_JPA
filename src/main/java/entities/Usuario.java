package entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.util.List;

@Entity
@Table(name = "usuario")
@Data // LOMBOK -> ToString, Getters/Setters, etc.
@NoArgsConstructor // LOMBOK -> NOS CREA UN CONSTRUCTOR VACIO.
@AllArgsConstructor // LOMBOK -> CREA UN CONSTRUCTOR QUE RECIBE LOS POSIBLES DATOS.
public class Usuario {

    @Serial // LOMBOK -> PARA INDICAR QUE ES UN SERIAL.
    private static final long serialVersionUID = 1L;

    @Id
    private String nif;
    private byte activo;
    private String apellidos;
    private String nombre;
    private String pw;

    @OneToMany(mappedBy="usuario")
    private List<Role> roles;
    @OneToMany(mappedBy="usuario")
    private List<Tarea> tareas;
}
