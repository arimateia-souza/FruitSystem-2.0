package eajufrn.fruitsystem2.controllers;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/fruta")
public class FrutaController {


    @GetMapping
    public String rota(){
        return "API funcionando!";
    }

}
