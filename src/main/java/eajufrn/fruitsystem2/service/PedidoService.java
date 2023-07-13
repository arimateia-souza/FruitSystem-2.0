package eajufrn.fruitsystem2.service;

import eajufrn.fruitsystem2.domain.Pedido;
import eajufrn.fruitsystem2.repository.PedidoRepository;
import org.springframework.stereotype.Service;


@Service
public class PedidoService extends GenericService<Pedido, PedidoRepository> {
    public PedidoService(PedidoRepository repository) {
        super(repository);
    }


}