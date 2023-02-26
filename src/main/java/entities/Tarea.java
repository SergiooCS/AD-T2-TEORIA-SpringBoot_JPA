package entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;

@Entity
@Table(name = "tarea")
@Data // LOMBOK -> ToString, Getters/Setters, etc.
@NoArgsConstructor // LOMBOK -> NOS CREA UN CONSTRUCTOR VACIO.
@AllArgsConstructor // LOMBOK -> CREA UN CONSTRUCTOR QUE RECIBE LOS POSIBLES DATOS.
public class Tarea {
    @Serial // LOMBOK -> PARA INDICAR QUE ES UN SERIAL.
    private static final long serialVersionUID = 1L;

    @Id
    private int id;
    private String nombre;

    private String descripcion;

    private byte estado;

    @ManyToOne
    @JoinColumn(name = "NIF")
    private Usuario usuario;
}
