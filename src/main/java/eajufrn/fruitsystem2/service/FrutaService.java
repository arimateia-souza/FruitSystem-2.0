package eajufrn.fruitsystem2.service;

import eajufrn.fruitsystem2.domain.Fruta;
import eajufrn.fruitsystem2.repository.FrutaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FrutaService extends GenericService<Fruta, FrutaRepository> {
    public FrutaService(FrutaRepository repository) {
        super(repository);
    }


    public List<Fruta> listarFrutas(){
        return repository.findAll();
    }
}
