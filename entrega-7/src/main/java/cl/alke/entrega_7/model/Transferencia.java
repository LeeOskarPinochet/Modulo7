package cl.alke.entrega_7.model;

import jakarta.persistence.*;
import jakarta.persistence.ManyToOne.*;
import lombok.*;

@Entity
@Table(name="transferencia")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name="usuarioEmisor")
    private Usuario emisor;
    @ManyToOne
    @JoinColumn(name="usuarioReceptor")
    private Usuario receptor;
    private int monto;
    private String fecha;

}
