package eajufrn.fruitsystem2.domain;


import eajufrn.fruitsystem2.controllers.EnderecoController;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import java.util.Objects;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Enderecos")
public class Endereco extends AbstractEntity {

    private String cidade;
    private String rua;

    @OneToOne
    private Usuario usuario;

    @Override
    public void partialUpdate(AbstractEntity e) {

    }

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
        String rua;

        public static Endereco.DtoResponse convertToDto(Endereco endereco, ModelMapper mapper){
            return mapper.map(endereco, Endereco.DtoResponse.class); //retorna apenas os atributos do response


        }

        //---- HATEOAS -------
        public void generateLinks(Long id){
            add(linkTo(EnderecoController.class).slash(id).withSelfRel());
            add(linkTo(EnderecoController.class).withRel("Endereço"));
            add(linkTo(EnderecoController.class).withRel("Cadastrar"));
            add(linkTo(EnderecoController.class).slash(id).withRel("Atualizar"));
            add(linkTo(EnderecoController.class).withRel("Listar"));
            add(linkTo(EnderecoController.class).slash(id).withRel("Deletar"));
        }

    }

}
