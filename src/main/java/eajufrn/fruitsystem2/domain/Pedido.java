package eajufrn.fruitsystem2.domain;

import com.fasterxml.jackson.annotation.JsonFormat; // para anotação da data
import eajufrn.fruitsystem2.controllers.FrutaController;
import eajufrn.fruitsystem2.controllers.PedidoController;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.format.annotation.DateTimeFormat; // nao funciona
import org.springframework.hateoas.RepresentationModel;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@Table(name = "Pedidos")
public class Pedido extends AbstractEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String descricao;
    private LocalDateTime dataPedido;
    private Double valorTotal;

    // Relacionamento 1 para N (pedido e pedidoItem)
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL) // o mapeamento do relacionamento é feito pela propriedade "pedido" na classe "PedidoItem"
    private List<PedidoItem> pedidoItem;


    // ---------------------------------------- DTO Request ------------------------------------------------------------

    @Data
    public static class DtoRequest{
        @NotBlank(message = " Descrição não estar vazia ou em branco")
        String descricao;
        @NotNull(message = "A data não pode ser nula")
        @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy") // Anotação em jackson para especificar a anotação da data pq o localdate nao funcionou
        LocalDate dataPedido;

//        @NotBlank
        List<PedidoItem> itens;

        public static Pedido convertToEntity(Pedido.DtoRequest dto, ModelMapper mapper){
            return mapper.map(dto, Pedido.class);
        }

    }

    // ---------------------------------------- DTO Response -----------------------------------------------------------
    @Data
    public static class DtoResponse extends RepresentationModel<Pedido.DtoResponse> {

        String descricao;
        LocalDate dataPedido;
        List<PedidoItem> itens;

        public static Pedido.DtoResponse convertToDto(Pedido pedido, ModelMapper mapper){
            return mapper.map(pedido, Pedido.DtoResponse.class);


        }
        // -------------------------------------------- HATEOAS --------------------------------------------------------
        public void generateLinks(Long id){
            add(linkTo(PedidoController.class).slash(id).withSelfRel());
            add(linkTo(PedidoController.class).withRel("Pedido"));
            add(linkTo(PedidoController.class).withRel("Cadastrar"));
            add(linkTo(PedidoController.class).slash(id).withRel("Atualizar"));
            add(linkTo(PedidoController.class).withRel("Listar"));
            add(linkTo(PedidoController.class).slash(id).withRel("Deletar"));
        }

    }
}


