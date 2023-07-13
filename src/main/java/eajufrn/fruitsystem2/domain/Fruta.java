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
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
//@Table(name = "Frutas")
public class Fruta extends AbstractEntity{

    private String nome;
    private String descricao;
    private String categoria;
    private Double preco;

    // ---------------------------------------- DTO Request ------------------------------------------------------------
    @Data
    public static class DtoRequest{//aceita apenas nome, descrição, preço e categoria por exemplo:
        @NotBlank(message = "'Fruta' com nome em branco")
        String nome;
        @NotBlank
        @Size(max = 255, min = 8)
        String descricao;
        @NotNull(message = "'Preço' não pode ser vazio")
        Double preco;
        @NotBlank(message = "Selecione uma categoria")
        String categoria;
        //String imagemUri;

        public static Fruta convertToEntity(DtoRequest dto, ModelMapper mapper){
            return mapper.map(dto, Fruta.class);
        }

    }
    // ---------------------------------------- DTO Response -----------------------------------------------------------
    @Data
    public static class DtoResponse extends RepresentationModel<DtoResponse> {
        String nome;
        Double preco;
        String descricao;
        String categoria;
        public static DtoResponse convertToDto(Fruta f, ModelMapper mapper){
            return mapper.map(f, DtoResponse.class); //retorna apenas os atributos do response


        }
        // -------------------------------------------- HATEOAS --------------------------------------------------------
        public void generateLinks(Long id){
            add(linkTo(FrutaController.class).slash(id).withSelfRel());
            add(linkTo(FrutaController.class).withRel("fruta"));
            add(linkTo(FrutaController.class).slash(id).withRel("delete"));
        }

    }

}
