package eajufrn.fruitsystem2.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Enderecos")
public class Endereco extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "O campo 'Cidade' não pode ser vazio")
    private String cidade;
    @NotEmpty(message = "O campo 'Rua' não pode ser vazio")
    private String rua;

    @OneToOne
    private Usuario usuario;
}
