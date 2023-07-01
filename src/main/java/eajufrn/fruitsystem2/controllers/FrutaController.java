package eajufrn.fruitsystem2.controllers;



import eajufrn.fruitsystem2.domain.Fruta;
import eajufrn.fruitsystem2.service.FrutaService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/fruta")
public class FrutaController {
    private FrutaService frutaService;
    ModelMapper mapper;

    public FrutaController(FrutaService frutaService, ModelMapper mapper) {
        this.frutaService = frutaService;
        this.mapper = mapper;

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Fruta.DtoResponse cadastrar(@Valid @RequestBody Fruta.DtoRequest f){

        Fruta fruta = this.frutaService.create(Fruta.DtoRequest.convertToEntity(f, mapper));
        Fruta.DtoResponse response = Fruta.DtoResponse.convertToDto(fruta, mapper);

        return response;
    }


    @GetMapping
    public List<Fruta.DtoResponse> listar() {
        //service que lista a entidade(fruta no caso)
        List<Fruta> frutas = this.frutaService.list();
        //
        List<Fruta.DtoResponse> response = frutas.stream()
                .map(fruta -> Fruta.DtoResponse.convertToDto(fruta, mapper))
                .collect(Collectors.toList());

        return response;
    }

   /* @PutMapping("/{id}")
    public Fruta atualizar(@PathVariable Long id, @RequestBody Fruta fruta) {
        return ;
    }*/





}
