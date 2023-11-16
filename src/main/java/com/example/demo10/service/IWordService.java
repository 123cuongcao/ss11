package com.example.demo10.service;

import com.example.demo10.modal.Word;

import java.util.List;

public interface IWordService extends IGenericService<Word,String>{
    List<Word> findAll();
}
