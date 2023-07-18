package eajufrn.fruitsystem2.repository;

import eajufrn.fruitsystem2.domain.AbstractEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IGenericRepository<E extends AbstractEntity> extends ListCrudRepository<E,Long> {
}