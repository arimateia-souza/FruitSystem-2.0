package eajufrn.fruitsystem2.controllers;

import eajufrn.fruitsystem2.domain.PedidoItem;
import eajufrn.fruitsystem2.service.PedidoItemService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/pedidoItem")

public class PedidoItemController {
    private PedidoItemService pedidoItemService;
    ModelMapper mapper;

    public PedidoItemController(PedidoItemService pedidoItemService, ModelMapper mapper) {
        this.pedidoItemService = pedidoItemService;
        this.mapper = mapper;

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PedidoItem.DtoResponse cadastrar(@Valid @RequestBody PedidoItem.DtoRequest pi){

        PedidoItem pedidoItem = this.pedidoItemService.create(PedidoItem.DtoRequest.convertToEntity(pi, mapper));
        PedidoItem.DtoResponse response = PedidoItem.DtoResponse.convertToDto(pedidoItem, mapper);
        response.generateLinks(pedidoItem.getId());

        return response;
    }

    @GetMapping
    public List<PedidoItem.DtoResponse> listar() {

        List<PedidoItem> pedidosItem = this.pedidoItemService.list();

        List<PedidoItem.DtoResponse> response = pedidosItem.stream()
                .map(pedidoItem -> PedidoItem.DtoResponse.convertToDto(pedidoItem, mapper))
                .collect(Collectors.toList());

        return response;
    }
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public PedidoItem.DtoResponse atualizar(@Valid @RequestBody PedidoItem.DtoRequest pedidoItem, @PathVariable Long id) {
        PedidoItem pi = PedidoItem.DtoRequest.convertToEntity(pedidoItem, mapper);
        pi.setId(id); //recebe o mesmo id
        PedidoItem updatedPedidoItem = this.pedidoItemService.update(pi, id);
        PedidoItem.DtoResponse response = PedidoItem.DtoResponse.convertToDto(updatedPedidoItem, mapper);

        return response;
    }
    @DeleteMapping("/{id}")
    public void apagar(@PathVariable Long id){
        this.pedidoItemService.delete(id);

    }

}
