package com.example.demo10.dao;

import com.example.demo10.modal.Word;

import java.util.List;

public interface IWordDao extends IGenericDao<Word,String>{
    List<Word> findAll();
}
