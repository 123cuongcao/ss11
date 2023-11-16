package com.example.demo10.serviceimpl;

import com.example.demo10.dao.IWordDao;
import com.example.demo10.daoimpl.WordDao;
import com.example.demo10.modal.Word;
import com.example.demo10.service.IWordService;

import java.util.List;

public class WordService implements IWordService {
    IWordDao wordDao = new WordDao();
    @Override
    public boolean add(Word word) {
        return wordDao.add(word);
    }

    @Override
    public List<Word> findWord(String s) {
        return wordDao.findWord(s);
    }

    @Override
    public List<Word> findAll() {
        return wordDao.findAll();
    }
}
