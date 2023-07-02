package eajufrn.fruitsystem2.domain;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

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

    @Data
    public static class DtoRequest{//aceita apenas nome, descrição, preço e categoria por exemplo:
        @NotBlank(message = "Fruta com nome em branco")
        String nome;
        @NotBlank
        @Size(max = 255, min = 8)
        String descricao;
        @NotNull(message = "Preço não pode ser vazio")
        Double preco;
        @NotBlank(message = "Selecione uma categoria")
        String categoria;
        //String imagemUri;

        public static Fruta convertToEntity(DtoRequest dto, ModelMapper mapper){
            return mapper.map(dto, Fruta.class);
        }

    }
    @Data
    public static class DtoResponse extends RepresentationModel<DtoResponse> {
        String nome;
        //Double preco;
        String descricao;
        //String categoria;
        public static DtoResponse convertToDto(Fruta f, ModelMapper mapper){
            return mapper.map(f, DtoResponse.class); //retorna apenas os atributos do response
        }


    }


}
