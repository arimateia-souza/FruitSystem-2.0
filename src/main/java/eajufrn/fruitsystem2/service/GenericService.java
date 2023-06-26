package eajufrn.fruitsystem2.service;

import eajufrn.fruitsystem2.domain.AbstractEntity;
import eajufrn.fruitsystem2.repository.IGenericRepository;

public abstract class GenericService<E extends AbstractEntity, R extends IGenericRepository> implements IGenericService<E>{
    R repository;

    public GenericService(R repository) {
        this.repository = repository;
    }




}
