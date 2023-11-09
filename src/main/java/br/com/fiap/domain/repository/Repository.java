package br.com.fiap.domain.repository;

import org.jvnet.hk2.annotations.Contract;

import java.util.List;

@Contract
public interface Repository<T, U> {

    public List<T> findAll();

    public T findById(U id);

    public T persist(T t);

}
