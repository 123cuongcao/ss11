package com.example.demo10.dao;

import java.util.List;

public interface IGenericDao<T,E> {
    boolean add(T t);
    List<T> findWord(E e);
}
