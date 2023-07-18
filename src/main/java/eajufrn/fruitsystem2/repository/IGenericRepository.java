package eajufrn.fruitsystem2.repository;

import eajufrn.fruitsystem2.domain.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface IGenericRepository<E extends AbstractEntity> extends JpaRepository<E,Long>, PagingAndSortingRepository<E, Long> {

}