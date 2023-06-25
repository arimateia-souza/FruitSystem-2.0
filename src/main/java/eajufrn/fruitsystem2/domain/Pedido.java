package eajufrn.fruitsystem2.domain;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {
    @ManyToOne
    @JoinColumn(name = "usuario_ID")
    private Usuario usuario;
    private List<PedidoItem> items;
    private Double total;
}
