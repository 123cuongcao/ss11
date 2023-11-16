package com.example.demo10.daoimpl;

import com.example.demo10.dao.IWordDao;
import com.example.demo10.modal.Word;
import com.example.demo10.util.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WordDao implements IWordDao {


    @Override
    public boolean add(Word word) {
        Connection conn = ConnectDB.getConnection();
        try {
            PreparedStatement pre = conn.prepareStatement("insert into tudien(name,image) value(?,?)");
            pre.setString(1, word.getName());
            pre.setString(2, word.getImage());
            pre.executeUpdate();
        } catch (SQLException e) {
            return false;
        } finally {
            ConnectDB.closeConnection(conn);
        }
        return true;
    }

    @Override
    public List<Word> findWord(String s) {
        List<Word> words = new ArrayList<>();
        Connection conn = ConnectDB.getConnection();
        try {
            PreparedStatement pre = conn.prepareStatement("select * from tudien where name like ?");
            pre.setString(1, s);
            pre.executeQuery();
            ResultSet rs = pre.executeQuery();
            if (rs.next()){
                Word w = new Word();
                w.setImage(rs.getString("image"));
                w.setName(rs.getString("name"));
                words.add(w);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return words;
    }

    @Override
    public List<Word> findAll() {
        List<Word> words = new ArrayList<>();
        Connection conn = ConnectDB.getConnection();
        PreparedStatement pre = null;
        try {
            pre = conn.prepareStatement("Select * from tudien ");
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                Word w = new Word();
                w.setName(rs.getString("name"));
                w.setImage(rs.getString("image"));
                words.add(w);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return words;
    }
}
