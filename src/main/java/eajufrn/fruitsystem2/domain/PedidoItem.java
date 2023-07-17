package eajufrn.fruitsystem2.domain;

import eajufrn.fruitsystem2.controllers.PedidoController;
import eajufrn.fruitsystem2.controllers.PedidoItemController;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@Table(name = "PedidoItem")
public class PedidoItem extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne // "pedido" indica que cada "PedidoItem" pertence a um único "Pedido"
    private Pedido pedido;

    // Relacionamento N para N entre fruta e pedidoItem
    @ManyToMany
    @JoinTable(
            name = "pedidoItemFruta", // Nome da tabela de junção
            joinColumns = @JoinColumn(name = "pedidoItemId"), // Coluna de junção referente a PedidoItem
            inverseJoinColumns = @JoinColumn(name = "frutaId") // Coluna de junção referente a Fruta
    )
    private List<Fruta> fruta; //  a propriedade "fruta" indica que cada "PedidoItem" está associado a muitas Frutas
    private Integer quantidade;


    // ---------------------------------------- DTO Request ------------------------------------------------------------
    @Data
    public static class DtoRequest {
        @NotNull
        Long id;
        @NotBlank
        Pedido.DtoRequest pedido;
        @NotNull
        List<Fruta.DtoRequest> fruta;
        @NotBlank
        Integer quantidade;


        public static PedidoItem convertToEntity(PedidoItem.DtoRequest dto, ModelMapper mapper) {
            return mapper.map(dto, PedidoItem.class);
        }
    }

        // ---------------------------------------- DTO Response -----------------------------------------------------------
        @Data
        public static class DtoResponse extends RepresentationModel<DtoResponse> {
            Long id;
            Pedido pedido;
            List<Fruta> fruta;
            Integer quantidade;

            public static DtoResponse convertToDto(PedidoItem pi, ModelMapper mapper) {
                return mapper.map(pi, DtoResponse.class);

            }

            // -------------------------------------------- HATEOAS --------------------------------------------------------
            public void generateLinks(Long id) {
                add(linkTo(PedidoItemController.class).slash(id).withSelfRel());
                add(linkTo(PedidoItemController.class).withRel("PedidoItem"));
                add(linkTo(PedidoItemController.class).withRel("Cadastrar"));
                add(linkTo(PedidoItemController.class).slash(id).withRel("Atualizar"));
                add(linkTo(PedidoItemController.class).withRel("Listar"));
                add(linkTo(PedidoItemController.class).slash(id).withRel("Deletar"));
            }

        }
    }
