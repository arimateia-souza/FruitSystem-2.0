package eajufrn.fruitsystem2.domain;

import eajufrn.fruitsystem2.controllers.PedidoController;
import eajufrn.fruitsystem2.controllers.UsuarioController;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@Table(name = "Usuarios")
//@SQLDelete(sql = "UPDATE usuario SET deletedAt = CURRENT_TIMESTAMP WHERE id=?")
//@Where(clause = "deletedAt is null")
public class Usuario extends AbstractEntity {

    @NotBlank
    private String nome;
    @NotNull
    private String login;
    @NotNull
    private String senha;
    private boolean isAdmin = false;

    // Relacionamento 1 para 1 entre usuário e endereço
    @OneToOne(mappedBy = "usuario") // na classe Endereço temos a propriedade chamada usuário, o mapeamento é feito aqui
    private Endereco endereco;

    @Override
    public void partialUpdate(AbstractEntity e) {

    }


    // ---------------------------------------- DTO Request ------------------------------------------------------------
    @Data
    public static class DtoRequest{
        @NotBlank
        private String nome;
        @NotNull
        private String login;
        @NotNull
        private String senha;


        public static Usuario convertToEntity(DtoRequest dto, ModelMapper mapper) {
            return mapper.map(dto, Usuario.class);
        }

    }

    // ---------------------------------------- DTO Response -----------------------------------------------------------
    @Data
    public static class DtoResponse extends RepresentationModel<DtoResponse> {
        private String nome;
        private String login;
        private String senha;

        public static DtoResponse convertToDto(Usuario u, ModelMapper mapper) {
            return mapper.map(u, DtoResponse.class);
        }

        // ----------------------------------------------- HATEOAS -----------------------------------------------------
            public void generateLinks(Long id){
                add(linkTo(UsuarioController.class).slash(id).withSelfRel());
                add(linkTo(UsuarioController.class).withRel("Usuário"));
                add(linkTo(UsuarioController.class).withRel("Cadastrar"));
                add(linkTo(UsuarioController.class).slash(id).withRel("Atualizar"));
                add(linkTo(UsuarioController.class).withRel("Listar"));
                add(linkTo(UsuarioController.class).slash(id).withRel("Deletar"));
            }


    }
}
