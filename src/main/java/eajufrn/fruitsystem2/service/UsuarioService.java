package eajufrn.fruitsystem2.service;

import eajufrn.fruitsystem2.domain.Usuario;
import eajufrn.fruitsystem2.repository.UsuarioRepository;
import org.springframework.stereotype.Service;



@Service
public class UsuarioService extends GenericService<Usuario, UsuarioRepository> {
    public UsuarioService(UsuarioRepository repository){
        super (repository);
    }

    public Usuario getById(Long id) {

            return repository
                    .findById(id)
                    .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o ID: " + id));
        }

    }

