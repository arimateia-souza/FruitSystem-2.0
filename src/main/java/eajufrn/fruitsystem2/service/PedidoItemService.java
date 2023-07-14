package eajufrn.fruitsystem2.service;

import org.springframework.stereotype.Service;
import eajufrn.fruitsystem2.domain.PedidoItem;
import eajufrn.fruitsystem2.repository.PedidoItemRepository;


@Service
public class PedidoItemService extends GenericService<PedidoItem, PedidoItemRepository> {
    public PedidoItemService(PedidoItemRepository repository) {
        super(repository);
    }
}
