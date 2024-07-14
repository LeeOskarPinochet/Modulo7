package cl.alke.entrega_7.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Deposito {
    private int usuarioId;
    private int monto;
    private int medio;
}
