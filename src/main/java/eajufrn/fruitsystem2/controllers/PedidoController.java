package eajufrn.fruitsystem2.controllers;

import eajufrn.fruitsystem2.domain.Pedido;
import eajufrn.fruitsystem2.service.PedidoService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/pedido")
public class PedidoController {
    private PedidoService pedidoService;
    ModelMapper mapper;

    public PedidoController(PedidoService pedidoService, ModelMapper mapper) {
        this.pedidoService = pedidoService;
        this.mapper = mapper;

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido.DtoResponse cadastrar(@Valid @RequestBody Pedido.DtoRequest f){

        Pedido pedido = this.pedidoService.create(Pedido.DtoRequest.convertToEntity(f, mapper));
        Pedido.DtoResponse response = Pedido.DtoResponse.convertToDto(pedido, mapper);
        response.generateLinks(pedido.getId());

        return response;
    }

    @GetMapping
    public List<Pedido.DtoResponse> listar() {

        List<Pedido> pedidos = this.pedidoService.list();

        List<Pedido.DtoResponse> response = pedidos.stream()
                .map(pedido -> Pedido.DtoResponse.convertToDto(pedido, mapper))
                .collect(Collectors.toList());

        return response;
    }
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public Pedido.DtoResponse atualizar(@Valid @RequestBody Pedido.DtoRequest pedido, @PathVariable Long id) {
        Pedido f = Pedido.DtoRequest.convertToEntity(pedido, mapper);
        f.setId(id);
        Pedido updatePedido = this.pedidoService.update(f, id);
        Pedido.DtoResponse response = Pedido.DtoResponse.convertToDto(updatePedido, mapper);

        return response;
    }
    @DeleteMapping("/{id}")
    public void apagar(@PathVariable Long id){
        this.pedidoService.delete(id);

    }
 }
