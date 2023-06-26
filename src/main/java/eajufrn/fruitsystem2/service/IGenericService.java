package eajufrn.fruitsystem2.service;

import eajufrn.fruitsystem2.domain.AbstractEntity;
import org.springframework.stereotype.Service;
import java.util.List;



public interface IGenericService<E extends AbstractEntity> {

    public E create(E e);
    public E update(E e, Long id);
    public void delete(Long id);
    public List<E> list();
}
