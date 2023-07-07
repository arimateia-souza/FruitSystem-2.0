package eajufrn.fruitsystem2.service;

import org.springframework.stereotype.Service;
import eajufrn.fruitsystem2.domain.Endereco;
import eajufrn.fruitsystem2.repository.EnderecoRepository;


@Service
public class EnderecoService extends GenericService<Endereco, EnderecoRepository> {

    public EnderecoService(EnderecoRepository repository) {
        super(repository);
    }
}

