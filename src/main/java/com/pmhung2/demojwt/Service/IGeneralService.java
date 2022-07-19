package com.pmhung2.demojwt.Service;

import java.util.Optional;

public interface IGeneralService<T>{
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    T save(T t);

    void removeById(Long id);
}