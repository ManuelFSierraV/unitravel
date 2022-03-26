package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass

public class Persona implements Serializable {

    @Id
    @Column( length = 10)
    @EqualsAndHashCode.Include
    private String cedula;

    @Column(nullable = false, length = 200)
    private String nombreCompleto;
}
