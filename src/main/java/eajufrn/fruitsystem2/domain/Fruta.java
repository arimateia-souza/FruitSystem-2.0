package eajufrn.fruitsystem2.domain;

import eajufrn.fruitsystem2.controllers.FrutaController;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
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
@Entity
@Data
//@SQLDelete(sql = "UPDATE fruta SET deleted_at = CURRENT_TIMESTAMP WHERE id=?")
//@Where(clause = "deleted_at is null")
@NoArgsConstructor
@AllArgsConstructor
//@Table(name = "Frutas")
public class Fruta extends AbstractEntity{

    private String nome;
    private String descricao;
    private String categoria;
    private Double preco;

    @Override
    public void partialUpdate(AbstractEntity e) {
        if (e instanceof Fruta fruta){
            this.nome = fruta.nome;
            this.descricao = fruta.descricao;
            this.preco = fruta.preco;

        }
    }



    // ---------------------------------------- DTO Request ------------------------------------------------------------
    @Data
    public static class DtoRequest{//aceita apenas nome, descrição, preço e categoria por exemplo:
        @NotBlank(message = "'Fruta' com nome em branco")
        private String nome;
        @NotBlank
        @Size(max = 255, min = 8)
        private String descricao;

        @NotBlank(message = "Selecione uma categoria")
        private String categoria;
        //String imagemUri;

        //@NotNull(message = "'Preço' não pode ser nulo") - notnull nao funciona pra double, precisa criar um validador personaliado
        private Double preco;

        public static Fruta convertToEntity(DtoRequest dto, ModelMapper mapper){
            return mapper.map(dto, Fruta.class);
        }

    }
    // ---------------------------------------- DTO Response -----------------------------------------------------------
    @Data
    public static class DtoResponse extends RepresentationModel<DtoResponse> {
        String nome;
        String descricao;
        String categoria;
        Double preco;

        public static DtoResponse convertToDto(Fruta f, ModelMapper mapper){
            return mapper.map(f, DtoResponse.class); //retorna apenas os atributos do response


        }
        // -------------------------------------------- HATEOAS --------------------------------------------------------
        public void generateLinks(Long id){
            add(linkTo(FrutaController.class).slash(id).withSelfRel());
            add(linkTo(FrutaController.class).withRel("Fruta"));
            add(linkTo(FrutaController.class).withRel("Cadastrar"));
            add(linkTo(FrutaController.class).slash(id).withRel("Atualizar")); // o método slash add o id e o withRel add uma relação ao link
            add(linkTo(FrutaController.class).withRel("Listar"));
            add(linkTo(FrutaController.class).slash(id).withRel("Deletar"));
        }

    }

}
