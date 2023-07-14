package eajufrn.fruitsystem2.service;

import eajufrn.fruitsystem2.domain.Fruta;
import eajufrn.fruitsystem2.repository.FrutaRepository;
import org.springframework.stereotype.Service;


@Service
public class FrutaService extends GenericService<Fruta, FrutaRepository> {
    public FrutaService(FrutaRepository repository) {
        super(repository);
    }



}
