package eajufrn.fruitsystem2.domain;


import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoItem {
    @ManyToOne
    @JoinColumn(name = "fruta_ID")
    private Fruta fruta;
    private Integer qualidade;
}
