package eajufrn.fruitsystem2.domain;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fruta extends AbstractEntity{

    private String nome;
    private String descricao;
    private String categoria;
    private Double preco;

}
