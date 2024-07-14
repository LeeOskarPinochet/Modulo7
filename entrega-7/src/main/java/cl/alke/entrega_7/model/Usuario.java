package cl.alke.entrega_7.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name="usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int usuarioId;
    private String nombre;
    private String rut;
    private String password;
    private double saldo;
}
