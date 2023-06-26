package eajufrn.fruitsystem2.controllers;



import eajufrn.fruitsystem2.domain.Fruta;
import eajufrn.fruitsystem2.service.FrutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/fruta")
public class FrutaController {

    private FrutaService frutaService;

    public FrutaController(FrutaService frutaService) {
        this.frutaService = frutaService;
    }


    @GetMapping("/listar")
    public List<Fruta> listar(){
        return this.frutaService.listarFrutas();
    }



}
