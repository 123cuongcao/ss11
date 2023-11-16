package com.example.demo10.service;

import java.util.List;

public interface IGenericService <T,E>{
    boolean add(T t);
    List<T> findWord(E e);

}
