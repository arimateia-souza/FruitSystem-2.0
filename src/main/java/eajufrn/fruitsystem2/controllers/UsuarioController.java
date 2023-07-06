package eajufrn.fruitsystem2.controllers;

import eajufrn.fruitsystem2.domain.Usuario;
import eajufrn.fruitsystem2.service.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import eajufrn.fruitsystem2.domain.Usuario.*;

import java.util.List;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService service;
    private final ModelMapper mapper;

    public UsuarioController(UsuarioService service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario.DtoResponse create(@RequestBody Usuario.DtoRequest u) {
        Usuario usuario = service.create(Usuario.DtoRequest.convertToEntity(u, mapper));
        Usuario.DtoResponse response = Usuario.DtoResponse.convertToDto(usuario, mapper);
        response.generateLinks(usuario.getId());
        return response;
    }

    @GetMapping
    public List<DtoResponse> list() {
        return service.list().stream()
                .map(usuario -> {
                    Usuario.DtoResponse response = Usuario.DtoResponse.convertToDto(usuario, mapper);
                    response.generateLinks(usuario.getId());
                    return response;
                })
                .toList();
    }

    @GetMapping("{id}")
    public Usuario.DtoResponse getById(@PathVariable Long id) {
        Usuario usuario = service.getById(id);
        Usuario.DtoResponse response = Usuario.DtoResponse.convertToDto(usuario, mapper);
        response.generateLinks(usuario.getId());
        return response;
    }

    @PutMapping("{id}")
    public Usuario update(@RequestBody Usuario u, @PathVariable Long id) {
        return service.update(u, id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
    // TESTE UPDATE GIT FORK
}

