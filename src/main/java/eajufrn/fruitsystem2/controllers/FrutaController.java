package eajufrn.fruitsystem2.controllers;

import eajufrn.fruitsystem2.domain.Fruta;
import eajufrn.fruitsystem2.service.FrutaService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@CrossOrigin(origins = "*")
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
        response.generateLinks(fruta.getId());

        return response;
    }



    @GetMapping
    public ResponseEntity<Page<Fruta.DtoResponse>> listar(Pageable page) {

        //System.out.println(page.toString());

        Page<Fruta.DtoResponse> dtoResponses = frutaService
                .find(page)
                .map(record -> {
                    Fruta.DtoResponse response = Fruta.DtoResponse.convertToDto(record, mapper);
                    response.generateLinks(record.getId());
                    return response;
                });


        return new ResponseEntity<>(dtoResponses, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public Fruta.DtoResponse atualizar(@Valid @RequestBody Fruta.DtoRequest fruta, @PathVariable Long id) {
        Fruta f = Fruta.DtoRequest.convertToEntity(fruta, mapper);

        Fruta updatedFruta = this.frutaService.update(f, id);
        Fruta.DtoResponse response = Fruta.DtoResponse.convertToDto(updatedFruta, mapper);

        return response;
    }
    @DeleteMapping("/{id}")
    public void apagar(@PathVariable Long id){
        this.frutaService.delete(id);
        //System.out.println("Apagou");
    }

}
