package eajufrn.fruitsystem2.controllers;



import eajufrn.fruitsystem2.domain.Fruta;
import eajufrn.fruitsystem2.service.FrutaService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
    public Fruta.DtoResponse cadastrar(@RequestBody Fruta.DtoRequest f){

        Fruta fruta = this.frutaService.create(Fruta.DtoRequest.convertToEntity(f, mapper));

        Fruta.DtoResponse response = Fruta.DtoResponse.convertToDto(fruta, mapper);

        return response;
    }


    @GetMapping
    public List<Fruta> listar(){
        return this.frutaService.list();
    }



}
