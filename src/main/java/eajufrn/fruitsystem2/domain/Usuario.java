package eajufrn.fruitsystem2.domain;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Usuario extends AbstractEntity {


    private String nome;
    private String cpf;
    private String login;
    private String senha;
    private String email;
    private boolean isAdmin = false;

    //private Endereco endereco;



}
