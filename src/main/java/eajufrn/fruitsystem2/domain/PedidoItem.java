package eajufrn.fruitsystem2.domain;

import eajufrn.fruitsystem2.controllers.PedidoItemController;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;
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

    @ManyToOne
    private Pedido pedido;

    @ManyToOne
    private Fruta fruta;
    private Integer quantidade;


    // ---------------------------------------- DTO Request ------------------------------------------------------------
    @Data
    public static class DtoRequest {
        @NotNull
        Long id;
        @NotBlank
        Pedido.DtoRequest pedido;
        @NotNull
        Fruta.DtoRequest fruta;
        @NotBlank
        Integer quantidade;


        public static PedidoItem convertToEntity(PedidoItem.DtoRequest dto, ModelMapper mapper) {
            return mapper.map(dto, PedidoItem.class);
        }
    }

        // ---------------------------------------- DTO Response -----------------------------------------------------------
        @Data
        public static class DtoResponse extends RepresentationModel<DtoResponse> {
            String nome;
            Double preco;
            String descricao;
            String categoria;

            public static DtoResponse convertToDto(PedidoItem pi, ModelMapper mapper) {
                return mapper.map(pi, DtoResponse.class);

            }

            // -------------------------------------------- HATEOAS --------------------------------------------------------
            public void generateLinks(Long id) {
                add(linkTo(PedidoItemController.class).slash(id).withSelfRel());
                add(linkTo(PedidoItemController.class).withRel("pedido"));
                add(linkTo(PedidoItemController.class).slash(id).withRel("delete"));
            }

        }
    }
