package cl.praxis.EscuelaRural_JPA.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "estudiante")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estudiante_id")
    private int id;
    @Column(name = "nombre")
    private String firstName;
    @Column(name = "apellido")
    private String lastName;

    /*Establecer una relación entre la clase Estudiante y la clase Curso*/
    @ManyToOne
    @JoinColumn(name = "curso_id", insertable = true, updatable = true)//esta es la columna curso_id de la clase Estudiante que hace referencia a la llave primaria de la clase Curso
    private Curso curso;


}
