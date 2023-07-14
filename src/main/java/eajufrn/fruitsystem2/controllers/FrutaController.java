package eajufrn.fruitsystem2.controllers;

import eajufrn.fruitsystem2.domain.Fruta;
import eajufrn.fruitsystem2.service.FrutaService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
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
    public List<Fruta.DtoResponse> listar() {
        //service que lista a entidade(fruta no caso)
        List<Fruta> frutas = this.frutaService.list();
        //
        List<Fruta.DtoResponse> response = frutas.stream()
                .map(fruta -> Fruta.DtoResponse.convertToDto(fruta, mapper))
                .collect(Collectors.toList());

        return response;
    }
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public Fruta.DtoResponse atualizar(@Valid @RequestBody Fruta.DtoRequest fruta, @PathVariable Long id) {
        Fruta f = Fruta.DtoRequest.convertToEntity(fruta, mapper);
        f.setId(id); //recebe o mesmo id
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
