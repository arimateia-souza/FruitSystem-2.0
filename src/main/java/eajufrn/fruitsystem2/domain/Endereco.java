package eajufrn.fruitsystem2.domain;

import eajufrn.fruitsystem2.controllers.FrutaController;
import eajufrn.fruitsystem2.controllers.UsuarioController;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

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
    private String cidade;
    private String rua;

    @OneToOne
    private Usuario usuario;

    @Data
    public static class DtoRequest{
        @NotEmpty(message = "O campo 'Cidade' não pode ser vazio")
        String cidade;
        @NotEmpty(message = "O campo 'Rua' não pode ser vazio")
        String rua;


        public static Endereco convertToEntity(Endereco.DtoRequest dto, ModelMapper mapper){
            return mapper.map(dto, Endereco.class);
        }

    }


    @Data
    public static class DtoResponse extends RepresentationModel<Endereco.DtoResponse> {
        String cidade;
        Double nome;

        public static Endereco.DtoResponse convertToDto(Endereco endereco, ModelMapper mapper){
            return mapper.map(endereco, Endereco.DtoResponse.class); //retorna apenas os atributos do response


        }

        //---- HATEOAS -------
        /*public void generateLinks(Long id){
            add(linkTo(FrutaController.class).slash(id).withSelfRel());
            add(linkTo(FrutaController.class).withRel("endereco"));
            add(linkTo(FrutaController.class).slash(id).withRel("delete"));
        }*/

    }

}
