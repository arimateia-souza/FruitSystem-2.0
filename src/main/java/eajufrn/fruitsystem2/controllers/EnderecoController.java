package eajufrn.fruitsystem2.controllers;

import eajufrn.fruitsystem2.domain.Endereco;
import eajufrn.fruitsystem2.service.EnderecoService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    private final EnderecoService enderecoService;
    private final ModelMapper mapper;

    public EnderecoController(EnderecoService enderecoService, ModelMapper mapper) {
        this.enderecoService = enderecoService;
        this.mapper = mapper;
    }



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Endereco.DtoResponse criar(@RequestBody Endereco.DtoRequest e) {
        Endereco endereco = enderecoService.create(Endereco.DtoRequest.convertToEntity(e, mapper));
        Endereco.DtoResponse response = Endereco.DtoResponse.convertToDto(endereco, mapper);
        response.generateLinks(endereco.getId());
        return response;
    }
    @GetMapping
    public List<Endereco.DtoResponse> list() {
        return enderecoService.list().stream()
                .map(endereco -> {
                    Endereco.DtoResponse response = Endereco.DtoResponse.convertToDto(endereco, mapper);
                    response.generateLinks(endereco.getId());
                    return response;
                })
                .toList();
    }

    @DeleteMapping("/{id}")
    public void apagar(@PathVariable Long id){
        this.enderecoService.delete(id);

    }

    @PutMapping("/{id}")
    public Endereco.DtoResponse atualizar(@Valid @RequestBody Endereco.DtoRequest e, @PathVariable Long id){
        Endereco f = Endereco.DtoRequest.convertToEntity(e, mapper);
        f.setId(id); //recebe o mesmo id
        Endereco updatedEndereco = this.enderecoService.update(f, id);
        Endereco.DtoResponse response = Endereco.DtoResponse.convertToDto(updatedEndereco, mapper);

        return response;
    }


}
